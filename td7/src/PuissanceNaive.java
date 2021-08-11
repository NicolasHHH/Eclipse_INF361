import java.math.BigInteger;

public class PuissanceNaive implements Puissance {

	/** Compteur d'opérations */
	private long opCount = 0;

	/**
	 * Calcule la puissance d'une matrice de maniere naive:
	 * M^n=M^(n-1)*M
	 */
	public Matrice2D puissance(Matrice2D matrix, int n) {
		opCount = 0;
		return puissanceRec(matrix,n);
		
		//throw new Error("A completer");
	}
	public Matrice2D puissanceRec(Matrice2D matrix, int n) {
		if ( n == 0) {
			return Matrice2D.identite();
		}
		else if( n == 1) {
			return matrix;
		}
		else {
			opCount++;
			return matrix.multiplie(puissanceRec(matrix, n-1));
		}
	}
	
	
	
	/**
	 * Renvoie le type d'algorithme implanté pour calculer M^n
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name() {
		return "(Calcul de M^n par Puissance naive)";
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
