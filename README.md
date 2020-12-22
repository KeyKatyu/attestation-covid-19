# ATTESTATION DE DÉPLACEMENT DÉROGATOIRE (COVID-19)

[![](https://jitpack.io/v/KeyKatyu/attestation-deplacement-covid-19.svg)](https://jitpack.io/#KeyKatyu/attestation-deplacement-covid-19)

Ce projet propose une API non officielle écrite en Java *(Java 8 ou supérieur)* permettant de générer une attestation de deplacement, en s'inspirant du générateur officiel du gouvernement (https://github.com/LAB-MI/attestation-deplacement-derogatoire-q4-2020).

Il utilise 2 dépendances en interne : 
* PDFBox pour l'ajout des donnees du PDF (https://pdfbox.apache.org/).
* Zxing pour la generation du QRCode (https://github.com/zxing/zxing).

## Installation
**Maven**
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
  </repositories>
```
```xml
<dependency>
    <groupId>com.github.keykatyu</groupId>
    <artifactId>attestation-deplacement-covid-19</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Gradle** _(Groovy)_
```groovy
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}
dependencies {
    implementation 'com.github.keykatyu:attestation-deplacement-covid-19:1.0.0'
}
```
**Gradle** _(Kotlin DSL)_
```kotlin
repositories {
    jcenter()
    maven("https://jitpack.io")
}
dependencies {
    implementation("com.github.keykatyu:attestation-deplacement-covid-19:1.0.0")
}
```

## Usage
```java
public class Main {
    public static void main(String[] args) throws IOException, WriterException {
        AttestationBuilder
                .create()
                .prenom("Jean")
                .nom("DUPONT")
                .dateDeNaissance(LocalDate.of(2000, 1, 1))
                .lieuDeNaissance("Paris")
                .adresse("25 rue du General de Gaulle")
                .ville("Paris")
                .codePostal(75001)
                .dateDeSortie(LocalDate.of(2020, 11, 12))
                .heureDeSortie(LocalTime.of(12, 30))
                .motifDeDeplacement(MotifDeplacement.ENFANTS)
                .qrCode(true) // true : QRCode dans le PDF
                .pdf(Paths.get("./attestation.pdf")); // Chemin du PDF genere
    }
}
```

## Informations
* Cette API a été publiée avec JitPack (https://jitpack.io/docs/#publishing-on-jitpack).
* Les attestations générées sont les dernières en vigueur, la librarie est à jour. Si elle venait à ne plus l'être, n'hésitez pas à ouvrir une issue !
