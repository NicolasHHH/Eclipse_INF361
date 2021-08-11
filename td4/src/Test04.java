import tc.TC;

public class Test04 {

	public static void main(String[] args) {
		String nomFichierSortie = "Test04-sortie.txt";
		TC.println("-- Test trouverCompte et ajouterCompte : redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		
		Banque b = new Banque("Banque_de_Fou");
		Compte c1 = new Compte(987654321, "Charles_Ragondin", new Argent(123456),400);
		Compte c2 = new Compte(2222122, "Razvan_Barbaud", new Argent(50000),1500);
		
		TC.println("--Test ajouterCompte : attend true, false, false");
		TC.print(b.ajouterCompte(c1)+", "+b.ajouterCompte(c1));
				
		for (int i=0; i<9; i++){
			b.ajouterCompte(new Compte(1000+i,"toto"+i,new Argent(300*i+25),200+50*i));
		}
		
		TC.println(", "+b.ajouterCompte(c2));
			
		TC.println();
		
		TC.println("--Test trouverCompte : attend null, 1008 toto8 24.25 Euros");
		TC.println(b.trouverCompte(26)+", "+b.trouverCompte(1008));
		
		TC.println();
		
		TC.println("--Test affichage de la banque :");
		b.afficher();
	}
}

