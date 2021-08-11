public class Mystere implements Objet {

	private int poids;
	private int valeur;

	public Mystere(int poids, int valeur) {
		this.poids = poids;
		this.valeur = valeur;
	}

	public static Mystere random() {
		return new Mystere(
				Objet.RANDOM.nextInt(2000),
				Objet.RANDOM.nextInt(20000));
	}

	public String toString() {
		return "Un objet mystérieux";
	}

	public int poids() {
		return this.poids;
	}

	@Override
	public int valeur() {
		return this.valeur;
	}

}
