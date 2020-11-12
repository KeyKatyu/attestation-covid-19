package fr.covid.builder.attestation;

import java.time.LocalDate;

public interface DateSortieAttestationBuilder {
    HeureSortieAttestationBuilder dateDeSortie(LocalDate dateSortie);
}
