import tc.TC;

public class Test04 {

  public static void test(int montant, Monnaie monnaie, Monnaie autreMonnaie) {
    Argent origine = new Argent(montant, monnaie);
    Argent converti = origine.convertir(autreMonnaie);
    TC.print(origine.toString() + " -> " + converti.toString());
    
    Argent reconverti = converti.convertir(monnaie);
    TC.print(" -> " + reconverti.toString());
    if (origine.estEgalA(reconverti))
    	TC.print(" true");
    else
    	TC.print(" false");
    TC.println();
    	
  }

  public static void main(String[] args) {
    String nomFichierSortie = "Test04-sortie-bis.txt";
    TC.println("-- test convertir : redirection de sortie vers fichier "
        + nomFichierSortie);
    TC.ecritureDansNouveauFichier(nomFichierSortie);

    Monnaie euro = new Monnaie("Euro", 1);
    Monnaie yuan = new Monnaie("Yuan", 7.82);
    Monnaie rouble = new Monnaie("Rouble", 90.92);
    Monnaie bitcoin = new Monnaie("Bitcoin", 0.000019);
    Monnaie dollar = new Monnaie("Dollar", 1.2);
    Monnaie livre = new Monnaie("Livre", 0.87);
    Monnaie krone = new Monnaie("Krone", 7.46);

    TC.println("-- Conversions : ");
    test(13399, euro, dollar);
    test(149, livre, rouble);
    test(2289, yuan, euro);
    test(24, bitcoin, dollar);
    test(24, bitcoin, euro);
    test(1632, euro, livre);
    test(39, dollar, dollar);
    test(149, livre, yuan);
    test(237, euro, krone);
  }
}
