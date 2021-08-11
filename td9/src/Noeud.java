import tc.TC;

public class Noeud {

  private final Entree contenu;
  public Noeud gauche;
  public Noeud droit;

  public Noeud(Entree e) {
    this.gauche = null;
    this.droit = null;
    this.contenu = e;
  }

  public Noeud(Noeud g, Noeud d, Entree e) {
    this.gauche = g;
    this.droit = d;
    this.contenu = e;
  }

  public Entree contenu() {
    return this.contenu;
  }

  public String toString() {
    String str = "";
    if (this.gauche != null)
      str += "(" + this.gauche + ")";
    else
      str += "*";
    str += " <- " + this.contenu + " -> ";
    if (this.droit != null)
      str += "(" + this.droit + ")";
    else
      str += "*";
    return str;
  }

  // Les methodes ci-dessus sont données, vous ne devez pas les modifier.

  // Exercice 1
  public int hauteur() {
	  int hl;
	  int hr;
	  if (this.gauche==null) {
		  hl=0;
	  }
	  else {
		  hl = this.gauche.hauteur();
	  }
	  
	  if (this.droit==null) {
		  hr=0;
	  }
	  else {
		  hr = this.droit.hauteur();
	  }
	  
	  if (hl < hr) {
		  return 1+hr;
	   }
		  else return 1+hl;
  }

  // Exercice 2
  public ListeEntiers chercher(String w) {
	  int res = this.contenu.comparer(w);
	  if (res == 0) {
		  return this.contenu.occurrences;
	  }
	  else if (res > 0) {
		  // w plus petit que contenu;
		  if (this.gauche != null) {
			  return this.gauche.chercher(w);
		  }
		  return new ListeEntiers();
	  }
	  else  {
		  if (this.droit != null)
			  return this.droit.chercher(w);
		  return new ListeEntiers();
	  }
  }

  // Exercice 3
  public boolean estValide(String min, String max) {
	  boolean g = false;
	  boolean d =false;
	  if (min != null) {
		  if( this.contenu.comparer(min)<=0 )
			 return false;
	  }
	  if (max != null) {
		  if ( this.contenu.comparer(max)>=0 )
			  return false;
	  }
	  if (this.gauche!=null) {
		  g = this.gauche.estValide(min,this.contenu.mot); 
	  }
	  else g = true;
	  if (this.droit!=null) {
		  d = this.droit.estValide(this.contenu.mot,max) ;
	  }
	  else d = true;
	  return g&&d; 
	
	  				
  }

  // Exercice 4
  public void ajouterOccurrence(String w, int n) {
	  int cmp = this.contenu.comparer(w);
	  if (cmp==0){
		  // w est bien le contenu courant 
		  this.contenu.occurrences.ajouterEnQueue(n);
	  }
	  else if (cmp>0) {
		  // le mot est < contenu courant
		  if (this.gauche != null)
			  this.gauche.ajouterOccurrence(w, n);
		  else 
			  this.gauche = new Noeud(new Entree(w,n));
	  }
	  else {
		// le mot est < contenu courant
		  if (this.droit != null)
			  this.droit.ajouterOccurrence(w, n);
		  else 
			  this.droit = new Noeud(new Entree(w,n));
	  }
	  
  }

  // Exercice 5
  public void imprimer() {
	  if (this.gauche != null) {
		  this.gauche.imprimer();
	  }
	  TC.println(this.contenu.toString());
	  if (this.droit != null) {
		  this.droit.imprimer();
	  }
  }

  // Exercice 6
  public ListeEntrees liste() {
	  ListeEntrees list = new ListeEntrees();
	  if (this.gauche != null) {
		  list.concatener(this.gauche.liste());
	  }
	  list.ajouterEnQueue(this.contenu);
	  if (this.droit != null) {
		  list.concatener(this.droit.liste());
	  }
	  return list;
  }

  // Exercice 7
  public static Noeud indexerTableauTrie(Entree[] entrees, int min, int max) {
	  if (min > max) return null;
	  int middle = (min + max)/2;
	  Noeud racine  = new Noeud(entrees[middle]);
	  racine.gauche = indexerTableauTrie(entrees, min, middle-1);
	  racine.droit = indexerTableauTrie(entrees, middle+1, max);
	  return racine;
	  
  }
  
  // commentaires :
  /*
   * On constate que la hauteur de l'arbre est égale au nombre de lignes du texte. 
   * Cela est du au fait que : 
   * 1. les lignes dans le text sont dans l'ordre alphabétique 
   * 2. le comparateur utilisé compare dans aussi dans l'ordre alphabétique
   * Par conséquent, chaque nouveau noeud qui contient l'info sur une nouvelle ligne est ajouté toujours à la feuille droit de l'arbre
   * puisqu'il est supérieurs aux tous les noeuds présents dans l'arbre. 
   * Ainsi, il nécessite un temps linéaire pour exploiter l'arbre comme on parcourt une liste. 
   */
  
  
  /* 
   * hauteur de english_short : 11
   * hauteur : 4
   * hauteur de english : 848
   * hauteur : 10
   * avant la conversion: le complexité est linéaire, i.e. O(n)
   * après la conversion: la complexité est logarithmique, i.e. O(log(n)), car la hauteur maximal de l'arbre est log2(n)
   * la conversion rendre le programme plus efficace lorsque n est grand.
   */

}
