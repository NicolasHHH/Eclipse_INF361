import tc.TC;

public class TestExercice6 {
	public static void main(String[] args) {
		
	    ABR T3 = new ABR(); //"test-3"
	
		TC.lectureDansFichier("grec.txt");
		T3.indexerTexte( );
		if(!T3.estValide()) throw new AssertionError("Arbre incorrect");

    	ListeEntrees entrees = T3.liste( );
    	TC.println("Entrées en ordre alphabétique :");
    	TC.println(entrees);
		
    }
}
