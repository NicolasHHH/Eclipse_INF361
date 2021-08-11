package td3;

import tc.TC;

public class Postquiz2 {
	public static void addadd(int x, int y) {
		x=x+y;
		TC.println(x);
	}
	
	public static void echange(int[] a,int[] b) {
		a[0]=3;
		int[] u = a;
		a=b;
		b=u;
		a[1]=6;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tt = new int[][] {{8,7},{2,1},{6,5},{4,3}};
		echange(tt[1],tt[3]);
		TC.println(tt[1][0]);
		TC.println(tt[1][1]);
		TC.println(tt[3][0]);
		TC.println(tt[3][1]);
		

	}

}
