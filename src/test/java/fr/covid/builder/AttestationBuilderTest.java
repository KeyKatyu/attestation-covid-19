package fr.covid.builder;

import com.google.zxing.WriterException;
import fr.covid.Attestation;
import fr.covid.motif.MotifDeplacement;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttestationBuilderTest {

    @Test
    public void shouldReturnAttestation_whenAttestionBuilderSuccess() throws IOException, WriterException {
        var expectedAttestation = new Attestation(
                "Jean",
                "DUPONT",
                LocalDate.of(2000,01, 01),
                "Paris",
                "25 rue du General De Gaulle",
                "Paris",
                75001,
                LocalDate.of(2000,01, 01),
                LocalTime.of(12,00, 00),
                MotifDeplacement.ACHATS);

        assertEquals(expectedAttestation, AttestationBuilder
            .create()
            .prenom("Jean")
            .nom("DUPONT")
            .dateDeNaissance(LocalDate.of(2000,01, 01))
            .lieuDeNaissance("Paris")
            .adresse("25 rue du General De Gaulle")
            .ville("Paris")
            .codePostal(75001)
            .dateDeSortie(LocalDate.of(2000,01, 01))
            .heureDeSortie(LocalTime.of(12,00, 00))
            .motifDeDeplacement(MotifDeplacement.ACHATS)
            .qrCode(false)
            .pdf("")
        );
    }
}
