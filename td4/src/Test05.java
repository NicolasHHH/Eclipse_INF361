import tc.TC;
public class Test05 {
	
	public static void choixEntreeSortie05() {
		String nomFichierSortie = "Test05-sortie.txt";
		TC.println("--Test lireBanque -- redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		TC.lectureDansFichier("banque-eponge.txt");	
	}
	
	public static void choixEntreeSortie06() {
		String nomFichierSortie = "Test06-sortie.txt";
		TC.println("-- Test ajouterCompte en tableau dynamique : redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		TC.lectureDansFichier("banque-tigre.txt");
	}
	
	public static Banque lireBanque(Monnaie[] tab) {
		// A COMPLETER
		String newNom = TC.lireLigne();
		Banque Bank = new Banque(newNom);
		int N = Integer.parseInt(TC.lireLigne());
		for ( int i=0; i<N;i++) {
			Bank.ajouterCompte(new Compte(TC.lireLigne(),tab));
		}
		return Bank;		
	}

	public static void main(String[] args) {
		//choixEntreeSortie05();
		choixEntreeSortie06();
		
		Monnaie[] tab={
				new Monnaie("Euro",1),
				new Monnaie("Livre",0.87),
			    new Monnaie("Dollar",1.2),
			    new Monnaie("Yuan",7.82),
			    new Monnaie("Rouble",90.92)
		};
		
		Banque b = lireBanque(tab);
		b.afficher();
	}
}

