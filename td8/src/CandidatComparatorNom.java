public class CandidatComparatorNom implements CandidatComparator {

	@Override
	public int compare(Candidat a, Candidat b) {
		int cmp = a.getNom().compareTo(b.getNom());
		if (cmp == 0) {
			cmp = a.getPrenom().compareTo(b.getPrenom());
		}
		return cmp;
	}

}
