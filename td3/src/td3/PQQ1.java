package td3;

public class PQQ1 {
    public int a, b;
	public PQQ1(int x, int y) {
		 this.a = x;
		 this.b = y;
	}
	public static PQQ1 copier(PQQ1 p, PQQ1 q, int x, int y){
		 q = p;
		 p = new PQQ1(x, y);
		 return p;
    } 

	public static void main(String[] args) {
		PQQ1 p1 = new PQQ1(1, 2);
		PQQ1 p2 = new PQQ1(3, 4);
		PQQ1 p3 = PQQ1.copier(p1, p2, 5, 6);
		System.out.println(p1.a + " " + p1.b + " " + p2.a + " " + p2.b + " " + p3.a + " " + p3.b);

	}

}
