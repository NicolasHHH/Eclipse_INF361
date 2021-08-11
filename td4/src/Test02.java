import tc.TC;
public class Test02 {
	public static void main(String[] args) {
		Monnaie[] tab={
				new Monnaie("Euro",1),
			    new Monnaie("Dollar",1.20)
		};
		
		long numero = 99887766;
		Argent a = new Argent(554433);
		String nom = "Agathe_Oursin";
		int plafond = 150;
		String s = "" + numero + " " + nom + " " + a + " " + plafond;
		TC.println(s);
		TC.println("-- test constructeur Compte(String) ");
		Compte c = new Compte(s,tab);
		TC.println("-- numero : attend " + numero);
		TC.println(c.numero);
		TC.println("-- nom : attend " + nom);
		TC.println(c.nom);
		TC.println("-- solde : attend " + a);
		TC.println(c.getSolde());
		TC.println("-- plafond : attend " + plafond);
		TC.println(c.getPlafond());
	}
}
