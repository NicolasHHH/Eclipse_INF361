public interface ResolutionSacADos {

	/** Résout le problème du sac à dos
	 * @param objets	objets dont il faut choisir un sous-ensemble
	 * @param capacite	poids maximal que le sac peut contenir
	 * @return un sac à dos rempli avec un sous-ensemble des objets qui maximise la somme des valeurs 
	 */
	public SacADos remplirSac(Objet[] objets, int capacite);

	/** Description de l'algorithme de résolution */
	public String name();

}