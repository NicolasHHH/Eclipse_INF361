import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.NoSuchElementException;

public class SacADos {

	public final int capacite;
	private int capaciteDisponible;
	private int valeur = 0;
	private LinkedHashSet<Objet> contenu = new LinkedHashSet<Objet>();

	/** Initialise un sac à dos vide
	 * @param poids maximal acceptable, en grammes
	 */
	public SacADos(int capacite) {
		this.capacite = capacite;
		this.capaciteDisponible = capacite;
	}

	/** Copie un sac à dos (renvoie un nouveau sac de mêmes capacité et contenu) */
	public static SacADos copie (SacADos sac0) {
		SacADos sac = new SacADos(sac0.capacite); 
		sac.capaciteDisponible = sac0.capaciteDisponible;
		sac.valeur = sac0.valeur;
		sac.contenu = new LinkedHashSet<Objet>(sac0.contenu);
		return sac;
	}

	/** Ajoute un objet dans ce sac, si l'espace disponible le permet */
	public void ajouter(Objet obj) {
		int poids = obj.poids();
		if (poids > capaciteDisponible)
			throw new Error("capacité disponible insuffisante pour " + obj);
		if (contenu.contains(obj))
			throw new Error("objet est déjà dans le sac : " + obj);
		contenu.add(obj);
		capaciteDisponible -= poids;
		valeur += obj.valeur();
	}

	/** Supprime un objet du sac */
	public void retirer(Objet obj) {
		try {
			contenu.remove(obj);
		} catch (NoSuchElementException exn) {
			throw new NoSuchElementException("pas dans le sac : " + obj);
		}
		capaciteDisponible += obj.poids();
		valeur -= obj.valeur();
	}

	/** @return le poids disponible pour ajouter de nouveaux objets */
	public int capaciteDisponible() {
		return capaciteDisponible;
	}

	/* @return la somme des valeurs des objets contenus dans le sac */
	public int valeur() {
		return valeur;
	}

	/* @return une chaîne de caractère qui décrit le contenu du sac */
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(String.format(Locale.ROOT,
				"Sac de %.3f kg, valeur %d sous, contenant :\n",
				((float) (capacite - capaciteDisponible))/1000,
				valeur));
		for (Objet obj : contenu)
			b.append(String.format("- %s (%d g, %d sous)\n", obj, obj.poids(), obj.valeur()));
		return b.toString();
	}

}
