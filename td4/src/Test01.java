import tc.TC;
public class Test01 {
	public static void main(String[] args) {
		Monnaie euro = new Monnaie("Euro",1);
		Monnaie dollar=new Monnaie("Dollar", 1.20);
		
		Compte c1=new Compte(99887766,"Agathe_Oursin",new Argent(554433,euro),200);
		Compte c2=new Compte(1230945,"Razvan_Burau",new Argent(183,dollar),150);
		
		TC.println("-- test toString : attend 99887766 Agathe_Oursin 5544.33 Euros 200");
		TC.println(c1.toString());

		TC.println("-- test toString : attend 1230945 Razvan_Burau 1.83 Dollar 150");
		TC.println(c2); // appel implicite de c2.toString()
	}
}
