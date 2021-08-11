public class CandidatComparatorId implements CandidatComparator {

	@Override
	public int compare(Candidat c1, Candidat c2) {
		
		return c1.dossierId.compareTo(c2.dossierId);
	}

}
