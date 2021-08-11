public class Test3a {

	public static void melangeTableau(int[] tab){
		for(int i=tab.length-1; i>0; i--){
		   int j=(int)(Math.random()*(i+1));
		   Tournoi.echange(tab,j, i);
		}
	}
	
	public static void main(String[] args){
		int[] t=Tournoi.tableauOrdonne(16);
		melangeTableau(t);
		Tournoi.afficheTour(t);
	}
}