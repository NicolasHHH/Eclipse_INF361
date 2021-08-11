import tc.TC;

public class Test06a {
    public static void test(CandidatComparator cmp, Candidat c1, Candidat c2, int expected) {
        TC.println("Test de comparaison: ");
        TC.println("Candidat 1: " + c1 + " (" + c1.getRegion() + ")");
        TC.println("Candidat 2: " + c2 + " (" + c2.getRegion() + ")");
        int res = cmp.compare(c1,c2);
        boolean ok = Integer.signum(res) == expected;
        if (ok) TC.println("OK");
        else TC.println("ERREUR");
    }
    
    public static void main(String[] args) {
            CandidatComparator cmp = new CandidatComparatorNote();
            Candidat c1 = new Candidat("Corse", "RAULETTE CAMILLE F 13");
            Candidat c2 = new Candidat("Corse", "ELISABETHE LUDOVIC M 13");
            Candidat c3 = new Candidat("Corse", "ALENS CLARA F 17");
            Candidat c4 = new Candidat("Ile-de-France", "TIETSCHY SALMA F 13");
            Candidat c5 = new Candidat("Ile-de-France", "555 jj F 13");
            Candidat c6 = new Candidat("Corse6", "RAULETTE CAMILLE F 0");
            Candidat c7 = new Candidat("Corse", "ELISABETHE LUDOVIC F 0");
            test(cmp,c1,c1,0);
            test(cmp,c1,c2,1);
            test(cmp,c1,c3,-1);
            test(cmp,c1,c4,1);
            test(cmp,c2,c4,-1);
            test(cmp,c4,c5,0);
            test(cmp,c6,c7,0);
        }
}
