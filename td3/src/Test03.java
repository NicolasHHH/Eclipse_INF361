import tc.TC;
public class Test03 {

	public static void main(String[] args) {
		
		Monnaie rouble=new Monnaie("Rouble",0.02);

        	Argent a1 = new Argent(68);
		Argent a2 = new Argent(17401, rouble);

		
		TC.println("-- test toString : attend 0.68 Euro");
		TC.println(a1.toString());

		TC.println("-- test toString : attend 174.01 Roubles");
		TC.println(a2); // appel implicite de a2.toString()
	}

}
