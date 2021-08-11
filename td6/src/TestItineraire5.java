import java.util.Arrays;
import java.util.Random;

import tc.TC;

public class TestItineraire5 {
	private final static long SEED = 12345678L;
	private final static Random random = new Random(SEED);

	private static void tester(Itineraire iti_1, Itineraire iti_2, int seuil) {
		TC.println("=== test contacts ===");
		TC.println(Arrays.toString(iti_1.contacts(iti_2, seuil)));
	}

	private static void tester() {
		final int N = 6;
		int[] latitudes = new int[N];
		int[] longitudes = new int[N];
		for (int i = 0; i < N; ++i) {
			latitudes[i] = random.nextInt(1000);
			longitudes[i] = random.nextInt(1000);
		}
		int[] sizes = { 3, 13, 19, 41 };
		Itineraire[] itineraires = new Itineraire[sizes.length];
		int j;
		for (int i = 0; i < itineraires.length; ++i) {
			itineraires[i] = new Itineraire("pseudo_" + i, sizes[i] + i);
			for (j = 0; j < sizes[i]; ++j) {

				Instant t = new Instant(
						random.nextInt(2) + random.nextInt(7) + ":" + random.nextInt(5) + random.nextInt(8));

				Position p = new Position(t, latitudes[5] + random.nextInt(2), longitudes[0] + random.nextInt(2));

				itineraires[i].ajouter(p);
			}
			itineraires[i].trier();
		}
		tester(itineraires[0], itineraires[0], 2);
		tester(itineraires[0], itineraires[1], 4); tester(itineraires[0],itineraires[2], 4);
		tester(itineraires[3], itineraires[0], 3);
		tester(itineraires[1], itineraires[3], 3); tester(itineraires[3],itineraires[2], 4);
		 
	}

	public static void main(String[] args) {
		TC.ecritureDansNouveauFichier("output_test_itineraire_5.txt");
		tester();
	}
}