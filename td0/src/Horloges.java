import maclib.GrafPort;

public class Horloges {

  /**
   * Fait le dessin des trois aiguilles.
   * 
   * A COMPLETER. Vous devez ajouter le calcul de la position angulaire de
   * chaque aiguille.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine,
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit afficher
   */
  public static void tracerAiguilles(GrafPort g, int secondes) {
    // pour l'aiguille des heures
    DessinHorloge.tracerHeures(g, secondes/3600.0/12.0);
    // pour l'aiguille des minutes
    secondes = secondes % 3600;
    DessinHorloge.tracerMinutes(g, secondes/60.0/60.0);
    secondes = secondes % 60;
    // et pour l'aiguille des secondes
    DessinHorloge.tracerSecondes(g, secondes/60.0);
  }

  /**
   * Affiche le dessin d'une horloge, NE PAS MODIFIER. Cette fonction initialise
   * le graphique par DessinHorloge.construireCadran et appelle les fonctions
   * DessinHorloge.affichageDigital et tracerAiguilles.
   * 
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit afficher
   */
  public static void afficherHorloge(int secondes) {
    // on construit un cadre de dessin
    GrafPort g = DessinHorloge.construireCadran();
    // pour l'affichage digital
    DessinHorloge.affichageDigital(g, secondes);
    // pour tracer les aiguilles
    tracerAiguilles(g, secondes);
  }

  public static void main(String[] args) {
    afficherHorloge(2000);
    afficherHorloge(40000);
    afficherHorloge(56000);
  }

}