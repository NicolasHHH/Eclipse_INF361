import tc.TC;

public class Test4 {
  public static void main(String[] args) {
    TC.lectureDansFichier("inputa.txt");
    TC.ecritureDansNouveauFichier("outputa4.txt");
    Kovix4.traiter();
    TC.lectureDansFichier("inputb.txt");
    TC.ecritureDansNouveauFichier("outputb4.txt");
    Kovix4.traiter();
  }
}
