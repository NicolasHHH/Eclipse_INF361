import tc.TC;

public class TestSacH {
	public static void testH(ResolutionSacADos[] solvers) {
		Objet[] objets = new Objet[] {
				new Caillou(4),
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testH(new ResolutionSacADos[] {new ResolutionExacte()});
	}

}
