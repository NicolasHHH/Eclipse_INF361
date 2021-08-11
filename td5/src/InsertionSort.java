public class InsertionSort implements SortingAlgorithm {

	private Candidat[] table; // tableau a trier
	private CandidatComparator comparator; // definit la relation d'ordre

	public InsertionSort(Candidat[] table, CandidatComparator comparator) {
		this.table = table;
		this.comparator = comparator;
	}

	public void run() {
		// a completer
		int len = this.table.length;
		for (int i = 1; i < len ; i++) {
			for (int j = i; j>0;j--) {
				if (this.comparator.compare(table[j-1],table[j])>0) {
					Candidat temps = table[j-1];
					table[j-1] = table[j];
					table[j] = temps;
				}
				else break;
			}
			
		}	
	}

}
