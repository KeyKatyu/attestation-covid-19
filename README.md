# Attestation de deplacement (COVID-19)
**Description**: Ce projet propose une API ecrite en Java *(minimum Java 8)* permettant de generer une attestation de deplacement, en s'inspirant du generateur officiel du gouvernement (https://github.com/LAB-MI/attestation-deplacement-derogatoire-q4-2020).

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
    <groupId>com.github.afelipez</groupId>
    <artifactId>attestation-covid-19</artifactId>
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
    implementation 'com.github.afelipez:attestation-covid-19'
}
```
**Gradle** _(Kotlin DSL)_
```kotlin
repositories {
    jcenter()
    maven("https://jitpack.io")
}
dependencies {
    implementation("com.github.afelipez:attestation-covid-19")
}
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

## Publication
* Cette API a ete publiee avec JitPack (https://jitpack.io/docs/#publishing-on-jitpack)