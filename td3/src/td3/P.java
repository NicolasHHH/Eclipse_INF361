package td3;

public class P {
	
	public int a, b;
	  public P(int x, int y) {
	    this.a = x;
	    this.b = y;
	  }
	  public P somme1(P p){
	    this.a = this.a + p.a;
	    this.b = this.b + p.b;
	    return this;
	  } 
	  public P somme2(P p){
		    return new P(this.a + p.a, this.b + p.b);
	  } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P p1 = new P(1, 2);
		P p2 = new P(3, 4);
		P p3 = p2.somme2(p1.somme2(p2));
		System.out.println(p1.a + " " + p1.b + " " + p2.a + " " + p2.b + " " + p3.a + " " + p3.b);

	}

}
