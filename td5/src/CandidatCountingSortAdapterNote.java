
public class CandidatCountingSortAdapterNote implements CountingSortAdapter {

	@Override
	public int getMaxValue() {
		return 20; // de 0 a 20
	}

	@Override
	public int getValue(Candidat candidat) {
		return candidat.note;
	}

}
