package com.github.afelipez.builder;

import com.github.afelipez.Attestation;
import com.github.afelipez.motif.MotifDeplacement;
import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttestationBuilderTest {

    @Test
    public void shouldReturnAttestation_whenAttestionBuilderSuccess() throws IOException, WriterException {
        Attestation expectedAttestation = new Attestation(
                "Jean",
                "DUPONT",
                LocalDate.of(2000, 1, 1),
                "Paris",
                "25 rue du General De Gaulle",
                "Paris",
                75001,
                LocalDate.of(2000, 1, 1),
                LocalTime.of(12, 0, 0),
                MotifDeplacement.ACHATS);

        assertEquals(expectedAttestation, AttestationBuilder
                .create()
                .prenom("Jean")
                .nom("DUPONT")
                .dateDeNaissance(LocalDate.of(2000, 1, 1))
                .lieuDeNaissance("Paris")
                .adresse("25 rue du General De Gaulle")
                .ville("Paris")
                .codePostal(75001)
                .dateDeSortie(LocalDate.of(2000, 1, 1))
                .heureDeSortie(LocalTime.of(12, 0, 0))
                .motifDeDeplacement(MotifDeplacement.ACHATS)
                .qrCode(false)
                .pdf("./src/test/attestation_test.pdf")
        );
    }
}
