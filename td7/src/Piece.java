public class Piece implements Objet {

	private static final int[] VALEURS = { 1, 2, 5, 10 };

	private int ecus;

	public Piece(int ecus) {
		this.ecus = ecus;
	}

	public static Piece random() {
		int i = Objet.RANDOM.nextInt(VALEURS.length);
		return new Piece(VALEURS[i]);
	}

	public String toString() {
		return "Une pièce de " + ecus + " écu" + (ecus > 1 ? "s" : "");
	}

	public int poids() {
		return 42*ecus;
	}

	public int valeur() {
		return 100*ecus;
	}

}
