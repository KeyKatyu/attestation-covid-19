package com.github.keykatyu.builder.attestation;

import java.time.LocalTime;

public interface HeureSortieAttestationBuilder {
    MotifDeplacementAttestationBuilder heureDeSortie(LocalTime heureSortie);
}
