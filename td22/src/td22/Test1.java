package td22;

public class Test1 {
	  public static void main(String[] args) {
		    int[] t = new int[] { 1, 8, 4, 5, 2, 7, 3, 6 };
		    Tournoi.afficheTour(t);
		    t = new int[] {}; // un tableau vide
		    Tournoi.afficheTour(t);
		    t = new int[] { 3, 8, 13, 10, 2, 11, 15, 1, 5, 6, 16, 4, 7, 9, 12, 14 };
		    Tournoi.afficheTour(t);
	  }
	}