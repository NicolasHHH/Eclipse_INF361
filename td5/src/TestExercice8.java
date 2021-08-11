import tc.TC;

public class TestExercice8 {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] table = CandidatUtil.readCandidatsFromFile("candidats.txt");

		RadixSort sort = new RadixSort(table, new CandidatRadixSortAdapterId());
		sort.run();

		TC.println("-- redirection de sortie vers fichiers SortieExercice8.txt");

		TC.ecritureDansNouveauFichier("SortieExercice8.txt");

		CandidatUtil.printCandidatsTable(table);
	}
}
