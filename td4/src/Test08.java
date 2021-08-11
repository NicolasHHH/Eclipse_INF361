import tc.TC;
public class Test08 {
	public static void main(String[] args) {
		Liquide l1=new Liquide(new Argent(1432558));
		TC.println("--attend 14325.58 Euros");
		TC.println(l1.montant());
		Liquide l2=new Liquide(new Argent(12309,new Monnaie("Yuan",7.82)));
		TC.println("--attend 123.09 Yuans");
		TC.println(l2.montant());
	}
}

