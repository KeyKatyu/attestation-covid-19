package fr.covid;

import com.google.zxing.WriterException;
import fr.covid.builder.AttestationBuilder;
import fr.covid.motif.MotifDeplacement;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {

    public static final String PDF_TITLE = "COVID-19 - Déclaration de déplacement";
    public static final String PDF_SUBJECT = "Attestation de déplacement dérogatoire";
    public static final List<String> PDF_KEYWORDS = List.of("covid19", "covid-19", "attestation", "déclaration", "déplacement", "officielle", "gouvernement");
    public static final String PDF_PRODUCER = "DNUM/SDIT";
    public static final String PDF_CREATOR = "";
    public static final String PDF_AUTHOR = "Ministère de l'intérieur";

    public static void main(String[] args) throws IOException, WriterException {

        var attestation = AttestationBuilder
                .create()
                .prenom("Jean")
                .nom("DUPONT")
                .dateDeNaissance(LocalDate.of(2000, 01, 01))
                .lieuDeNaissance("Paris")
                .adresse("25 rue du General de Gaulle")
                .ville("Paris")
                .codePostal(75001)
                .dateDeSortie(LocalDate.of(2020, 12, 11))
                .heureDeSortie(LocalTime.of(12,30))
                .motifDeDeplacement(MotifDeplacement.ENFANTS)
                .qrCode(false)
                .pdf(Path.of("./attestation.pdf"));

        System.out.println(attestation);
    }

}
