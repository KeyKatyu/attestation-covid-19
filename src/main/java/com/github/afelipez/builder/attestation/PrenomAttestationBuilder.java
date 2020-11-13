package com.github.afelipez.builder.attestation;

import java.io.IOException;

public interface PrenomAttestationBuilder {
    NomAttestationBuilder prenom(String prenom) throws IOException;
}
