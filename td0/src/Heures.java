
import tc.TC;

public class Heures {
  /**
   * Renvoie une chaine de la forme "H : M : S", pour un affichage digital.
   * 
   * A COMPLETER. Vous devez expliciter le calcul des valeurs des heures,
   * minutes et secondes.
   * 
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit convertir
   * @return la chaine Java correspondante (type String)
   */
  public static String chaineDe(int secondes) {
    int heures = secondes/3600;
    secondes = secondes % 3600;
    int minutes = secondes /60;
    secondes = secondes % 60;
    
    return heures + " : " + minutes + " : " + secondes; // ceci utilise la surcharge de +
  }
  
  public static int lireEntier(String invite) {
	  TC.print(invite);
	  int entier = TC.lireInt();
	  return entier;
  }
  public static int lireHMS(String invite) {
	  TC.print(invite);
	  int heure = TC.lireInt();
	  int min = TC.lireInt();
	  int sec = TC.lireInt();
	  return 3600*heure + min*60 + sec;
  }

  public static void main(String[] args) {
    // test exercice 2
	/*
    TC.println(chaineDe(0));
    TC.println(chaineDe(1));
    TC.println(chaineDe(59));
    TC.println(chaineDe(60));
    TC.println(chaineDe(119));
    TC.println(chaineDe(120));
    TC.println(chaineDe(3599));
    TC.println(chaineDe(3600));
    TC.println(chaineDe(3601));
    TC.println(chaineDe(4000));
    TC.println(chaineDe(24 * 3600 - 1));
    */
    
   //test exercice 4
	  /*
    String message = "combien de secondes ? ";
    int secondes_1 = lireEntier(message);
    TC.println(chaineDe(secondes_1));
    int secondes_2 = lireEntier(message);
    TC.println(chaineDe(secondes_2));
    TC.print("total = ");
    TC.println(chaineDe(secondes_1+secondes_2));
    */
	// test exercice 5
	int seconde1 = lireHMS("entrer heures minutes secondes : ");
	int seconde2 = lireHMS("entrer heures minutes secondes : ");
	//TC.println(seconde1);
	TC.print("total = "+chaineDe(seconde1+seconde2));
  }
}