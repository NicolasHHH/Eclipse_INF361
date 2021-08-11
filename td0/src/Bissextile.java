import tc.TC;

public class Bissextile {
	
	public static boolean estBissextile(int annee) {
		if (annee%400 == 0) return true;
		else return (annee%4 ==0) && (annee%100!=0);
	}
	public static void affichage(int annee) {
		if ( estBissextile(annee)) {
			TC.println(annee+" est bissextile.");
		}
		else {
			TC.println(annee+" n'est pas bissextile.");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    affichage(1900);
		affichage(1901);
	    affichage(1904);
	    affichage(2000);
	}

}
