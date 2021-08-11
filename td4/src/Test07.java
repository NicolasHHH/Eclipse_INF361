import tc.TC;

public class Test07 {
	public static void main(String[] args) {
		Argent a = new Argent(123456);
		Banque b = new Banque("Banque_de_Fou");
		long nCharles = 987654321;
		Compte c = new Compte(nCharles, "Charles_Ragondin", a, 150);

		
		String nomFichierSortie = "Test07-sortie.txt";
		TC.println("--Test prelevement/depot -- redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		
		
		TC.println("-- new Compte :");
		TC.println(c);
		b.ajouterCompte(c);

		Argent unEuro = new Argent(100);
		Argent million = new Argent(100);
		
		TC.println("-- test deposer (legal) : attend true");
		boolean ok = b.deposer(nCharles,unEuro);
		TC.println(ok);
		TC.println("-- nouveau solde (via trouverCompte et getSolde) : attend " + a.plus(unEuro));
		TC.println(b.trouverCompte(nCharles).getSolde());
		
		TC.println("-- test prelever  (legal) : attend true");
		ok = b.prelever(nCharles,unEuro,true);
		TC.println(ok);

		TC.println("-- nouveau solde (via trouverCompte et getSolde) : attend " + a);
		TC.println(b.trouverCompte(nCharles).getSolde());
		
		TC.println("-- test deposer (numero pas dans Banque) : attend false");
		ok = b.deposer(0,unEuro);
		TC.println(ok);
		TC.println("-- test prelever  (numero pas dans Banque) : attend false");
		ok = b.prelever(0,unEuro,false);
		TC.println(ok);
		
		TC.println("-- test prelever  (montant trop grand) : attend false");
		ok = b.prelever(nCharles,million,false);
		TC.println(ok);
		TC.println("-- solde (via trouverCompte et getSolde) : attend " + a + " (pas de changement apres retrait illegal)");
		TC.println(b.trouverCompte(nCharles).getSolde());
		
		Argent limite = new Argent(15000);
		Argent limiteplus = new Argent(15001);
		TC.println("-- test prelever  (test limite plafond) : attend true");
		ok = b.prelever(nCharles,limite,true);
		TC.println(ok);
		TC.println("-- test prelever  (test limite plafond) : attend true");
		ok = b.prelever(nCharles,limiteplus,false);
		TC.println(ok);
		TC.println("-- test prelever  (test limite plafond) : attend false");
		ok = b.prelever(nCharles,limiteplus,true);
		TC.println(ok);
		
		Monnaie rouble=new Monnaie("Rouble",90.92);
		Monnaie yuan=new Monnaie("Yuan",7.8);
		
		
		TC.println("-- test prelever  et deposer des montants d'une autre monnaie : ");
		TC.println(c.getSolde() +"");
		ok = b.prelever(nCharles, new Argent(2000, rouble),true);
		TC.println(ok);
		ok = b.deposer(nCharles, new Argent(6000, yuan));
		TC.println(ok);
		TC.println(c.getSolde() +"");
	}

}

