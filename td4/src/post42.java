import java.util.Arrays;

public class post42 {
	public String s;
	public post42() {
		
	}
	public post42(String s) {
			
		}
	public String toString() {
		return this.s;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		post42 o1 = null;
		post42 o2 = new post42();
		post42 o3 = new post42(null);
		System.out.println(o1+" "+o2+" "+o3);
		String s= "";
		System.out.println((s==null)+" "+s.equals(null)+" "+(s.length()==0));
		
		int[] t = new int[] {1,2};
		int[] u = new int[] {t[0],t[1]};
		System.out.println((t==u)+" "+t.equals(u)+" "+Arrays.equals(t,u));
	}

}
