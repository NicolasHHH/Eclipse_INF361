import tc.TC;
public class Test09 {
	public static void main(String[] args) {
		Argent a = new Argent(123456);
		Banque b = new Banque("Banque_de_Fou");
		long nCharles = 987654321;
		Compte c = new Compte(nCharles, "Charles_Ragondin", a, 150);

		
		String nomFichierSortie = "Test09-sortie.txt";
		TC.println("--Test prelevement/depot -- redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		
		
		TC.println("-- new Compte :");
		TC.println(c);
		b.ajouterCompte(c);

		Argent unEuro = new Argent(100);
		Argent million = new Argent(100000000);
		
		TC.println("-- test deposer liquide (legal) : attend true");
		boolean ok = b.deposer(nCharles,new Liquide(unEuro));
		TC.println(ok);
		TC.println("-- nouveau solde (via trouverCompte et getSolde) : attend " + a.plus(unEuro));
		TC.println(b.trouverCompte(nCharles).getSolde());
		
		TC.println("-- test retirer liquide (legal) : attend true");
		Liquide retrait = b.retirer(nCharles,unEuro);
		TC.println(retrait!=null);

		TC.println("-- nouveau solde (via trouverCompte et getSolde) : attend " + a);
		TC.println(b.trouverCompte(nCharles).getSolde());
		
		TC.println("-- test deposer liquide (numero pas dans Banque) : attend false");
		ok = b.deposer(0,new Liquide(unEuro));
		TC.println(ok);
		TC.println("-- test retirer (numero pas dans Banque) : attend null");
		retrait = b.retirer(0,unEuro);
		TC.println(retrait);
		
		TC.println("-- test retirer liquide (montant trop grand) : attend null");
		retrait = b.retirer(nCharles,million);
		TC.println(retrait);
		TC.println("-- solde (via trouverCompte et getSolde) : attend " + a + " (pas de changement apres retrait illegal)");
		TC.println(b.trouverCompte(nCharles).getSolde());
		
		Argent limite = new Argent(15000);
		Argent limiteplus = new Argent(15001);
		TC.println("-- test prelever  (test limite plafond) : attend true");
		retrait = b.retirer(nCharles,limite);
		TC.println(retrait!=null);
		TC.println("-- test prelever  (test limite plafond) : attend false");
		retrait = b.retirer(nCharles,limiteplus);
		TC.println(retrait!=null);
		
		Monnaie rouble=new Monnaie("Rouble",90.92);
		Monnaie yuan=new Monnaie("Yuan",7.82);
		
		
		TC.println("-- test retirer  et deposer des montants en liquide dans une autre monnaie : ");
		TC.println(c.getSolde() +"");
		retrait = b.retirer(nCharles, new Argent(20000, rouble));
		TC.println(retrait);
		ok = b.deposer(nCharles, new Liquide(new Argent(6000, yuan)));
		TC.println(ok);
		TC.println(c.getSolde() +"");
	}

}


