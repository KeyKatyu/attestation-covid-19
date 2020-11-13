package com.github.afelipez.motif;

public enum MotifDeplacement {

    TRAVAIL("Déplacements entre le domicile et le lieu d’exercice de l’activité professionnelle ou un établissement d’enseignement ou de formation, déplacements professionnels ne pouvant être différés [2] , déplacements pour un concours ou un examen.",578),
    ACHATS("Déplacements pour effectuer des achats de fournitures nécessaires à l'activité professionnelle, des achats de première nécessité [3] dans des établissements dont les activités demeurent autorisées, le retrait de commande et les livraisons à domicile ;",533),
    SANTE("Consultations, examens et soins ne pouvant être assurés à distance et l’achat de médicaments ;",477),
    FAMILLE("Déplacements pour motif familial impérieux, pour l'assistance aux personnes vulnérables et précaires ou la garde d'enfants ;",435),
    HANDICAP("Déplacement des personnes en situation de handicap et leur accompagnant ;",396),
    SPORT_ANIMAUX("Déplacements brefs, dans la limite d'une heure quotidienne et dans un rayon maximal d'un kilomètre autour du domicile, liés soit à l'activité physique individuelle des personnes, à l'exclusion de toute pratique sportive collective et de toute proximité avec d'autres personnes, soit à la promenade avec les seules personnes regroupées dans un même domicile, soit aux besoins des animaux de compagnie ;",358),
    CONVOCATION("Convocation judiciaire ou administrative et pour se rendre dans un service public ;",295),
    MISSIONS("Participation à des missions d'intérêt général sur demande de l'autorité administrative ;",255),
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
