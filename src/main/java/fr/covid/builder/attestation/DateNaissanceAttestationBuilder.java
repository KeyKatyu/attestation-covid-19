package fr.covid.builder.attestation;

import java.time.LocalDate;

public interface DateNaissanceAttestationBuilder {
    LieuNaissanceAttestationBuilder dateDeNaissance(LocalDate dateNaissance);
}