import tc.TC;

public class TestExercice5 {
    public static void main(String[] args) {
    	
	    ABR b = new ABR(); //"grec"
	    TC.lectureDansFichier("grec.txt");
	    b.indexerTexte( );
	    if(!b.estValide()) throw new AssertionError("Arbre incorrect");
    	b.imprimer("grec");
    	
    	TC.println("COMPARER grec.index et grec.index.ref" );
    	
    }
}
