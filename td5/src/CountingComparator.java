
public class CountingComparator extends CandidatComparatorNote {
	private long counter = 0;

	@Override
	public int compare(Candidat c1, Candidat c2) {
		counter++;
		return super.compare(c1, c2);
	}

	public void reset() {
		this.counter = 0;
	}

	public long getCount() {
		return this.counter;
	}

}
