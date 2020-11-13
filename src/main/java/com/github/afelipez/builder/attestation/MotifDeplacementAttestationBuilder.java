package com.github.afelipez.builder.attestation;

import com.github.afelipez.builder.QRCodeBuilder;
import com.github.afelipez.motif.MotifDeplacement;

public interface MotifDeplacementAttestationBuilder {
    QRCodeBuilder motifDeDeplacement(MotifDeplacement motifDeplacement);
}
