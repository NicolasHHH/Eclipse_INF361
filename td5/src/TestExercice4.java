import tc.TC;

public class TestExercice4 {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] candidats = CandidatUtil.readCandidatsFromFile("candidats.txt");

		new InsertionSort(candidats, new CandidatComparatorNote()).run();

		TC.println("-- redirection de sortie vers fichiers SortieExercice4a.txt et SortieExercice4b.txt");
		TC.ecritureDansNouveauFichier("SortieExercice4a.txt");
		CandidatUtil.printCandidatsTable(candidats);

		new InsertionSort(candidats, new CandidatComparatorNom()).run();
		TC.ecritureDansNouveauFichier("SortieExercice4b.txt");
		CandidatUtil.printCandidatsTable(candidats);

	}
}
