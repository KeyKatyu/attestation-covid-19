package com.github.afelipez;

import com.github.afelipez.motif.MotifDeplacement;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AttestationTest {

    @Test
    public void shouldThrowNPE_whenAttestationConstructorParamIsNull() {
        assertThrows(NullPointerException.class,
                () -> new Attestation(
                        null,
                        "DUPONT",
                        LocalDate.of(2000, 01, 01),
                        "Paris",
                        "25 rue du General De Gaulle",
                        "Paris",
                        75001,
                        LocalDate.of(2000, 01, 01),
                        LocalTime.of(12, 00, 00),
                        MotifDeplacement.ACHATS));
    }

    @Test
    public void shouldSuccess_whenTestAllGetters() {
        Attestation attestationActual = new Attestation(
                "Jean",
                "DUPONT",
                LocalDate.of(2000, 01, 01),
                "Paris",
                "25 rue du General De Gaulle",
                "Paris",
                75001,
                LocalDate.of(2000, 01, 01),
                LocalTime.of(12, 00, 00),
                MotifDeplacement.ACHATS);

        assertEquals("Jean", attestationActual.getPrenom());
        assertEquals("DUPONT", attestationActual.getNom());
        assertEquals(LocalDate.of(2000, 01, 01), attestationActual.getDateNaissance());
        assertEquals("Paris", attestationActual.getLieuNaissance());
        assertEquals("25 rue du General De Gaulle", attestationActual.getAdresse());
        assertEquals(75001, attestationActual.getCodePostal());
        assertEquals(LocalDate.of(2000, 01, 01), attestationActual.getDateSortie());
        assertEquals(LocalTime.of(12, 00, 00), attestationActual.getHeureSortie());
        assertEquals(MotifDeplacement.ACHATS, attestationActual.getMotifDeplacement());

    }
}
