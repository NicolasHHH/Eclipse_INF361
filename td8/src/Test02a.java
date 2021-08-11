import tc.TC;

public class Test02a {
    public static void main(String[] args) {
        Candidat c1 = new Candidat("Auvergne-Rhone-Alpes", "ALLUIRE GERALDINE F 15");
        Candidat c2 = new Candidat("Auvergne-Rhone-Alpes", "BERTHELEIN DONIA F 7");
        Candidat c3 = new Candidat("Auvergne-Rhone-Alpes", "BERTHELEIN HUGO M 17");
        Candidat c4 = new Candidat("Auvergne-Rhone-Alpes", "CENDRAY LUDOVIC M 19");
        Maillon m1 = new Maillon(c1);
        Maillon m3 = m1.ajouterApres(c3);
        Maillon m4 = m3.ajouterApres(c4);
        Maillon m2 = m1.ajouterApres(c2);
        Maillon.enleverSuivant(m1);
        Maillon.afficher(m1);
        TC.println("Il y a " + Maillon.longueur(m1) + " candidats");
        Maillon d = Maillon.dernier(m1);
        TC.println("Le dernier maillon est:");
        Maillon.afficher(d);
    }

}
