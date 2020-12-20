package com.github.afelipez;

import com.github.afelipez.motif.MotifDeplacement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Objects;

public class Attestation {

    private final String prenom;
    private final String nom;
    private final LocalDate dateNaissance;
    private final String lieuNaissance;
    private final String adresse;
    private final String ville;
    private final int codePostal;
    private final LocalDate dateSortie;
    private final LocalTime heureSortie;
    private final MotifDeplacement motifDeplacement;

    public Attestation(String prenom, String nom, LocalDate dateNaissance, String lieuNaissance, String adresse, String ville, int codePostal, LocalDate dateSortie, LocalTime heureSortie, MotifDeplacement motifDeplacement) {
        this.prenom = Objects.requireNonNull(prenom);
        this.nom = Objects.requireNonNull(nom);
        this.dateNaissance = Objects.requireNonNull(dateNaissance);
        this.lieuNaissance = Objects.requireNonNull(lieuNaissance);
        this.adresse = Objects.requireNonNull(adresse);
        this.ville = Objects.requireNonNull(ville);
        this.codePostal = codePostal;
        this.dateSortie = Objects.requireNonNull(dateSortie);
        this.heureSortie = Objects.requireNonNull(heureSortie);
        this.motifDeplacement = Objects.requireNonNull(motifDeplacement);
        System.out.println("test github");
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String dateNaissanceToString() {
        return dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.FRANCE));
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public String dateSortieToString() {
        return dateSortie.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.FRANCE));
    }

    public LocalTime getHeureSortie() {
        return heureSortie;
    }

    public  String heureSortieToString() {
        return heureSortie.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
    }

    public MotifDeplacement getMotifDeplacement() {
        return motifDeplacement;
    }

    @Override
    public String toString() {
        return "Attestation{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                ", heureSortie='" + heureSortie + '\'' +
                ", motifDeplacement='" + motifDeplacement + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attestation that = (Attestation) o;
        return Objects.equals(prenom, that.prenom) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(lieuNaissance, that.lieuNaissance) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(ville, that.ville) &&
                Objects.equals(codePostal, that.codePostal) &&
                Objects.equals(dateSortie, that.dateSortie) &&
                Objects.equals(heureSortie, that.heureSortie) &&
                motifDeplacement == that.motifDeplacement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom, dateNaissance, lieuNaissance, adresse, ville, codePostal, dateSortie, heureSortie, motifDeplacement);
    }
}
