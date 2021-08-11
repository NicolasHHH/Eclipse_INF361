import tc.TC;

public class TestExercice2 {
	public static void main(String[] args) {
		String[] mots = {"Gamma", "Beta", "Alpha", "Delta", "Psi", "Phi", "Kappa", "Mu", "Lambda", "Nu", "Zeta"};
		int[][] t = {{1,3}, {1,2}, {3}, {2}, {1}, {1}, {2}, {2}, {3}, {3}, {3}};
		
		Noeud[] noeuds = new Noeud[11];
		for(int i = 0; i < 11; i++) {
			Entree e = new Entree(mots[i]);
			for(int j = 0; j < t[i].length; j++)
				e.ajouter(t[i][j]);
			
			noeuds[i] = new Noeud (e);
		}
		
		ABR T1 = new ABR(noeuds[0]); // "test-ex2"
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
		 
		// Partie a du test pour Ex. 1
		TC.println("Test 2a : ");
		TC.println("'Kappa' apparaît aux lignes : " + T1.chercher("Kappa"));

		// Partie b du test pour Ex. 1
		TC.println("Test 2b : ");
		TC.println("'Iota' apparaît aux lignes : " + T1.chercher("Iota"));

		// Partie c du test pour Ex. 1
		TC.println("Test 2c : ");
		TC.println("'Beta' apparaît aux lignes : " + T1.chercher("Beta"));
	}
}
