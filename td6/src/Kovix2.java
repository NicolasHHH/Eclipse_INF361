import tc.TC;

public class Kovix2 {

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
			
			String info = TC.lireLigne();
			String[] pos_instant = TC.motsDeChaine(info);
			Instant insi = new Instant(pos_instant[0]);
			Instant insf = insi;
			
			int x =  Integer.parseInt(pos_instant[1]);
			int y =  Integer.parseInt(pos_instant[2]);
			
			Position posi = new Position(insi,x,y);
			Position posf = posi;
			
			for (int j=1;j<nb_ln;j++) {
				String infoj = TC.lireLigne();
				String[] pos_instantj = TC.motsDeChaine(infoj);
				Instant insj = new Instant(pos_instantj[0]);
				int xj =  Integer.parseInt(pos_instantj[1]);
				int yj =  Integer.parseInt(pos_instantj[2]);
				Position posj = new Position(insj,xj,yj);
				
				if (insj.compareTo(insi)<0) {
					insi = insj;
					posi = posj;
				}
				if (insj.compareTo(insf)>0) {
					insf = insj;
					posf = posj;
				}
			}
			
			TC.print("Position initiale : "+posi.toString());
			TC.println(".");
			TC.print("Position finale : "+posf.toString());
			TC.println(".");
			
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