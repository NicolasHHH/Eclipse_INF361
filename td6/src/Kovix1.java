import tc.TC;

public class Kovix1 {
	public static void traiter() {
		String nb_ps = TC.lireLigne();
		int n = Integer.parseInt(nb_ps);
		
		TC.print("Il y a "+n+" personne");
		if (n>1) TC.print("s");
		TC.println(".");
		
		for(int i = 0; i<n ; i++) {
			String ligne_per = TC.lireLigne();
			String[] mots = TC.motsDeChaine(ligne_per);
			int nb_ln = Integer.parseInt(mots[1]);
			TC.println("On a "+mots[1]+" positions pour le pseudo "+mots[0]+".");
			for (int j=0; j< nb_ln;j++) {
				TC.lireLigne();
			}
		}
		String nb_emp = TC.lireLigne();
		int n2 = Integer.parseInt(nb_emp);
		TC.print("Il y a "+n2+" emplacement");
		if (n2>1) TC.print("s");
		TC.println(".");
		for (int j=0; j< n2;j++) {
			TC.lireLigne();
		}
		
		for(int i = 0; i<n ; i++) {
			String ligne_per = TC.lireLigne();
			String[] mots = TC.motsDeChaine(ligne_per);
			TC.println(mots[2]+" est le pseudo de "+mots[1]+" "+mots[0]+".");
		}
		
	}
}
