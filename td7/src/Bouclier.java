public class Bouclier implements Objet {

	private boolean magique = false;

	public Bouclier() {};

	private Bouclier(boolean magique) {
		this.magique = magique;
	}

	public static Bouclier random() {
		return new Bouclier (Objet.RANDOM.nextInt(3) == 0);
	}

	public String toString() {
		return "Un bouclier" + (magique ? " magique" : "");
	}

	public int poids() {
		return magique ? 2000 : 8000;
	}

	public int valeur() {
		return 600;
	}

}