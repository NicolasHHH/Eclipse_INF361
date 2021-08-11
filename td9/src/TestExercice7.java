import java.util.Scanner;

import tc.TC;

public class TestExercice7 {

  public static void testEq(String nom) {
    TC.lectureDansFichier(nom + ".txt");
    ListeEntrees liste = new ListeEntrees();
    int nligne = 1;
    while (!TC.finEntree()) {
      for (String mot : TC.lireLigne().split("[ .,:;!?()\\[\\]\"]+"))
        liste.ajouterEnQueue(new Entree(mot, nligne));
      nligne++;
    }
    ABR balancedIndex = new ABR(liste); // nom + "_equ",
    balancedIndex.dessiner();
    TC.println("hauteur : "
        + balancedIndex.hauteur());
  }

  public static void test(String nom) {
    TC.lectureDansFichier(nom + ".txt");
    ABR I = new ABR();
    I.indexerTexte();
    I.dessiner();
    TC.println("hauteur de " + nom + " : " + I.hauteur());

    // ligne ci-dessous a decommenter
    testEq(nom);
  }

  public static void main(String[] args) {
	  
	ABR dummy = new ABR(new ListeEntrees());
	  
    test("english_short");

    TC.println();
    TC.println("Tapez enter/retour pour continuer...");
    new Scanner(System.in).nextLine();

    test("english");

    TC.println();
    TC.print("Tapez enter/retour pour finir...");
    TC.lectureEntreeStandard();
    TC.lireLigne();
    System.exit(0);
  }

}
