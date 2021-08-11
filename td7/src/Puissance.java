/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Interface definissant le calcul d'une puissance d'une matrice 2x2
 *
 * On manipule des nombres entiers de grande taille,
 * et on suppose que n est un entier positif de taille "bornee"
 * (n<= 2^31-1, comme c'est un int)
 */
public interface Puissance {

	/**
	 * Calcule et renvoie M^n (puissance n-ième d'une matrice 2x2)
	 *
	 *  @param matrix
	 * 		matrice 2x2 en entrée
	 *  @param n
	 *  		exposant
	 *  @return M^n
	 */
	public Matrice2D puissance(Matrice2D matrix, int n);

	/**
	 * Renvoie le type d'algorithme implanté pour calculer M^n
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name();

	/**
	 * Renvoie le nombre de multiplications de matrices effectuées
	 * par le dernier appel à la méthode puissance.
	 *
	 *   @return le nombre de multiplications
	 */
	public long operations();


}
