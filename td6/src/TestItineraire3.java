import java.util.Arrays;
import java.util.Random;

import tc.TC;

public class TestItineraire3 {
	private final static long SEED = 123456789L;
	private final static Random random = new Random(SEED);

	private static void afficher(Itineraire itineraire) {
		TC.println(itineraire);
		
		TC.println(Arrays.toString(itineraire.instants() ));
	}

	private static void tester() {
		TC.println("=== test ajouter et instants ===");
		Position[] tabPositions = new Position[6];
		Itineraire iti0 = new Itineraire("pseudo_zero", tabPositions.length);
		for (int i = 0; i < tabPositions.length; ++i) {
			
			Instant t = new Instant( random.nextInt(10)+ random.nextInt(10) +  ":" + random.nextInt(10) + random.nextInt(10));
			
			
			tabPositions[i] = new Position(t, random.nextInt(1000), random.nextInt(1000));
			iti0.ajouter(tabPositions[i]);
		}
		afficher(iti0);
		Itineraire iti1 = new Itineraire("pseudo_un", tabPositions.length);
		Itineraire iti2 = new Itineraire("pseudo_deux", tabPositions.length / 2);
		int j = 0;

		while (j < tabPositions.length) {
			iti1.ajouter(tabPositions[j++]);
			iti2.ajouter(tabPositions[j++]); 
		}
		afficher(iti1);
		Itineraire iti3 = new Itineraire("pseudo_trois", 0);
		afficher(iti3);
		afficher(iti2);
	}

	public static void main(String[] args) {
		TC.ecritureDansNouveauFichier("output_test_itineraire_3.txt");
		tester();
	}
}
