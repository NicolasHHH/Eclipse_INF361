public class Test4a {
  public static void main(String[] args){
    int[] tab={29,6,13,8,22,18,12,14,7,2,9,3,21,26,4,31,30,23,16,1,10,17,27,5,25,20,24,28,15,32,11,19};
    int[] res={2,2,2,2,1,2,2,1,2,1,2,2,1,2,1,2};
    int[] suiv=Tournoi.tourSuivant(tab,res);
    Tournoi.afficheTour(suiv);
}
}