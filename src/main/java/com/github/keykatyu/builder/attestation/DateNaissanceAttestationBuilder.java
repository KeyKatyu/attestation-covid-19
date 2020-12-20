package com.github.keykatyu.builder.attestation;

import java.time.LocalDate;

public interface DateNaissanceAttestationBuilder {
    LieuNaissanceAttestationBuilder dateDeNaissance(LocalDate dateNaissance);
}