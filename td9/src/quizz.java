
public class quizz {
	public static void echange(int[] a, int[] b) {
		a[0]=3;
		int[] u = a;
		a=b;
		b=u;
		a[1]=6;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]tt = new int[][]{ { 8, 7 }, { 2, 1 }, { 6, 5 }, { 4, 3 } };
		System.out.println(tt[1]+" "+tt[3]);
		echange(tt[1], tt[3]);
		System.out.println(tt[1]+" "+tt[3]);
		System.out.println(tt[1][0]+" "+tt[1][1]+" "+tt[3][0]+" "+tt[3][1]);
		int[] a= {77,99};
		int[] b= {66,33};
		System.out.println(a+" "+b);
		echange(a,b);
		System.out.println(a+" "+b);
		System.out.println(a[0]+" "+a[1]+" "+b[0]+" "+b[1]);
		a[0]= 77;
		b[1]= 33;
		System.out.println(a+" "+b);
		a[0]=3;
		int[] u = a;
		a=b;
		b=u;
		a[1]=6;
		System.out.println(a+" "+b);
		System.out.println(a[0]+" "+a[1]+" "+b[0]+" "+b[1]);
		
		
	}

}
