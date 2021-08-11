import tc.TC;
public class Test5a {
  public static void main(String[] args){
    int[] t={1,2};
    Tournoi.afficheTour(t);
    int[] t1=Tournoi.tourPrecedent(t);
    Tournoi.afficheTour(t1);
    int[] t2=Tournoi.tourPrecedent(t1);
    Tournoi.afficheTour(t2);
    int[] t3=Tournoi.tourPrecedent(t2);
    Tournoi.afficheTour(t3);
    int i = 2;
    int n = 8;
    TC.println("L'adversaire du joueur " + i+ " est le joueur " + Tournoi.adversaire(i, n) + " quand il y a "+ 2*n +" adversaires.");
    i = 15;
    TC.println("L'adversaire du joueur " + i+ " est le joueur " + Tournoi.adversaire(i, n) + " quand il y a "+ 2*n +" adversaires.");
    n = 16;
    TC.println("L'adversaire du joueur " + i+ " est le joueur " + Tournoi.adversaire(i, n) + " quand il y a "+ 2*n +" adversaires.");
  }
}