
public class flash4 {
	public int b;
	public int a;
	public flash4(int x, int y) {
		this.a = x;
		this.b = y;
	  }
	  public static flash4 action(flash4 p1, flash4 p2,flash4 p3) {
		  if( p3 != p1 )
			  p3 = new flash4(7,8);
		  else
			  p3 = p2;
		  p1= p3;
		  return p1;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		flash4 p1 = new flash4(5,2);
		flash4 p2 = new flash4(3,6);
		flash4 p3 = new flash4(1,4);
		p1= action(p1, p2, p3);
		p3 = action(p1,p2,p1);
		System.out.println(p1.a+" "+p1.b);
		System.out.println(p2.a+" "+p2.b);
		System.out.println(p3.a+" "+p3.b);
		
		int[][] t1 = new int[][] {};
		int[][] t2 = new int[][] {{}};
		int[][] t3 = new int[][] {{0}};
		int[][] t4 = new int[0][1] ;
		
		
		System.out.println(t1.length+" "+t2.length+" "+t3.length+" "+t4.length);

		System.out.println(t2[0].length);
		System.out.println(t3[0].length);
		
	}

}
