public class CandidatComparatorNom implements CandidatComparator {

	@Override
	public int compare(Candidat c1, Candidat c2) {
		if (c1.nom.compareTo(c2.nom)==0) return c1.prenom.compareTo(c2.prenom);
		
		return c1.nom.compareTo(c2.nom);
	}

}
