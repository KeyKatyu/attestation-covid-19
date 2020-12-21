package com.github.keykatyu.builder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.github.keykatyu.Attestation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class PdfBuilder {

    public static final String TEMPLATE_ATTESTATION_PATH = "./pdf/template_attestation.pdf";
    public static final PDFont DEFAULT_FONT = PDType1Font.HELVETICA;
    public static final int DEFAULT_FONT_SIZE = 11;

    private final Attestation attestation;
    private final BufferedImage smallQRCode;
    private final BufferedImage bigQRCode;

    public PdfBuilder(Attestation attestation, BufferedImage smallQRCode, BufferedImage bigQRCode) {
        this.attestation = Objects.requireNonNull(attestation);
        this.smallQRCode = smallQRCode;
        this.bigQRCode = bigQRCode;
    }

    public Attestation pdf(File path) throws IOException {
        try(PDDocument document = PDDocument.load(Paths.get(TEMPLATE_ATTESTATION_PATH).toFile())) {
            addMetadataTo(document.getDocumentInformation());

            // Page 1
            PDPage page1 = document.getPage(0);
            try(PDPageContentStream contentStreamP1 = new PDPageContentStream(document, page1, PDPageContentStream.AppendMode.APPEND, true)){
                drawAllFieldsTo(contentStreamP1);
                if (smallQRCode != null) drawQRCodeTo(document, contentStreamP1, smallQRCode, (int) page1.getMediaBox().getWidth() - 156, -2, 150, 150);
            }

            //Page 2
            if (bigQRCode != null){
                PDPage page2 = new PDPage(PDRectangle.A4); document.addPage(page2);
                try(PDPageContentStream contentStreamP2 = new PDPageContentStream(document, page2)){
                    drawQRCodeTo(document, contentStreamP2, bigQRCode, 50, (int) page2.getMediaBox().getWidth() - 350, 300, 300);
                }
            }
            document.save(path);
        }
        return attestation;
    }

    public Attestation pdf(Path path) throws IOException {
        pdf(path.toFile());
        return attestation;
    }

    public Attestation pdf(String path) throws IOException {
        pdf(new File(path));
        return attestation;
    }

    private void drawQRCodeTo(PDDocument document, PDPageContentStream contentStream, BufferedImage imgQRCode, int x, int y, int width, int height) throws IOException {
        PDImageXObject img = LosslessFactory.createFromImage(document, imgQRCode);
        contentStream.drawImage(img, x, y, width, height);
    }

    private void drawAllFieldsTo(PDPageContentStream contentStream) throws IOException {
        drawField(contentStream, attestation.getPrenom()+" "+attestation.getNom(),
                119, 660);
        drawField(contentStream, attestation.dateNaissanceToString(),
                119, 630);
        drawField(contentStream, attestation.getLieuNaissance(),
                297, 630);
        drawField(contentStream,attestation.getAdresse()+" "+attestation.getCodePostal()+" "+attestation.getVille(),
                133, 600);
        drawField(contentStream, attestation.getVille(), DEFAULT_FONT, DEFAULT_FONT_SIZE,
                105, 125);
        drawField(contentStream, attestation.dateSortieToString(),
                91, 95);
        drawField(contentStream, attestation.heureSortieToString(),
                264, 95);
        drawField(contentStream,  "x", DEFAULT_FONT,
                18, 58, attestation.getMotifDeplacement().y());
    }

    private void drawField(PDPageContentStream contentStream, String text, int x, int y) throws IOException {
        drawField(contentStream, text, DEFAULT_FONT, DEFAULT_FONT_SIZE, x, y);
    }
    private void drawField(PDPageContentStream contentStream, String text, PDFont font, int fontSize, int x, int y) throws IOException {
        contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(x, y);
            contentStream.showText(text);
            contentStream.newLine();
        contentStream.endText();
    }

    private void addMetadataTo(PDDocumentInformation pdi){
        pdi.setTitle("COVID-19 - Déclaration de déplacement");
        pdi.setSubject("Attestation de déplacement dérogatoire");
        Arrays.asList("covid19", "covid-19", "attestation", "déclaration", "déplacement", "officielle", "gouvernement")
                .forEach(pdi::setKeywords);
        pdi.setProducer("DNUM/SDIT");
        pdi.setCreator("");
        pdi.setAuthor("Ministère de l'intérieur");
    }

}
