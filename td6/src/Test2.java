import tc.TC;
public class Test2 {
  public static void main(String[] args) {
    TC.lectureDansFichier("inputa.txt");
    TC.ecritureDansNouveauFichier("outputa2.txt");
    Kovix2.traiter();
    TC.lectureDansFichier("inputb.txt");
    TC.ecritureDansNouveauFichier("outputb2.txt");
    Kovix2.traiter();
  }
}
