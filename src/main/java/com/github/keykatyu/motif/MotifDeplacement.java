package com.github.keykatyu.motif;

public enum MotifDeplacement {

    TRAVAIL("Déplacements entre le domicile et le lieu d’exercice de l’activité professionnelle ou le lieu d’enseignement et de formation, déplacements professionnels ne pouvant être différés.", 449),
    SANTE("Déplacements pour des consultations, examens, actes de prévention (dont vaccination) et soins ne pouvant être assurés à distance ou pour l’achat de produits de santé.", 415),
    FAMILLE("Déplacements pour motif familial impérieux, pour l’assistance aux personnes vulnérables ou précaires ou pour la garde d’enfants.", 381),
    HANDICAP("Déplacement des personnes en situation de handicap et leur accompagnant.", 348),
    CONVOCATION("Déplacements pour répondre à une convocation judiciaire ou administrative.", 325),
    MISSIONS("Déplacements pour participer à des missions d’intérêt général sur demande de l’autorité administrative.", 305),
    TRANSITS("Déplacements liés à des transits ferroviaires, aériens ou en bus pour des déplacements de longues distances.", 272),
    ANIMAUX("Déplacements brefs, dans un rayon maximal d’un kilomètre autour du domicile pour les besoins des animaux de compagnie.", 239);

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
