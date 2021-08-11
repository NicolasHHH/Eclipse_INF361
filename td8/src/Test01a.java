import tc.TC;

public class Test01a {
    public static void main(String[] args) {
        Candidat c1 = new Candidat("Auvergne-Rhone-Alpes", "ALLUIRE GERALDINE F 15");
        Candidat c2 = new Candidat("Auvergne-Rhone-Alpes", "BERTHELEIN DONIA F 7");
        Candidat c3 = new Candidat("Auvergne-Rhone-Alpes", "BERTHELEIN HUGO M 17");
        Candidat c4 = new Candidat("Auvergne-Rhone-Alpes", "CENDRAY LUDOVIC M 19");
        Maillon m4 = new Maillon(c4);
        Maillon m3 = new Maillon(c3,m4);
        Maillon m2 = new Maillon(c2, m3);
        Maillon m1 = new Maillon(c1, m2);
        Maillon.afficher(m1);
        TC.println("Il y a " + Maillon.longueur(m1) + " candidats");
        Maillon d = Maillon.dernier(m1);
        TC.println("Le dernier maillon est:");
        Maillon.afficher(d);
    }

}
