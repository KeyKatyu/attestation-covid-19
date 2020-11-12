package fr.covid.builder.attestation;

import fr.covid.builder.QRCodeBuilder;
import fr.covid.motif.MotifDeplacement;

public interface MotifDeplacementAttestationBuilder {
    QRCodeBuilder motifDeDeplacement(MotifDeplacement motifDeplacement);
}
