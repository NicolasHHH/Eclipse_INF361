import tc.TC;

public class MergeSort implements SortingAlgorithm {

	private Candidat[] table; // tableau a trier
	private CandidatComparator comparator; // definit la relation d'ordre
	private Candidat[] tmp;

	public MergeSort(Candidat[] table, CandidatComparator comparator) {
		this.table = table;
		this.comparator = comparator;
		this.tmp = new Candidat[table.length];
	}

	public void run() {
		int left = 0;
		int right, middle;
		int len = table.length;
		int pow2k,taille,k;
		
		for (k = 0,pow2k = 1;pow2k <len;k++) {
			pow2k *= 2;
		}
		for(int i = 1; i <= k; i++){
			taille = 1 << i;
			left = 0;
			for(int j = 0; j <len/taille; j++){
				middle = left+(taille/2); 
				right = left+taille; 
				merge(left, middle, right);
				left = right;
			}
			if(left < len){
				middle = left+(taille/2); 
				if(middle < len)
					merge(left, middle, len);
			}
		}
	}

	public void merge(int left, int middle, int right) {
		// a completer
		int l = left;
		int r = middle;
		int compareRes = 0;
		int pos = 0;
		while(l<middle && r<right) {
			compareRes = comparator.compare(this.table[l], this.table[r]);
			if (compareRes <= 0) {
				this.tmp[pos] = this.table[l];
				l++;
			}
			else  {
				this.tmp[pos] = this.table[r];
				r++;
			}
			pos++;
		}
		if (l<middle) {
			for (int k = l; k < middle; k++) this.tmp[pos++] = this.table[k];
		}
		if (r<right) {
			for (int k = r; k < right; k++) this.tmp[pos++] = this.table[k];
		}
		
		for (int m = left; m < right; m++) {
			this.table[m] =  this.tmp[m-left]; 
		}
	}

}
