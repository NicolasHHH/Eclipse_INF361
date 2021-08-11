import tc.TC;

public class Tournoi {
	public static void afficheTour(int[] tab) {
		int len = tab.length;
		for (int i=0; i<len/2;i++) {
			TC.print("[");
			TC.print(tab[2*i]);
			TC.print(" - ");
			TC.print(tab[2*i+1]);
			TC.print("]");
			if (i<len/2-1) TC.print(" ");
		}
		TC.println();
	}
	public static int[] tableauOrdonne(int n) {
		
		int[] tab = new int[n];
		for(int i = 0; i <n;i++) {
			tab[i]=i+1;
		}
		return tab;
		
	}
	public static void echange(int[] t,int a, int b){
		  int tmp=t[a];
		  t[a]=t[b];
		  t[b]=tmp;
	}
	public static int estUnePermutation(int[] tab) {
		int n = tab.length;
		if (n == 0) return 0;
		int[] aux = new int[n+1];
		for( int i=0;i<n;i++ ) {
			if (tab[i]<1)
				return -1;
			else if (tab[i]>n)
				return -2;
			else {
				if (aux[tab[i]]==tab[i]) return -3;
				else aux[tab[i]]=tab[i]; 
			}
			
		}
		
		return 0;
	}
	
	
	public static int[] tourSuivant(int[] tab, int[] result) {
		int len = result.length;
		int[] retour = new int[len];
		for (int i = 0; i<len;i++) {
			//TC.println(2*i-1+result[i]);
			retour[i] = tab[2*i-1+result[i]];
		}
		
		
		return retour;
		
	}
	public static int vainqueur(int[] tab, int[][] result) {
		for(int[] a : result) {
			afficheTour(tab);
			tab = tourSuivant(tab,a);
		}
		return tab[0];
	}
	
	public static int adversaire(int j, int n) {
		return 2*n+1-j;
	}
	
	public static int[] tourPrecedent(int[] tab) {
		int len = tab.length;
		int[] retour = new int[len*2];
		for(int i = 0; i<len ; i++) {
			retour[2*i] = tab[i];
			retour[2*i+1] = adversaire(tab[i],len);
		}
		
		return retour;
		
	}
	
	public static int[] tableauRealiste(int n) {
		int[] retour = {1,2};
		while(n>2) {
			n/=2;
			retour = tourPrecedent(retour);
		}
		
		return retour;
	}
	
	public static int vainqueurMatch(int i, int j) {
		int eval = (int)(Math.random()*(i+j));
		if (eval >= i) return 1;
		else return 2;
	}
	public static int[][] resultatsRealistes(int[] tab){
		int len = tab.length;
		int K = Integer.numberOfTrailingZeros(len);
		int[][] retour = new int[K][len];
		
		for (int k = 0; k<K;k++) {
			//afficheTour(tab);
			int[] score = new int[len/2];
			for (int i= 0; i<len/2;i++) {
				score[i] = vainqueurMatch(tab[2*i],tab[2*i+1]);	
			}
			
			tab = tourSuivant(tab, score);
			retour[k] = score;
			len = len/2;
		}
		
		return retour;
		
	}

}



