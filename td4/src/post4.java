
public class post4 {
	public int a, b;
	public post4(int x,int y) {
		this.a = x;
		this.b = y;
	}
	public String toString() {
		return this.a+" "+this.b;
	}
	public static void copier(post4 X,post4 Y) {
		X.a = Y.b;
		Y=X;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		post4[] tab = new post4[3];
		System.out.println(tab[0]+" "+tab[1]);
		post4 c1 = new post4(1,2);
		post4 c2 = new post4(3,4);
		post4.copier(c1, c2);
		System.out.println(c1.a + " " + c1.b+" " + c2.a+" " + c2.b);
	}

}
