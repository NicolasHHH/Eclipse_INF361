import tc.TC;

public class Test05 {

  public static void test(int montant, Monnaie monnaie, Monnaie autreMonnaie) {
    Argent origine = new Argent(montant, monnaie);
    Argent converti = origine.convertir(autreMonnaie);
    TC.println(origine.toString() + " -> " + converti.toString());
  }

  public static void main(String[] args) {
    String nomFichierSortie = "Test05-sortie.txt";
    TC.println(
        "--Test recherche -- redirection de sortie vers fichier Test05-sortie.txt"
            + nomFichierSortie);
    TC.ecritureDansNouveauFichier(nomFichierSortie);

    Monnaie[] tab = { new Monnaie("Euro", 1), new Monnaie("Yuan", 7.82),
        new Monnaie("Rouble", 90.92), new Monnaie("Dollar", 1.20),
        new Monnaie("Bitcoin", 0.000019), new Monnaie("Livre", 0.87) };

    Monnaie euro = Monnaie.trouverMonnaie("Euro", tab);
    Monnaie dollar = Monnaie.trouverMonnaie("Dollar", tab);
    Monnaie yuan = Monnaie.trouverMonnaie(new String("Yuan"), tab);
    Monnaie rouble = Monnaie.trouverMonnaie("Roubles", tab);
    Monnaie bitcoin = Monnaie.trouverMonnaie("Bitcoins", tab);
    Monnaie livre = Monnaie.trouverMonnaie("Livre", tab);
    Monnaie yen = Monnaie.trouverMonnaie("Yen", tab);

    TC.println("-- attend null : ");
    TC.println(yen);

    TC.println("-- Conversions : ");
    test(1245, euro, dollar);
    test(2322, yuan, euro);
    test(249, livre, yuan);
    test(1632, bitcoin, livre);
    test(1387, livre, rouble);
    test(59, dollar, dollar);
  }
}
