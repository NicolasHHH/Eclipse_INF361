package td22;
import tc.TC;

public class Tournoi {
	public static void afficheTour(int[] tab) {
		int len = tab.length;
		for (int i=0; i<len/2;i++) {
			TC.print("[");
			TC.print(tab[2*i]);
			TC.print(" - ");
			TC.print(tab[2*i+1]);
			TC.print("]");
			if (i<len/2-1) TC.print(" ");
		}
		TC.println();
		
	}


}
