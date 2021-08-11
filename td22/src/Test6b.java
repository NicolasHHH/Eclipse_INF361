import tc.TC;

public class Test6b {

	// Tournoi.vainqueur sans affichage
	public static int vainqueurMuet(int[] tab, int[][] result) {
		int i = 0;
		while (tab.length > 1) {
			tab = Tournoi.tourSuivant(tab, result[i]);
			i++;
		}
		return tab[0];
	}

	public static void main(String[] args) {
		int[] tab = Tournoi.tableauRealiste(32);
		// Tournoi.melangeTableau(tab);
		int[][] results = Tournoi.resultatsRealistes(tab);
		int vainqueur = Tournoi.vainqueur(tab, results);
		TC.println("Et le joueur " + vainqueur + " remporte le tournoi !!");

		// proba que 1 gagne dans un tournoi de 8 joueurs = 0.52794...
		// esperance = 528
		int cpt = 0;
		int N = 8;

		for (int i = 0; i < 1000; i++) {
			tab = Tournoi.tableauRealiste(N);
			results = Tournoi.resultatsRealistes(tab);
			vainqueur = vainqueurMuet(tab, results);
			if (vainqueur == 1)
				cpt++;
		}

		if ((450 < cpt) && (cpt < 600)) {
			TC.println("TEST REUSSI");
		} else TC.println("TEST RATE");
	}

}