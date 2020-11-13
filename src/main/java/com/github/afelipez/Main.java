package com.github.afelipez;

import com.github.afelipez.builder.AttestationBuilder;
import com.google.zxing.WriterException;
import com.github.afelipez.motif.MotifDeplacement;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws IOException, WriterException {

        Attestation attestation = AttestationBuilder
                .create()
                .prenom("Jean")
                .nom("DUPONT")
                .dateDeNaissance(LocalDate.of(2000, 01, 01))
                .lieuDeNaissance("Paris")
                .adresse("25 rue du General de Gaulle")
                .ville("Paris")
                .codePostal(75001)
                .dateDeSortie(LocalDate.of(2020, 12, 11))
                .heureDeSortie(LocalTime.of(12, 30))
                .motifDeDeplacement(MotifDeplacement.ENFANTS)
                .qrCode(false)
                .pdf(Paths.get("./attestation.pdf"));

        System.out.println(attestation);
    }

}
