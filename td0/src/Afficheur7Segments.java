import java.awt.Color;

import maclib.GrafPort;
import maclib.Point;
import maclib.Rect;

public class Afficheur7Segments {
  // NE PAS MODIFIER cette classe

  static final int MARGIN = 20; // marge autour des segments
  static final int HALF_WITDH = 10; // demi-largeur d'un segment
  static final int SEGMENT_LENGH = 70; // longueur d'un segment

  static int num = 0; // nombre d'afficheurs construits

  /**
   * Construit un afficheur. Cette fonction initialise le graphique.
   * 
   * @return le GrafPort dans lequel on pourra dessiner l'afficheur.
   */
  public static GrafPort construireAfficheur() {
    // on construit un cadre de dessin
    GrafPort g = new GrafPort("" + num);
    int width = 2 * MARGIN + SEGMENT_LENGH;
    int height = 2 * MARGIN + 2 * SEGMENT_LENGH;
    int h_decoration = 15;
    int v_decoration = 35;
    Rect r = new Rect(0, 0, width, height);
    g.setDrawingRect(r.offsetRect(10 + (width + h_decoration) * (num % 8), 10
        + (height + v_decoration) * (num / 8)));
    ++num;
    g.backColor(Color.BLACK);
    g.eraseRect(new Rect(0, 0, 200, 300)); // fond en noir
    return g;
  }

  // Definition de la geometrie des segments de l'afficheur :

  static final Point TOP_LEFT = new Point(MARGIN, MARGIN);
  static final Point TOP_RIGHT = new Point(MARGIN + SEGMENT_LENGH, MARGIN);
  static final Point MID_RIGHT = new Point(MARGIN + SEGMENT_LENGH, MARGIN
      + SEGMENT_LENGH);
  static final Point BOT_RIGHT = new Point(MARGIN + SEGMENT_LENGH, MARGIN + 2
      * SEGMENT_LENGH);
  static final Point BOT_LEFT = new Point(MARGIN, MARGIN + 2 * SEGMENT_LENGH);
  static final Point MID_LEFT = new Point(MARGIN, MARGIN + SEGMENT_LENGH);

  /**
   * Construit un point voisin en diagonale du point argument.
   * 
   * @param p
   *          point de reference
   * @return le nouveau point
   */
  static final Point NW(Point p) {
    return new Point(p.h - HALF_WITDH, p.v - HALF_WITDH);
  }

  static final Point SW(Point p) {
    return new Point(p.h - HALF_WITDH, p.v + HALF_WITDH);
  }

  static final Point NE(Point p) {
    return new Point(p.h + HALF_WITDH, p.v - HALF_WITDH);
  }

  static final Point SE(Point p) {
    return new Point(p.h + HALF_WITDH, p.v + HALF_WITDH);
  }

  static Point[][] segments = new Point[][] {
      new Point[] { TOP_LEFT, NE(TOP_LEFT), NW(TOP_RIGHT), TOP_RIGHT,
          SW(TOP_RIGHT), SE(TOP_LEFT), TOP_LEFT },
      new Point[] { TOP_RIGHT, SE(TOP_RIGHT), NE(MID_RIGHT), MID_RIGHT,
          NW(MID_RIGHT), SW(TOP_RIGHT), TOP_RIGHT },
      new Point[] { MID_RIGHT, SE(MID_RIGHT), NE(BOT_RIGHT), BOT_RIGHT,
          NW(BOT_RIGHT), SW(MID_RIGHT), MID_RIGHT },
      new Point[] { BOT_RIGHT, SW(BOT_RIGHT), SE(BOT_LEFT), BOT_LEFT,
          NE(BOT_LEFT), NW(BOT_RIGHT), BOT_RIGHT },
      new Point[] { BOT_LEFT, NW(BOT_LEFT), SW(MID_LEFT), MID_LEFT,
          SE(MID_LEFT), NE(BOT_LEFT), BOT_LEFT },
      new Point[] { MID_LEFT, NW(MID_LEFT), SW(TOP_LEFT), TOP_LEFT,
          SE(TOP_LEFT), NE(MID_LEFT), MID_LEFT },
      new Point[] { MID_LEFT, NE(MID_LEFT), NW(MID_RIGHT), MID_RIGHT,
          SW(MID_RIGHT), SE(MID_LEFT), MID_LEFT }, };

  static final int NOMBRE_SEGMENTS = segments.length;

  /**
   * Dessine un segment avec numero a l'interieur.
   * 
   * @param i
   *          le numero du segment
   * @param g
   *          le GrafPort dans lequel on dessine l'afficheur
   */
  public static void dessinerSegment(int i, GrafPort g) {
    g.foreColor(Color.WHITE);
    g.paintPolygon(segments[i], segments[i].length);
    g.foreColor(Color.BLACK);
    g.moveTo((segments[i][0].h + segments[i][3].h) / 2 - 2,
        (segments[i][0].v + segments[i][3].v) / 2 + 4);
    g.drawString("" + i);
  }

  /**
   * Allume un segment (peint en vert).
   * 
   * @param i
   *          le numero du segment
   * @param g
   *          le GrafPort dans lequel on dessine l'afficheur
   */
  public static void allumerSegment(int i, GrafPort g) {
    g.foreColor(Color.GREEN);
    g.paintPolygon(segments[i], segments[i].length);
  }

  /**
   * Eteint un segment (peint en noir).
   * 
   * @param i
   *          le numero du segment
   * @param g
   *          le GrafPort dans lequel on dessine l'afficheur
   */
  public static void eteindreSegment(int i, GrafPort g) {
    g.foreColor(Color.BLACK);
    g.paintPolygon(segments[i], segments[i].length);
  }

}