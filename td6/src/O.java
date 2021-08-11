
public class O {
	public int i;
	public O() {
		  }
	public O(int i) {
		    this.i = i;
		  }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		O o1 = null;
		O o2 = new O();
		O o3 = new O(0);
		System.out.println((o2 == o1) + " " + (o2 == o3));
		int x = 0; 
		int count = 0;
	    for (int m = 1; m <= 256; m += m)
	      for (int j = 0; j < m; ++j)
	        ++count;
	    System.out.println(count);
	}

}
