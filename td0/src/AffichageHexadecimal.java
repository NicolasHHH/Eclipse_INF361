import maclib.GrafPort;

public class AffichageHexadecimal {

  /**
   * Indique si on doit allumer ou non tel ou tel segment pour afficher le
   * chiffre voulu.
   * 
   * @param segment
   *          le segment en question
   * @param chiffre
   *          le chiffre hexadecimal que l'on veut afficher
   * @return true s'il faut allumer ce segment et false sinon
   */
  public static boolean allumeSegment(int segment, int chiffre) {
	if ( segment == 1 ) {
	    return chiffre <= 4 || 7 <= chiffre && chiffre <= 10 || chiffre == 13;
	}
	if ( segment == 2 ) {
	    return chiffre < 12 && chiffre !=2 || chiffre== 13;
	}
	if ( segment == 3 ) {
	    return chiffre!=1 && chiffre!=4 && chiffre!=7 &&chiffre!=10 &&chiffre != 15 ;
	}
	if ( segment == 4 ) {
	    return chiffre==0||chiffre==2||chiffre == 6||chiffre==8 || chiffre>9;
	}
	if ( segment == 5 ) {
	    return chiffre == 0 || (chiffre > 3 && chiffre != 13 && chiffre != 7 );
	}
	if ( segment == 6 ) {
	    return  chiffre != 1 && chiffre != 0 && chiffre != 7 &&chiffre != 12  ;
	}
	if ( segment == 0 ) {
	    return chiffre != 1 && chiffre != 4 && chiffre != 13 &&chiffre != 11  ;
	}
	
    return false; // MODIFIER pour la valeur de retour correcte
  }

  /**
   * Affiche un chiffre hexadecimal dans un afficheur, NE PAS MODIFIER.
   * 
   * @param chiffre
   *          le chiffre que l'on veut afficher
   * @param g
   *          le GrafPort dans lequel on dessine l'afficheur
   */
  public static void afficher(int chiffre, GrafPort g) {
    for (int segment = 0; segment < Afficheur7Segments.NOMBRE_SEGMENTS; ++segment) {
      if (allumeSegment(segment, chiffre)) {
        Afficheur7Segments.allumerSegment(segment, g);
      } else {
        Afficheur7Segments.eteindreSegment(segment, g);
      }
    }
  }

  // NE PAS MODIFIER
  public static void main(String[] args) {
    // on construit 16 afficheurs, un pour chaque chiffre hexadecimal.
    for (int chiffre = 0; chiffre < 16; ++chiffre) {
      afficher(chiffre, Afficheur7Segments.construireAfficheur());
    }
  }

}