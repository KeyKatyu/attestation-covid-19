# ATTESTATION DE DÉPLACEMENT DÉROGATOIRE (COVID-19)

[![](https://jitpack.io/v/KeyKatyu/attestation-deplacement-covid-19.svg)](https://jitpack.io/#KeyKatyu/attestation-deplacement-covid-19)

Ce projet propose une API **_NON OFFICIELLE_** ecrite en Java *(minimum Java 8)* permettant de generer une attestation de deplacement, en s'inspirant du generateur officiel du gouvernement (https://github.com/LAB-MI/attestation-deplacement-derogatoire-q4-2020).

Il utilise 2 dependances en interne : 
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
    <version>1.0.4</version>
</dependency>
```

**Gradle** _(Groovy)_
```groovy
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}
dependencies {
    implementation 'com.github.keykatyu:attestation-deplacement-covid-19:1.0.4'
}
```
**Gradle** _(Kotlin DSL)_
```kotlin
repositories {
    jcenter()
    maven("https://jitpack.io")
}
dependencies {
    implementation("com.github.keykatyu:attestation-deplacement-covid-19:1.0.4")
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

## Publication
* Cette API a ete publiee avec JitPack (https://jitpack.io/docs/#publishing-on-jitpack)
