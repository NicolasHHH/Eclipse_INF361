import tc.TC;

public class TestSacADos {

	public static Objet randomObjet() {
		switch (Objet.RANDOM.nextInt(10)) {
		case 0:
			return new Bouclier();
		case 1:
		case 6:
			return Potion.random();
		case 2:
			return Caillou.random();
		case 3:
		case 7:
			return Parchemin.random();
		case 4:
			return Mystere.random();
		case 5:
			return new Twingo();
		default:
			return Piece.random();
		}
	}

	public static void test1(ResolutionSacADos[] solvers) {
		Objet[] objets = new Objet[] {
				new Caillou(4),
				new Parchemin("de lune"),
				new Bouclier(),
				new Potion(500, 1),
				new Piece(2),
				new Piece(5),
				new Mystere(9970, 2880),
				new Twingo(),
				new Potion(400, 2),
				new Potion(500, 1),
		};

		int[] tailles = {1000, 2000, 5000, 10000};
		for (int i = 0; i < tailles.length; i++)
			for (int j = 0; j < solvers.length; j++) {
				TC.println("=== " + solvers[j].name() + ", " + tailles[i] + " g ===");
				TC.println(solvers[j].remplirSac(objets, tailles[i]));
			}
	}

	public static void test2(int n, long graine, ResolutionSacADos[] solvers) {
		Objet.RANDOM.setSeed(graine);
		TC.println("== Inventaire (graine = " + graine + " ===");
		Objet[] objets = new Objet[n];
		for (int i = 0; i < n; i++) {
			Objet obj = randomObjet();
			TC.print(String.format("%s (%d g, %d sous)\n", obj, obj.poids(), obj.valeur()));
			objets[i] = obj;
		}
		for (int j = 0; j < solvers.length; j++) {
			TC.println("=== " + solvers[j].name() + " ===");
			TC.print(solvers[j].remplirSac(objets, 2000));
		}
	}

	public static void main(String[] args) {
		//test1(new ResolutionSacADos[] {new ResolutionExacte()});
		
		//test2(10, 1, new ResolutionSacADos[] {new ResolutionExacte()});
		test1(new ResolutionSacADos[] {new ResolutionExacte(), new ResolutionApprochee()});
		//test2(40, 0, new ResolutionSacADos[] {new ResolutionApprochee(), new ResolutionExacte()});
	}

}
