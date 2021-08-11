public class Parchemin implements Objet {

	private static final String[] TYPES = {
			"de confusion",
			"de téléportation",
			"de lumière",
			"de feu",
			"vierge",
			"de Java"
	};

	String type;

	public Parchemin(String type) {
		this.type = type;
	}

	public static Parchemin random() {
		int i = Objet.RANDOM.nextInt(TYPES.length);
		return new Parchemin(TYPES[i]);
	}

	public String toString() {
		return "Un parchemin " + type; 
	}

	public int poids() {
		return 20;
	}

	public int valeur() {
		return 300;
	}

}
