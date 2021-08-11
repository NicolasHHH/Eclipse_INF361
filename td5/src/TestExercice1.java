import tc.TC;

public class TestExercice1 {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		TC.println("-- redirection de sortie vers fichier SortieExercice1.txt");
		TC.ecritureDansNouveauFichier("SortieExercice1.txt");

		TC.println("premier constructeur");
		TC.println(new Candidat("BERTHELEIN", "DONIA", 7, new DossierId("101B")));

		TC.println("deuxieme constructeur");
		TC.println(new Candidat("BERTHELEIN DONIA 7 101B"));
	}
}
