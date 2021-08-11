public class Caillou implements Objet {

	private int kg;

	public Caillou(int kg) {
		this.kg = kg;
	}

	public static Caillou random() {
		return new Caillou(Objet.RANDOM.nextInt(14) + 1);
	}

	public String toString() {
		return String.format("Un caillou de %d kg", kg);
	}

	public int poids() {
		return 1000*kg;
	}

	public int valeur() {
		return 2;
	}

}