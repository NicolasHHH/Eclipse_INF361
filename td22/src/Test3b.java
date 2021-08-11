public class Test3b {
  public static void main(String[] args){
    int[] tab = new int[] {1,2,3};
    System.out.println(Tournoi.estUnePermutation(tab));
    tab=Tournoi.tableauOrdonne(100);
    System.out.println(Tournoi.estUnePermutation(tab));
    Test3a.melangeTableau(tab);
    System.out.println(Tournoi.estUnePermutation(tab));
    tab[5]=0;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab[2]=120;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab=Tournoi.tableauOrdonne(10000);
    System.out.println(Tournoi.estUnePermutation(tab));
    tab[9990]=1234;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab[9991]=-2;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab=Tournoi.tableauOrdonne(1000000);
    System.out.println(Tournoi.estUnePermutation(tab));
    Test3a.melangeTableau(tab);
    System.out.println(Tournoi.estUnePermutation(tab));
  }
}