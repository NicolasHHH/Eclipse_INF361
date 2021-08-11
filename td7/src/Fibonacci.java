import java.math.BigInteger;

/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Interface definissant le calcul de la suite de Fibonacci
 *
 * On manipule des nombres entiers de grande taille,
 * et on suppose que n est un entier positif de taille "bornee"
 * (n<= 2^31-1, comme c'est un int).
 *
 * En parallele, on compte les operations sur des entiers
 * effectuees pour faire le calcul.
 */
public interface Fibonacci {

	/**
	 * Calcule et renvoie F(n), le terme de rang n de la suite de Fibonacci
	 *
	 *  @param n le rang du nombre à calculer
	 *  @return F(n)
	 */
	public BigInteger fibo(int n);

	/**
	 * Renvoie le type d'algorithme implanté pour calculer F(n)
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name();

	/**
	 * Renvoie le nombre d'additions et multiplications de grands
	 * entiers effectuées par le dernier appel à la méthode fibo.
	 *
	 *   @return le nombre d'additions/multiplications
	 */
	public long operations();

}

