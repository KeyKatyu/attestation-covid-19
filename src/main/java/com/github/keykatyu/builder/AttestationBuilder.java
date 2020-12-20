package com.github.keykatyu.builder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.github.keykatyu.Attestation;
import com.github.keykatyu.builder.attestation.AdresseAttestationBuilder;
import com.github.keykatyu.builder.attestation.CodePostalAttestationBuilder;
import com.github.keykatyu.builder.attestation.DateNaissanceAttestationBuilder;
import com.github.keykatyu.builder.attestation.DateSortieAttestationBuilder;
import com.github.keykatyu.builder.attestation.HeureSortieAttestationBuilder;
import com.github.keykatyu.builder.attestation.LieuNaissanceAttestationBuilder;
import com.github.keykatyu.builder.attestation.MotifDeplacementAttestationBuilder;
import com.github.keykatyu.builder.attestation.NomAttestationBuilder;
import com.github.keykatyu.builder.attestation.PrenomAttestationBuilder;
import com.github.keykatyu.builder.attestation.VilleAttestationBuilder;
import com.github.keykatyu.motif.MotifDeplacement;
import com.github.keykatyu.util.FieldValidator;

public class AttestationBuilder implements
        PrenomAttestationBuilder,
        NomAttestationBuilder,
        DateNaissanceAttestationBuilder,
        LieuNaissanceAttestationBuilder,
        AdresseAttestationBuilder,
        VilleAttestationBuilder,
        CodePostalAttestationBuilder,
        DateSortieAttestationBuilder,
        HeureSortieAttestationBuilder,
        MotifDeplacementAttestationBuilder {

    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String adresse;
    private String ville;
    private int codePostal;
    private LocalDate dateSortie;
    private LocalTime heureSortie;
    private MotifDeplacement motifDeplacement;

    private AttestationBuilder() {}

    public static PrenomAttestationBuilder create() throws IOException {
        return new AttestationBuilder();
    }

    @Override
    public NomAttestationBuilder prenom(String prenom) {
        this.prenom = FieldValidator.checkIsAllLetter(prenom);
        return this;
    }

    @Override
    public DateNaissanceAttestationBuilder nom(String nom) throws IOException {
        this.nom = FieldValidator.checkIsAllLetter(nom);
        return this;
    }

    @Override
    public LieuNaissanceAttestationBuilder dateDeNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    @Override
    public AdresseAttestationBuilder lieuDeNaissance(String lieuNaissance) {
        this.lieuNaissance = FieldValidator.checkIsAllLetter(lieuNaissance);
        return this;
    }

    @Override
    public VilleAttestationBuilder adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    @Override
    public CodePostalAttestationBuilder ville(String ville) {
        this.ville = FieldValidator.checkIsAllLetter(ville);
        return this;
    }

    @Override
    public DateSortieAttestationBuilder codePostal(int codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    @Override
    public HeureSortieAttestationBuilder dateDeSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
        return this;
    }

    @Override
    public MotifDeplacementAttestationBuilder heureDeSortie(LocalTime heureSortie) {
        this.heureSortie = heureSortie;
        return this;
    }

    @Override
    public QRCodeBuilder motifDeDeplacement(MotifDeplacement motifDeplacement) {
        this.motifDeplacement = motifDeplacement;
        return new QRCodeBuilder(new Attestation(
                prenom,
                nom,
                dateNaissance,
                lieuNaissance,
                adresse,
                ville,
                codePostal,
                dateSortie,
                heureSortie,
                motifDeplacement));
    }
    
}
