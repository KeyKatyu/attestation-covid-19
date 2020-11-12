# Attestation de deplacement (COVID-19)
**Description**: Ce projet propose une API ecrite en Java permettant de generer une attestation de deplacement, en s'inspirant du generateur officiel du gouvernement (https://github.com/LAB-MI/attestation-deplacement-derogatoire-q4-2020).
Il utilise 2 dependances en interne : 
* PDFBox pour l'ajout des donnees du PDF (https://pdfbox.apache.org/).
* Zxing pour la generation du QRCode (https://github.com/zxing/zxing).

## Installation
_Maven_
```xml
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>3.4.5</version>
</dependency>
```

_Gradle_
```groovy
apply plugin: "com.github.ben-manes.versions"
```
## Usage
```java
AttestationBuilder
    .create()
    .prenom("Jean")
    .nom("DUPONT")
    .dateDeNaissance(LocalDate.of(2000, 01, 01))
    .lieuDeNaissance("Paris")
    .adresse("25 rue du General de Gaulle")
    .ville("Paris")
    .codePostal(75001)
    .dateDeSortie(LocalDate.of(2020, 11, 12))
    .heureDeSortie(LocalTime.of(12, 30))
    .motifDeDeplacement(MotifDeplacement.ENFANTS)
    .qrCode(true) // true : QRCode dans le PDF
    .pdf(Path.of("./attestation.pdf")); // Chemin du PDF genere
```
