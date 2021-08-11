import java.math.BigInteger;

/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Calcul recursif (très lent) de la suite de Fibonacci
 *
 */
public class FibonacciRec implements Fibonacci {

	/** Compteur d'opérations */
	private long opCount;

	/**
	 * Calcul basé sur la définition récursive de Fibonacci
	 * F(n):=F(n-1)+F(n-2), pour n>1
	 *
	 *  @param n le rang du nombre à calculer
	 *  @return F(n)
	 */
	public BigInteger fibo(int n) {
		opCount = 0;
		return fiboRec(n);
	}

	private BigInteger fiboRec(int n) {
		
		if ( n == 0) return BigInteger.ZERO;
		else if( n == 1) return BigInteger.ONE;
		else {
			opCount += 1;
			return fiboRec(n-1).add(fiboRec(n-2));
		}
		
		
		//throw new Error("A completer");
	}

	/**
	 * Renvoie le type d'algorithme implanté pour calculer F(n)
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name() {
		return "Fibonacci recursif";
	}

	/**
	 * Renvoie le nombre d'additions et multiplications de grands
	 * entiers effectuées par le dernier appel à la méthode fibo.
	 *
	 *   @return le nombre d'additions/multiplications
	 */
	public long operations() {
		return opCount;
	}

}
