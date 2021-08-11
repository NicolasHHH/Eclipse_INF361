
public class RadixSort implements SortingAlgorithm {

	private RadixSortAdapter adapter;
	private Candidat[] data;

	public RadixSort(Candidat[] data, RadixSortAdapter adapter) {
		this.adapter = adapter;
		this.data = data;
	}

	@Override
	public void run() {
		// a completer
		int nb_digits = adapter.getNumberOfDigits();
		for (int i = nb_digits-1; i>=0;i--) {
			CountingSort CS = new CountingSort (this.data, this.adapter.getCountingSortAdapter(i) );
			CS.run();
		}
	}

}
