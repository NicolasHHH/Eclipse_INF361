import java.awt.Color;

import maclib.GrafPort;
import maclib.Rect;

public class DessinHorloge {

  // constantes :
  // localisation du centre de l'horloge (en pixels)
  static final int X = 100;
  static final int Y = 100;
  // rayon du disque correspondant au cadran (en pixels)
  static final int R = 80;

  /**
   * Fait le dessin d'une aiguille, NE PAS MODIFIER.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine.
   * @param position
   *          indique la position de l'aiguille sur le cadran; 0 place
   *          l'aiguille en haut (midi), 0.25 place l'aiguille sur "3 heures",
   *          etc.
   * @param longueur
   *          indique la longueur relative de l'aiguille, par rapport au rayon
   *          du cadran.
   * @param largeur
   *          indique la largeur (en pixels) de l'aiguille.
   * @param color
   *          indique la couleur de l'aiguille.
   */
  public static void tracerAiguille(GrafPort g, double position,
      double longueur, int largeur, Color color) {
    g.penSize(largeur, largeur);
    g.foreColor(color);
    g.moveTo(X, Y);
    position -= 0.25;
    g.lineTo((int) (X + R * longueur * Math.cos(position * 2 * Math.PI)),
        (int) (Y + R * longueur * Math.sin(position * 2 * Math.PI)));
    g.foreColor(Color.BLACK);
  }

  /**
   * Fait le dessin de l'aiguille des heures, NE PAS MODIFIER. Vous devrez
   * utiliser correctement cette fonction.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine.
   * @param position
   *          indique la position de l'aiguille sur le cadran; 0 place
   *          l'aiguille en haut (midi), 0.25 place l'aiguille sur "3 heures",
   *          etc.
   */
  public static void tracerHeures(GrafPort g, double position) {
    tracerAiguille(g, position, 0.5, 4, Color.BLACK);
  }

  /**
   * Fait le dessin de l'aiguille des minutes, NE PAS MODIFIER. Vous devrez
   * utiliser correctement cette fonction.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine.
   * @param position
   *          indique la position de l'aiguille sur le cadran; 0 place
   *          l'aiguille en haut, 0.25 place l'aiguille sur "15 minutes", etc.
   */
  public static void tracerMinutes(GrafPort g, double position) {
    tracerAiguille(g, position, 0.75, 2, Color.BLUE);
  }

  /**
   * Fait le dessin de l'aiguille des secondes, NE PAS MODIFIER. Vous devrez
   * utiliser correctement cette fonction.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine.
   * @param position
   *          indique la position de l'aiguille sur le cadran; 0 place
   *          l'aiguille en haut, 0.25 place l'aiguille sur "15 secondes", etc.
   */
  public static void tracerSecondes(GrafPort g, double position) {
    tracerAiguille(g, position, 0.9, 1, Color.RED);
  }

  /**
   * Affiche l'heure sous forme digitale, NE PAS MODIFIER, utilise
   * Heures.chaineDe.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine.
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit afficher.
   */
  public static void affichageDigital(GrafPort g, int secondes) {
    g.moveTo(10, 190);
    g.drawString(Heures.chaineDe(secondes));
  }

  // compteur du nombre d'horloges (variable globale)
  static int num = 0;

  /**
   * Construit et affiche le cadran d'une horloge, NE PAS MODIFIER. Cette
   * fonction initialise le graphique et dessine le cadran.
   * 
   * @return le GrafPort dans lequel on pourra dessiner le reste.
   */
  public static GrafPort construireCadran() {
    // on construit un cadre de dessin
    ++num;
    GrafPort g = new GrafPort("Horloge " + num);
    // change la position dans l'ecran et garde la dimension initiale
    Rect r = g.getDrawingRect();
    r.offsetRect(250 * (num - 1), 0);
    g.setDrawingRect(r);
    // on peint le cadran
    g.foreColor(Color.LIGHT_GRAY);
    g.paintCircle(X, Y, R);
    g.foreColor(Color.BLACK);
    return g;
  }

}