import tc.TC;

public class TestExercice5b {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] candidats = CandidatUtil.readCandidatsFromFile("candidats.txt");

		new MergeSort(candidats, new CandidatComparatorNote()).run();

		TC.println("-- redirection de sortie vers fichiers SortieExercice5b1.txt et SortieExercice5b2.txt");

		TC.ecritureDansNouveauFichier("SortieExercice5b1.txt");
		CandidatUtil.printCandidatsTable(candidats);

		new MergeSort(candidats, new CandidatComparatorNom()).run();
		TC.ecritureDansNouveauFichier("SortieExercice5b2.txt");
		CandidatUtil.printCandidatsTable(candidats);

	}
}
