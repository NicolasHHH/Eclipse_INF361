import tc.TC;

public class Test01b {
    public static void main(String[] args) {
    CollectionCandidats e = new ListeCandidats();
        //CollectionCandidats e = new LinkedListCandidats();
        if (!e.estCorrecte()) TC.println("ERREUR: la liste vide devrait etre correcte");
        TC.println("il y a " + e.nombreCandidats() + " candidat");
        Candidat c1 = new Candidat("Auvergne-Rhone-Alpes", "ALLUIRE GERALDINE F 15");
        Candidat c2 = new Candidat("Auvergne-Rhone-Alpes", "BERTHELEIN DONIA F 7");
        Candidat c3 = new Candidat("Auvergne-Rhone-Alpes", "BERTHELEIN HUGO M 17");
        Candidat c4 = new Candidat("Auvergne-Rhone-Alpes", "CENDRAY LUDOVIC M 19");
        e.ajouterEnTete(c4);
        if (!e.estCorrecte()) TC.println("ERREUR: la liste a 1 element devrait etre correcte");
        e.afficher();
        TC.println("il y a " + e.nombreCandidats() + " candidat");
        e.ajouterEnTete(c3);
        e.ajouterEnTete(c2);
        e.ajouterEnTete(c1);;
        if (!e.estCorrecte()) TC.println("ERREUR: la liste devrait être correcte");
        e.afficher();
        TC.println("il y a " + e.nombreCandidats() + " candidats");
    }

}
