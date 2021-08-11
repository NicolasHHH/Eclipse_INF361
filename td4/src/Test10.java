import tc.TC;
public class Test10 {

	public static void main(String[] args) {
		
		String nomFichierSortie = "Test10-sortie.txt";
		TC.println("-- redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		
		Banque b = new Banque("Credit_du_chnord");
		
		long nRazvan = 7654321;
		long nAl = 2222222;
		
		Monnaie euro=new Monnaie("Euro",1);
	    Monnaie rouble=new Monnaie("Rouble",90.92);
	    Monnaie dollar=new Monnaie("Dollar",1.20);
		
		Compte cRazvan = new Compte(nRazvan, "Razvan_Barbaud", new Argent(17804, rouble), 150);
		Compte cAlCorp = new Compte(nAl, "Al_Coverer_Corp", new Argent(300000, dollar), 100);
		
		b.ajouterCompte(cRazvan);
		b.ajouterCompte(cAlCorp);
		
		TC.println("-- Comptes : ");
		TC.println(cRazvan);
		TC.println(cAlCorp);
		TC.println();
				
		TC.println("-- Creation de cheque et de TIP");
		Cheque ch = new Cheque(new Argent(10000, euro), "Roger_Plusdebiere");
		TIP t = new TIP("Al_Coverer_Corp", new Argent(234698, dollar), "Jessica_Scrout");
		TC.println(ch + "");
		TC.println(t + "");
		TC.println();
		
		TC.println("-- Test deposer : attend false, true, true");
		TC.print(b.deposer(0, ch) + ", ");
		TC.print(b.deposer(nRazvan, ch) + ", ");
		TC.println(b.deposer(nAl, t));
		TC.println();
		
		TC.println("Soldes des comptes");
		TC.println(b.trouverCompte(nRazvan).getSolde() + ",  " + b.trouverCompte(nAl).getSolde());
	}
}
