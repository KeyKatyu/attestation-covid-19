package com.github.afelipez.builder;

import com.github.afelipez.Attestation;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class QRCodeBuilder {

    private final Attestation attestation;

    public QRCodeBuilder(Attestation attestation) {
        this.attestation = Objects.requireNonNull(attestation);
    }

    public PdfBuilder qrCode(boolean enableQRCode) throws WriterException {
        if (enableQRCode) {
            return new PdfBuilder(attestation,
                    generateQRCodeImage(92, 92),
                    generateQRCodeImage(300, 300));
        }
        return new PdfBuilder(attestation, null, null);
    }

    private BufferedImage generateQRCodeImage(int width, int height) throws WriterException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 1);

        BitMatrix bitMatrix = barcodeWriter.encode(formatDataToQRCode(), BarcodeFormat.QR_CODE, width, height, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private String formatDataToQRCode() {
        return String.join(";\n",
                "Cree le: " + creationDateToString() + " a " + creationHourToString(),
                "Nom: " + attestation.getNom(),
                "Prenom: " + attestation.getPrenom(),
                "Naissance: " + attestation.dateNaissanceToString() + " a " + attestation.getLieuNaissance(),
                "Adresse: " + attestation.getAdresse() + " " + attestation.getCodePostal() + " " + attestation.getVille(),
                "Sortie: " + attestation.dateSortieToString() + " a " + attestation.heureSortieToString(),
                "Motifs: " + attestation.getMotifDeplacement().name().toLowerCase() + ";");
    }

    private String creationDateToString() {
        return LocalDate.of(2020, 11, 9)
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(Locale.FRANCE));
    }

    private String creationHourToString() {
        return LocalTime.of(8, 59)
                .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
                .replace(":", "h");
    }

}
