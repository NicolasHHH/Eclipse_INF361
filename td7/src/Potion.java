public class Potion implements Objet {

	private static final int POIDS_FIOLE = 100;
	private static final int CONTENANCE_FIOLE = 500;

	private int ml;
	private int sous_par_ml;

	public Potion(int ml, int sous_par_ml) {
		if (ml > CONTENANCE_FIOLE) {
			throw new Error("la fiole ne fait que " + CONTENANCE_FIOLE + "ml");
		}
		this.sous_par_ml = sous_par_ml;
		this.ml = ml;
	}

	public static Potion random() {
		return new Potion(
				Objet.RANDOM.nextInt(CONTENANCE_FIOLE),
				(int) ((2 - Math.log(1 - Objet.RANDOM.nextDouble()))));
	}

	public String toString() {
		return String.format("%d ml de potion à %d sou%s/ml", ml, sous_par_ml, sous_par_ml > 1 ? "s" : "");
	}

	public int poids() {
		return POIDS_FIOLE + ml;
	}

	public int valeur() {
		return ml*sous_par_ml;
	}

}
