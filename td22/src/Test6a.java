import tc.TC;

public class Test6a {

  /**
   * Effectue n tirages par appels a vainqueurMatch(j1,j2) et compte le nombre
   * de reponses true, ie "j1 vainqueur".
   * 
   * @param n
   *          nombre de tirages
   * @param j1
   *          numero du joueur 1
   * @param j2
   *          numero du joueur 2
   * @return le nombre de fois "j1 vainqueur".
   */
  public static int comptage(int n, int j1, int j2) {
    int cpt = 0;
    for (int i = 0; i < n; i++)
      if (Tournoi.vainqueurMatch(j1, j2) == 1)
        cpt = cpt + 1;
    return cpt;
  }

  public static void main(String[] args) {
    if (Tournoi.vainqueurMatch(0, 10) == 2) {
      TC.println("Echec : peut-etre une inversion de i et j ?");
      return;
    }
    TC.println("TEST 1 OK");

    int cpt = comptage(10, 1, 1); // proba 1/2 => esperance cpt = 5
    if (((cpt == 0) || (cpt == 10))) {
      TC.println("TEST 2 Echec : verifier vos valeurs ...");
      return;
    }
    TC.println("TEST 2 OK");
    
    
    cpt = comptage(100, 1, 3); 
    // proba 3/4 => esperance cpt = 75  ecart-type = 5
    if ((cpt > 60) && (cpt < 90)) {
      TC.println("TEST 3 OK"); // proba ecart < 3*ET = 0.997
    } else {
      TC.println("TEST 3 RATE");
      return;
    }

    int N = 2;
    boolean tousOK = true;
    boolean auMoinsUnOK = false;
    for (int j = 0; j < N; j++) {
      cpt = comptage(100, 1, 1); 
      // proba 1/2 => esperance cpt = 50  ecart-type = 5
      boolean ok = (cpt >= 45) && (cpt <= 55); // ecart < 1*ET
      // proba ok = 0.68
      tousOK = tousOK && ok;
      auMoinsUnOK = auMoinsUnOK || ok;
    }
    if (tousOK) {
      TC.println("TEST 4 OK"); // N = 2 => proba 0.46
      return;
    }
    if (!auMoinsUnOK) {
      TC.println("TEST 4 RATE"); // N = 2 => proba 0.1
      return;
    }

    cpt = comptage(1000, 1, 1); 
    // proba 1/2 => esperance cpt = 500  ecart-type = 16
    if ((cpt > 450) && (cpt < 550)) {
      TC.println("TEST 4 OK"); // proba ecart < 3*ET = 0.997
    } else {
      TC.println("TEST 4 RATE");
    }

  }
}