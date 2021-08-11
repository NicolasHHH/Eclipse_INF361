
import tc.TC;
public class Test01 {
	public static void main(String[] args) {
		
		Monnaie yuan=new Monnaie("Yuan",7.8);
		TC.println("-- test Monnaie() et getTaux(): attend Yuan et " + 7.8);
		TC.println(yuan.nom+" "+yuan.getTaux());
		TC.println();
		
		yuan.setTaux(7.6);
		
		TC.println("-- test setTaux(double autreTaux) : attend 7.6");
		TC.println(yuan.getTaux());
		TC.println();
	}
}