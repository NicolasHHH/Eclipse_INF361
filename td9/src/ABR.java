import tc.TC;

public class ABR {
  private Noeud racine;

  // construit un arbre vide
  public ABR() {
    this.racine = null;
  }

  // construit un arbre avec cette racine (pour les tests seulement)
  public ABR(Noeud _racine) {
    this.racine = _racine;
  }

  // construit un ABR équilibré à partir d'une liste d'entrées
  // que l'on suppose triée.
  public ABR(ListeEntrees liste) {
    Entree[] entrees = liste.toArray();
    int n = entrees.length;
    if (n == 0) // arbre vide
      racine = null;
    else // arbre non vide
      this.racine = Noeud.indexerTableauTrie(entrees, 0, n - 1);
  }

  public String toString() {
    return "Index de : " + racine;
  }

  public void dessiner() {
    new Fenetre(this.racine);
  }

  // Ajouter toutes les occurrences de mots d'un texte.
  // La lecture se fait via la classe TC qui ignore la ponctuation.
  public void indexerTexte() {
    int nligne = 1;
    while (!TC.finEntree()) {
      for (String mot : TC.lireLigne().split("[ .,:;!?()\\[\\]\"]+"))
        ajouterOccurrence(mot, nligne);
      nligne++;
    }
  }

  // Les méthodes ci-dessus sont données, vous ne devez pas les modifier.

  // Exercice 1

  public int hauteur() {
	  if (this.racine == null)
		  return 0;
	  return racine.hauteur();
  }

  // Exercice 2

  public ListeEntiers chercher(String w) {
	  if (this.racine == null)
		  return new ListeEntiers();
	  else return this.racine.chercher(w);
  }

  // Exercice 3

  public boolean estValide() {
	  if (this.racine ==  null)
		  return true;
	  else return this.racine.estValide(null, null);
	  
  }

  // Exercice 4

  public void ajouterOccurrence(String w, int n) {
    // ajouter l'occurence du w à la ligne n
	// si déjà dedans, on fait rien 
	  if (this.racine == null) {
		  this.racine = new Noeud(new Entree(w,n));
	  }
	  else {
		  this.racine.ajouterOccurrence(w, n);
	  }
  }

  // Exercice 5

  public void imprimer(String nom) {
    // La ligne qui suit indique dans quel fichier écrire.
    TC.ecritureDansNouveauFichier(nom + ".index");
    //
    // completer ici
    if (this.racine!=null) {
    	this.racine.imprimer();
    }
    //
    // Une fois les écritures dans le fichier terminées,
    // on revient à la sortie standard, c'est-à-dire l'écran.
    TC.ecritureSortieStandard();
  }

  // Exercice 6

  public ListeEntrees liste() {
	  // renvoie la liste ordonnée(croissante) des noeudsde l'ABR.
	  if (this.racine==null)
		  return new ListeEntrees();
	  else return this.racine.liste();
  }
}
