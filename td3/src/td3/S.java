package td3;

public class S {
	  public String s;
	  public S(String s) {
	    this.s = s;
	  }
	  public static void echanger1(S s1, S s2){
	    S tmp= s1;
	    s1 = s2;
	    s2 = tmp;
	  } 
	  public static void echanger2(S s1, S s2){
		    String tmp= s1.s;
		    s1.s = s2.s;
		    s2.s = tmp;
		  }
	  
	  public static void echanger3(S[] t, int i, int j){
		    S tmp= t[i];
		    t[i] = t[j];
		    t[j] = tmp;
		  } 
	  
	  public static void main(String[] args) {
		  S s1 = new S("un");
		  S s2 = new S("deux");
		  S[] t = new S[] { s1, s2 };
		  S s3 = s2;
		  S.echanger3(t, 0, 1);
		  System.out.println(s1.s + " " + s2.s+ " " + (t[0]==s3));
		  
		  String[] tf = new String[5];
		  System.out.println(tf[0] == null);
		  String[] t2 = new String[5];
		  System.out.println(t2[0].length() == 0);
	  }
	}
