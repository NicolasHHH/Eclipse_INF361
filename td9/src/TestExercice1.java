import tc.TC;

public class TestExercice1 {

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

    ABR T1 = new ABR(); // "test-ex1"

    TC.println("test1a: la hauteur est " + T1.hauteur());

    T1.dessiner();
    TC.print("Tapez enter/retour ici pour continuer...");
    TC.lireLigne();

    ABR T2 = new ABR(noeuds[0]); // "test-ex1"
    TC.println("test1b: la hauteur est " + T2.hauteur());

    T2.dessiner();
    TC.print("Tapez enter/retour ici pour continuer...");
    TC.lireLigne();

    noeuds[0].gauche = noeuds[1];
    noeuds[1].gauche = noeuds[2];
    noeuds[1].droit = noeuds[3];
    noeuds[0].droit = noeuds[4];

    TC.println("test1c: la hauteur est " + T2.hauteur());

    T2.dessiner();
    TC.print("Tapez enter/retour ici pour continuer...");
    TC.lireLigne();

    noeuds[4].gauche = noeuds[5];
    noeuds[5].gauche = noeuds[6];
    noeuds[6].droit = noeuds[7];
    noeuds[7].gauche = noeuds[8];
    noeuds[7].droit = noeuds[9];
    noeuds[4].droit = noeuds[10];

    TC.println("test1d: la hauteur est " + T2.hauteur());

    T2.dessiner();
    TC.print("Tapez enter/retour ici pour finir...");
    TC.lireLigne();
    System.exit(0);

  }

}
