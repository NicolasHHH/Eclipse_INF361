import tc.TC;
public class Test03 {
	public static void main(String[] args) {
		TC.println("-- test constructeur Banque(String,int)");
		Banque b = new Banque("Credit_du_Tigre");
		TC.println("-- test toString : attend BANQUE Credit_du_Tigre");
		TC.println(b);	
		TC.println("-- test getNombreDeComptes : attend 0");
		TC.println(b.getNombreDeComptes());
		TC.println("-- test affichage de la banque : attend Credit_du_Tigre en ligne 1, et 0 en ligne 2");
		b.afficher();
	}
}

