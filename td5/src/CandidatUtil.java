import tc.TC;

public class CandidatUtil {

	public static Candidat[] readCandidatsFromFile(String nomDuFichier) {
		TC.lectureDansFichier(nomDuFichier);
		int nombre = Integer.parseInt(TC.lireLigne());
		Candidat[] CandidatList = new Candidat[nombre];
		for (int i= 0; i< nombre; i ++) {
			String s = TC.lireLigne();
			CandidatList[i] = new Candidat(s);
		}
		TC.lectureEntreeStandard();
		return CandidatList;
	}

	public static void printCandidatsTable(Candidat[] data) {
		TC.println(data.length);

		for (int i = 0; i < data.length; i++) {
			TC.println(data[i]);
		}
	}

}
