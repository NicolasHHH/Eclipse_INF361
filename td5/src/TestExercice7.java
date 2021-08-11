import tc.TC;

public class TestExercice7 {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] table = CandidatUtil.readCandidatsFromFile("candidats.txt");

		CountingSort sort = new CountingSort(table, new CandidatCountingSortAdapterNote());
		sort.run();

		TC.println("-- redirection de sortie vers fichiers SortieExercice7.txt");

		TC.ecritureDansNouveauFichier("SortieExercice7.txt");

		CandidatUtil.printCandidatsTable(table);
	}
}
