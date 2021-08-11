package td22;

import tc.TC;

public class C2_Syracuse {
	
	
	public static int Syracuse(int m, boolean affiche){
		int it = 0; 
		do {
		    it++;
		    if(affiche)
		      TC.print(m + " -> ");
		    if((m % 2) == 0)
				m /= 2;
			else
				m = 3*m+1;
		  } while(m > 1);
		
		if(affiche)
		   TC.println("1");
		return it; 
	}
	
	public static void statsDansFichier(int nmin, int nmax,String nom){
	     TC.ecritureDansNouveauFichier(nom);
	     for(int n = nmin; n < nmax; n++){
	       int it = Syracuse(n, false);
	       TC.println(n+" "+it);
	     }
	}
	public static void statsDepuisFichier(int nmin, int nmax,String nom){
		TC.lectureDansFichier(nom);
	    for(int n = nmin; n < nmax; n++){
	      int nn = TC.lireInt(), it = TC.lireInt();
	      System.out.println(n + " " + it);
	    }
	}

	  public static void main(String[] args){
		  statsDansFichier(3,6 ,"Syracuse101.txt");
		  System.out.println("-----");
		  statsDepuisFichier(3,6 ,"Syracuse101.txt");
		  
	  }

}

