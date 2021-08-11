import tc.TC;

public class TestExercice3 {
  public static void main(String[] args) {

    String[] mots = { "Gamma", "Beta", "Alpha", "Delta", "Psi", "Phi", "Kappa",
        "Mu", "Lambda", "Nu", "Zeta" };
    int[][] t = { { 1, 3 }, { 1, 2 }, { 3 }, { 2 }, { 1 }, { 1 }, { 2 }, { 2 },
        { 3 }, { 3 }, { 3 } };

    Noeud[] noeuds = new Noeud[11];
    for (int i = 0; i < 11; i++) {
      Entree e = new Entree(mots[i]);
      for (int j = 0; j < t[i].length; j++)
        e.ajouter(t[i][j]);

      noeuds[i] = new Noeud(e);
    }

    ABR T1 = new ABR(noeuds[0]); // "test-ex3"
    noeuds[0].gauche = noeuds[1];
    noeuds[1].gauche = noeuds[2];
    noeuds[1].droit = noeuds[3];
    noeuds[0].droit = noeuds[4];
    noeuds[4].gauche = noeuds[5];
    noeuds[5].gauche = noeuds[6];
    noeuds[6].droit = noeuds[7];
    noeuds[7].gauche = noeuds[8];
    noeuds[7].droit = noeuds[9];
    noeuds[4].droit = noeuds[10];

    // Partie a du test pour Ex. 3
    TC.println("Test 3a : ");
    TC.println("Arbre 1 ordonné : " + T1.estValide());
    T1.dessiner();

    // Partie b du test pour Ex. 3
    ABR T2 = new ABR(noeuds[1]); // "test-ex3"
    noeuds[1].gauche = noeuds[0];
    noeuds[1].droit = noeuds[4];
    noeuds[0].gauche = noeuds[2];
    noeuds[0].droit = noeuds[3];
    TC.println("Test 3b : ");
    TC.println("Arbre 2 ordonné : " + T2.estValide());
    T2.dessiner();

    // T1.racine.contenu.mot = "Gamma";
    // T1.racine.gauche.contenu.mot = "Beta";

    noeuds[0].gauche = noeuds[1];
    noeuds[1].gauche = noeuds[2];
    noeuds[1].droit = noeuds[3];
    noeuds[0].droit = noeuds[4];

    noeuds[7].droit = noeuds[10];
    noeuds[4].droit = null;

    // Partie c du test pour Ex. 3
    TC.println("Test 3c : ");
    TC.println("Arbre 3 ordonné : " + T1.estValide());
    T1.dessiner();

    TC.print("Tapez enter/retour ici pour finir...");
    TC.lireLigne();
    System.exit(0);

  }
}
