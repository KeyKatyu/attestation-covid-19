package fr.covid.builder.attestation;

import java.time.LocalTime;

public interface HeureSortieAttestationBuilder {
    MotifDeplacementAttestationBuilder heureDeSortie(LocalTime heureSortie);
}
