import java.util.Random;

import tc.TC;

public class TestItineraire4 {
  private final static long SEED = 12345678L;
  private final static Random random = new Random(SEED);

  private static void tester(Itineraire itineraire, Position[] emplacements) {
    TC.println("=== test plusProche ===");
    for (int i = 0; i < emplacements.length; ++i) {
      TC.println("plus proche de " + emplacements[i] + " = "
          + itineraire.plusProche(emplacements[i]));
    }
  }

  private static void tester() {
    final int N = 6;
    int[] latitudes = new int[N];
    int[] longitudes = new int[N];
    for (int i = 0; i < N; ++i) {
      latitudes[i] = random.nextInt(1000);
      longitudes[i] = random.nextInt(1000);
    }
    Position[] tabPositions = new Position[N];
    Itineraire iti0 = new Itineraire("pseudo_zero", tabPositions.length);
    for (int i = 0; i < N; ++i) {
      Instant t = new Instant(random.nextInt(10) + random.nextInt(10) + ":"
          + random.nextInt(10) + random.nextInt(10));
      tabPositions[i] = new Position(t, latitudes[i], longitudes[i]);
      iti0.ajouter(tabPositions[i]);
    }
    Itineraire iti1 = new Itineraire("pseudo_un", tabPositions.length);
    Itineraire iti2 = new Itineraire("pseudo_deux", tabPositions.length / 2);
    int j = 0;
    while (j < N) {
      iti1.ajouter(tabPositions[j++]);
      iti2.ajouter(tabPositions[j++]);
    }
    Itineraire iti3 = new Itineraire("pseudo_trois", 0);
    Position[] tabEmplacements = new Position[] {
        new Position(latitudes[2] + 10, longitudes[2]),
        new Position(latitudes[0], longitudes[0]),
        new Position(latitudes[5], longitudes[5] + 30),
        new Position(latitudes[1], longitudes[2]),
        new Position(latitudes[2], longitudes[1]),
        new Position((latitudes[1] + latitudes[2]) / 2,
            (longitudes[1] + longitudes[2]) / 2),
        //
    };
    tester(iti0, tabEmplacements);
    tester(iti1, tabEmplacements);
    tester(iti2, tabEmplacements);
    tester(iti3, new Position[] { new Position(latitudes[0], longitudes[0]) });
  }

  public static void main(String[] args) {
    TC.ecritureDansNouveauFichier("output_test_itineraire_4.txt");
    tester();
  }
}
