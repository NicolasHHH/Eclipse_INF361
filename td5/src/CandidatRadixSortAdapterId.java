
public class CandidatRadixSortAdapterId implements RadixSortAdapter {

	@Override
	public int getNumberOfDigits() {
		return 4; // toujours 4 characteres pour l'ID de dossier
	}

	@Override
	public CountingSortAdapter getCountingSortAdapter(int pos) {
		return new CandidatCountingSortAdapterId(pos);
	}

}
