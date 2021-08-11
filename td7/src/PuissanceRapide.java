import java.math.BigInteger;

public class PuissanceRapide implements Puissance {

	/** Compteur d'opérations */
	private long opCount = 0;

	/**
	 * Calcule la puissance M^n avec la strategie dite: "square-and-multiply"
	 *
	 *  @param matrix
	 * 		matrice 2x2 en entrée
	 *  @param n
	 *  		exposant
	 *  @return M^n
	 */
	
	public Matrice2D puissance(Matrice2D matrix, int n) {
		opCount = 0;
		return puissanceRec(matrix,n);
	}
	
	
	public Matrice2D puissanceRec(Matrice2D matrix, int n) {
		if ( n == 0) return Matrice2D.identite();
		else if( n == 1) return matrix;
		else if (n%2==0){
			opCount+=1;
			Matrice2D  res = puissanceRec(matrix,n/2);
			return res.multiplie(res);
		}
		else {
			opCount+=2;
			Matrice2D res = puissanceRec(matrix,n/2);
			return res.multiplie(res).multiplie(matrix);
		}
		
	}
	
	

	/**
	 * Renvoie le type d'algorithme implanté pour calculer M^n
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name() {
		return "(Calcul de M^n par Puissance rapide, 'square-and-multiply')";
	}

	/**
	 * Renvoie le nombre de multiplications de matrices effectuées
	 * par le dernier appel à la méthode puissance.
	 *
	 *   @return le nombre de multiplications
	 */
	public long operations() {
		return opCount;
	}

}
