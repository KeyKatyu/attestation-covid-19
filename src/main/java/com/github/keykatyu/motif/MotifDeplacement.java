package com.github.keykatyu.motif;

public enum MotifDeplacement {

    TRAVAIL("Déplacements entre le domicile et le lieu d’exercice de l’activité professionnelle ou un établissement d’enseignement ou de formation ; déplacements professionnels ne pouvant être différés ; déplacements pour un concours ou un examen.",500),
    ACHATS("Déplacements pour se rendre dans un établissement culturel autorisé ou un lieu de culte ; déplacements pour effectuer des achats de biens, pour des services dont la fourniture estautorisée, pour les retraits de commandes et les livraisons à domicile.",470),
    SANTE("Consultations, examens et soins ne pouvant être assurés à distance et l’achat de médicaments.",477),
    FAMILLE("Déplacements pour motif familial impérieux, pour l'assistance aux personnes vulnérables et précaires ou la garde d'enfants.",435),
    HANDICAP("Déplacement des personnes en situation de handicap et leur accompagnant.",396),
    SPORT_ANIMAUX("Déplacements en plein air ou vers un lieu de plein air, sans changement du lieu de résidence, dans la limite de trois heures quotidiennes et dans un rayon maximal de vingt kilomètres autour du domicile, liés soit à l’activité physique ou aux loisirs individuels, à l’exclusion de toute pratique sportive collective et de toute proximité avec d’autres personnes, soit à la promenade avec les seules personnes regroupées dans un même domicile, soit aux besoins des animaux de compagnie.",358),
    CONVOCATION("Convocation judiciaire ou administrative et pour se rendre dans un service public.",295),
    MISSIONS("Participation à des missions d'intérêt général sur demande de l'autorité administrative.",255),
    ENFANTS("Déplacement pour chercher les enfants à l’école et à l’occasion de leurs activités périscolaires.",211);

    private final String raison;
    private final int y;

    MotifDeplacement(String raison, int y) {
        this.raison = raison;
        this.y = y;
    }

    public int y() {
        return y;
    }
    public String getRaison() {
        return raison;
    }
}
