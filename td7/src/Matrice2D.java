import java.math.BigInteger;

/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Une classe pour représenter des matrices 2x2, à coefficients entiers (de grande taille)
 *
 */
public class Matrice2D {

	public static final int OP_PAR_MUL = 12; // 8 mul, 4 add

	private BigInteger[] coeff; // coefficients de la matrice, stockés par lignes {M00, M01, M10, M11}

	public Matrice2D(BigInteger[] coeff) {
		this.coeff=coeff;
	}

	/**
	* Renvoie les coefficients de la matrice
	* Remarque: les coefficients de la matrice sont stockés par lignes {M00, M01, M10, M11}
	*
	* @param i
	* 			indice du coefficient à renvoyer
	* @return
	* 			la valeur du coefficient stocké dans la matrice
	*/
	public BigInteger getCoefficient(int i) {
		if(i<0 || i>=4)
			throw new Error("Erreur: problème d'indice non valide "+i);
		return this.coeff[i];
	}

	/**
	* Renvoie les coefficients de la matrice
	*
	* @param i
	* 			ligne du coefficient à renvoyer (0 ou 1)
	* @param j
	* 			colonne du coefficient à renvoyer (0 ou 1)
	* @return
	* 			la valeur du coefficient stocké dans la matrice
	*/
	public BigInteger getCoefficient(int i, int j) {
		return getCoefficient(2*i+j);
	}

	public static Matrice2D identite() {
		BigInteger[] identite = {
			BigInteger.ONE,  BigInteger.ZERO,
			BigInteger.ZERO, BigInteger.ONE};
		return new Matrice2D(identite);
	}

	public Matrice2D multiplie(Matrice2D b) {
		return new Matrice2D(new BigInteger[] {
			this.coeff[0].multiply(b.coeff[0]).add(this.coeff[1].multiply(b.coeff[2])),
				this.coeff[0].multiply(b.coeff[1]).add(this.coeff[1].multiply(b.coeff[3])),
				this.coeff[2].multiply(b.coeff[0]).add(this.coeff[3].multiply(b.coeff[2])),
				this.coeff[2].multiply(b.coeff[1]).add(this.coeff[3].multiply(b.coeff[3]))
		});
	}

}
