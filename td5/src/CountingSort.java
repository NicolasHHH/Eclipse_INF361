import java.util.Arrays;

public class CountingSort implements SortingAlgorithm {

	private Candidat[] a;
	private Candidat[] b;
	private int[] count;
	private CountingSortAdapter adapter;

	public CountingSort(Candidat[] data, CountingSortAdapter adapter) {
		this.a = data;
		this.adapter = adapter;
		this.b = new Candidat[data.length];
		this.count = new int[adapter.getMaxValue() + 1];
	}

	@Override
	public void run() {
		// trier par note
		for ( int i = 0; i< a.length; i ++) {
			this.count[adapter.getValue(a[i])]++ ;
		}

		count[0] = count[0]-1; // postion = ordre -1
		for ( int i = 1; i< adapter.getMaxValue()+1; i ++) {
			count[i] = count[i] + count[i-1];
		}

		
		for ( int i = a.length-1; i>=0; i --) {
			
			b[this.count[adapter.getValue(a[i])]] = a[i];
			this.count[adapter.getValue(a[i])]--;
		}
		
		for ( int i = 0; i< a.length; i ++) {
			this.a[i] = this.b[i] ;
		}
	}

}
