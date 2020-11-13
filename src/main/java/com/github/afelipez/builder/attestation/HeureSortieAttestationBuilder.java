package com.github.afelipez.builder.attestation;

import java.time.LocalTime;

public interface HeureSortieAttestationBuilder {
    MotifDeplacementAttestationBuilder heureDeSortie(LocalTime heureSortie);
}
