import java.util.Arrays;

import tc.TC;

public class TestExercice3 {
	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] candidats;

		TC.println("-- redirection de sortie vers fichier SortieExercice3.txt");
		TC.ecritureDansNouveauFichier("SortieExercice3.txt");
		TC.println("trier par ordre des notes");

		// lecture et tri
		candidats = CandidatUtil.readCandidatsFromFile("candidats.txt");
		Arrays.sort(candidats, new CandidatComparatorNote());

		CandidatUtil.printCandidatsTable(candidats);

		TC.println();
		TC.println("et maintenant par ordre lexicographique nom - prenom");

		// relecture et deuxieme tri
		candidats = CandidatUtil.readCandidatsFromFile("candidats.txt");
		Arrays.sort(candidats, new CandidatComparatorNom());
		CandidatUtil.printCandidatsTable(candidats);

		TC.println();
		TC.println("et maintenant par ordre d'identifiant de dossier");

		// relecture et troisième tri
		candidats = CandidatUtil.readCandidatsFromFile("candidats.txt");
		Arrays.sort(candidats, new CandidatComparatorId());
		CandidatUtil.printCandidatsTable(candidats);
	}
}
