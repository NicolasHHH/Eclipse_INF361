import tc.TC;
public class Test06 {
	public static void main(String[] args) {
		Monnaie[] tab={
			new Monnaie("Euro",1),
	    		new Monnaie("Dollar",0.94),
	    	};		
		String s = "1.95 Dollar";
		TC.println("-- test constructeur Argent(String) : attend 1.95 Dollar");
		Argent a1 = new Argent(s,tab);
		TC.println(a1);
		s = "187.25 Euros";
		TC.println("-- test constructeur Argent(String) : attend 187.25 Euros");
		Argent a2 = new Argent(s,tab);
		TC.println(a2);
	}
}
