import tc.TC;

public class TestExercice5a {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] candidats = new Candidat[8];
		candidats[0] = new Candidat("BERTHELEIN DONIA 7 101A");
		candidats[1] = new Candidat("CERTHELEIN DONIB 9 101B");
		candidats[2] = new Candidat("DERTHELEIN DONIC 8 101C");
		candidats[3] = new Candidat("EERTHELEIN DONID 10 101D");
		candidats[4] = new Candidat("FERTHELEIN DONIE 7 101E");
		candidats[5] = new Candidat("GERTHELEIN DONIF 7 101F");
		candidats[6] = new Candidat("HERTHELEIN DONIG 7 101G");
		candidats[7] = new Candidat("IERTHELEIN DONIH 8 101H");
		MergeSort sort = new MergeSort(candidats, new CandidatComparatorNote());

		TC.println("-- redirection de sortie vers fichiers SortieExercice5a.txt");

		TC.ecritureDansNouveauFichier("SortieExercice5a.txt");
		sort.merge(0, 2, 4);
		sort.merge(4, 6, 8);
		CandidatUtil.printCandidatsTable(candidats);

	}
}
