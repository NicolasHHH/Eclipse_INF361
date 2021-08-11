import java.util.Arrays;

import tc.TC;

public class Kovix5 {

	public static void traiter() {
		// adapter depuis Kovix3 et 4
		String nb_ps = TC.lireLigne();
		int n = Integer.parseInt(nb_ps);
		TC.print("Il y a "+n+" personne");
		if (n>1) TC.print("s");
		TC.println(".");
		
		Itineraire[] iti_list = new Itineraire[n];
		String[] pseu_list =  new String[n];
		
		for(int i = 0; i<n ; i++) {
			String ligne_per = TC.lireLigne();
			String[] mots = TC.motsDeChaine(ligne_per);
			int nb_ln = Integer.parseInt(mots[1]);
			TC.print("On a "+mots[1]+" positions pour le pseudo "+mots[0]+" aux instants ");
			iti_list[i] = new Itineraire(mots[0],nb_ln);
			pseu_list[i] =  mots[0];
			
			for (int j=0;j<nb_ln;j++) {
				String infoj = TC.lireLigne();
				String[] pos_instantj = TC.motsDeChaine(infoj);
				Instant insj = new Instant(pos_instantj[0]);
				int xj =  Integer  .parseInt(pos_instantj[1]);
				int yj =  Integer.parseInt(pos_instantj[2]);
				Position posj = new Position(insj,xj,yj);
				iti_list[i].ajouter(posj);
			}
			iti_list[i].trier();
			TC.print(Arrays.toString(iti_list[i].instants()));
			TC.println(".");
		}
		

		
		// nouvelle partie: contact
		
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j< n; j ++) {
				Position[] rencontres = iti_list[i].contacts(iti_list[j],3);
				TC.print("Contacts de "+pseu_list[i] +" avec "+pseu_list[j]+" : ");
				TC.println(Arrays.toString(rencontres));
				
				if (rencontres.length!=0) {
					Position[] rencontres_r = iti_list[j].contacts(iti_list[i],3);
					TC.print("         de "+pseu_list[j] +" avec "+pseu_list[i]+" : ");
					TC.println(Arrays.toString(rencontres_r));
				}
			}
		}		
		
		String nb_emp = TC.lireLigne();
		int n2 = Integer.parseInt(nb_emp);
		TC.print("Il y a "+n2+" emplacement");
		if (n2>1) TC.print("s");
		TC.println(".");
		
		
		for (int j=0; j< n2;j++) {
			String emp = TC.lireLigne();
			String[] mots = TC.motsDeChaine(emp);
			int x =  Integer.parseInt(mots[0]);
			int y =  Integer.parseInt(mots[1]);
			Emplacement empm = new Emplacement(mots[2],x,y);
			TC.println(empm.toString());
		}
		
		for(int i = 0; i<n ; i++) {
			String ligne_per = TC.lireLigne();
			String[] mots = TC.motsDeChaine(ligne_per);
			TC.println(mots[2]+" est le pseudo de "+mots[1]+" "+mots[0]+".");
		}
	}
}
