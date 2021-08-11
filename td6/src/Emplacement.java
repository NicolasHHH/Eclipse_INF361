public class Emplacement {
  public final String nom;
  public final Position position;

  public Emplacement(String pnom, int platitude, int plongitude) {
    this.nom = pnom;
    this.position = new Position(platitude, plongitude);
  }

  @Override
  public String toString() {
    return this.nom + " en " + this.position;
  }

}
