import tc.TC;

public class TestExercice2 {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		TC.println("-- redirection de sortie vers fichier SortieExercice2.txt");
		TC.ecritureDansNouveauFichier("SortieExercice2.txt");
		CandidatUtil.printCandidatsTable(CandidatUtil.readCandidatsFromFile("candidats.txt"));
	}
}
