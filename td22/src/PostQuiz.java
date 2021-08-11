
public class PostQuiz {
	public static int g(int n, int m){
		m++;
		n += m;
		return n;
	}
	public static void f7(int[] t) {
	      int[] u = t;
	      for (int i = 0; i < u.length; i++)
	        ++u[i];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int somme = 0;
		int N = 10;
		for (int i = 0; i<N;i++) {
			int n = 128;
			int count = 0;
		    while (n > 0) {
		      int nn = 1 + (int)(Math.random()*n); // nn ∈ [1 ..n] si n > 0
		      for (int j = 0; j < nn; ++j)
		        ++count;
		      n -= nn;
		    }
		    System.out.println(count);
		    somme += count;
		}
		System.out.println(somme/(N+0.0));
		int n = 1, m = 2;
		System.out.println("n="+g(n, m)+" m="+m);
		
		
		n=12;
		int[][] prod = new int[n][n];
		

		int[] t = new int[]{ 1, 2 };
	    f7(t);
	    System.out.println(t[0] + " " + t[1]);
	    
	    int k = 0;
	    for (int i = 1; i <= 4; i = i*2)
	      for (int j = 0; j < i; j++){
	        System.out.print(k);
	        k++;
	    }
	    
	    int[] T = new int[]{ 0 };
	    int[] u = T;
	    int[] v = new int[]{ 0 };
	    System.out.println(T[0] + " " + u[0] + " " + v[0]);
	    ++T[0];
	    System.out.println(T[0] + " " + u[0] + " " + v[0]);
	    T[0] = u[0];
	    System.out.println(T[0] + " " + u[0] + " " + v[0]);
	    v[0] = u[0];
	    System.out.println(T[0] + " " + u[0] + " " + v[0]);
	    ++u[0];
	    System.out.println(T[0] + " " + u[0] + " " + v[0]);
	}

}
