public class CandidatComparatorNote implements CandidatComparator {

	@Override
	public int compare(Candidat c1, Candidat c2) {
		if (c1.note<c2.note) return -1;
		else if (c1.note==c2.note) return 0;
		else return 1;
	}

}
