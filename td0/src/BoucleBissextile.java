import tc.TC;

public class BoucleBissextile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC.print("Entrer une valeur : ");
		int annee = TC.lireInt();
		
		while (annee >= 0) {
			Bissextile.affichage(annee);
			TC.print("Entrer une valeur : ");
			annee = TC.lireInt();
		}
		TC.println("Au revoir.");
	}

}
