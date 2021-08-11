
public class Valar {
	public int n;
    public void n(){
        this.n += 3;
    }
    public Valar(int n){
        this.n = n;
    }
    public static void f(int[] t){
        t = new int[]{0, 1, 2};
    }
    
    public static void incremente(int[] t) {
    	  int[] u = t;
    	  for (int i = 1; i < u.length; i++)
    	    u[i] = t[i-1] + 1;
    	}
    public static void f4(int[] t, int i, int j) {
        int z = --t[i];
        t[i] = t[j]++;
        t[j] = ++z;
      }
    
    
    public static void main(String[] args){
        Valar n = new Valar(0);
        n.n();
        System.out.println(n.n);
        int[] t = new int[]{100, 200, 300};
        f(t);
        System.out.println(t[0]);
        
        t = new int[] { 0, 0, 0, 0 };
        incremente(t);
        System.out.println(t[0] + " " + t[1] + " " + t[2] + " " + t[3]);
        
        t = new int[]{ 1, 2, 3, 4 };
        for (int i = 0; i < 2; ++i)
          f4(t, i, t.length - i - 1);
        System.out.println(t[0] + " " + t[1] + " " + t[2] + " " + t[3]);
        
    }

}
