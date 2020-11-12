package fr.covid.builder;

import fr.covid.Attestation;
import fr.covid.motif.MotifDeplacement;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class PdfBuilderTest {

    @Test
    public void shouldThrowNPE_whenPdfBuilderConstructorParamIsNull(){
        assertThrows(NullPointerException.class,
                () -> new PdfBuilder(null, null, null));
    }

    @Test
    public void shouldCreateAPdfFile_whenPdf() throws IOException {
        var path = "./src/test/test.pdf";
        var pdfBuilder = new PdfBuilder(new Attestation(
                "Jean",
                "DUPONT",
                LocalDate.of(2000,01, 01),
                "Paris",
                "25 rue du General De Gaulle",
                "Paris",
                75001,
                LocalDate.of(2000,01, 01),
                LocalTime.of(12,00, 00),
                MotifDeplacement.ACHATS), null, null);

        // Generate PDF
        pdfBuilder.pdf(path);

        // Load generated PDF
        var expectedPdfContent = extractPdfText(new File(path));

        assertTrue(expectedPdfContent.contains("Jean"));
        assertTrue(expectedPdfContent.contains("DUPONT"));
        assertTrue(expectedPdfContent.contains("01/01/2000"));
        assertTrue(expectedPdfContent.contains("Paris"));
        assertTrue(expectedPdfContent.contains("25 rue du General De Gaulle"));
        assertTrue(expectedPdfContent.contains("75001"));
        assertTrue(expectedPdfContent.contains("12:00"));

    }

    private static String extractPdfText(File path) throws IOException {
        try (PDDocument pdfDocument = PDDocument.load(path)) {
            return new PDFTextStripper().getText(pdfDocument);
        }
    }

}
