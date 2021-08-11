import tc.TC;

public class TestExercice4 {
    public static void main(String[] args) {
	    ABR T1 = new ABR(); // "grec"
	    
	    TC.println("Test 4a : ");
	    String[] mots = {"Gamma", "Psi", "Beta", "Phi", "Beta", "Kappa", "Mu", "Delta", "Nu","Gamma","Alpha","Zeta","Lambda"};
	    int[] lignes = {1,1,1,1,2,2,2,2,3,3,3,3,3};
	    for(int i = 0; i < 13; i++) {
	    	TC.print("Tapez enter/retour pour ajouter le "+(i+1)+"-ième mot...");
	    	TC.lireLigne( );
	    	T1.ajouterOccurrence	(mots[i], lignes[i]);
	    	T1.dessiner( );
	    	if(!T1.estValide()) throw new AssertionError("Arbre incorrect apres ajout de "+mots[i]);
	    }
	    
	    TC.println("Test 4b : ");
		ABR T2v = new ABR(); // "test-4b"
		TC.println("Indexation de verne.txt...");
		TC.lectureDansFichier("verne.txt");
		T2v.indexerTexte( );
		TC.println("'colonnes' apparaît aux lignes : " + T2v.chercher("colonnes"));
		
		TC.println();
    	TC.print("Tapez enter/retour pour finir...");
    	TC.lectureEntreeStandard();
    	TC.lireLigne();
    	System.exit(0);
    	
    }
}
