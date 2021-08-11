import java.util.Locale;

public class Entree {
    final String mot;
    final ListeEntiers occurrences;        

    private static final Comparateur COMPARATEUR = new Comparateur(Locale.FRANCE); // pour comparaison des Strings accentués
    
    // Construit une entrée pour le mot w avec, pour l'instant, aucun numéro de ligne.
    public Entree(String w) {
        this.mot = w;
        this.occurrences = new ListeEntiers();
    }
    
    // Construit une entrée pour le mot w avec le numéro de ligne n.
    public Entree(String word, int n) {
        this.mot = word;
        this.occurrences = new ListeEntiers();
        this.occurrences.ajouterEnQueue(n);
    }
    
    public String toString( ) {
        return this.mot + " : " + this.occurrences;
    }
    
    public void ajouter(int n) {
        // Ajouter un numéro de ligne n pour this.mot
        this.occurrences.ajouterEnQueue(n);
    }    
    
    public int comparer(String x) {
        // Comparaison de x avec this.mot (en ignorant majuscule/minuscule):
        // 0 si x == this.mot
        // negative si this.mot < x
        // positive si this.mot > x
        // exemple:
        //   soit E.mot == "banane"
        //   alors E.comparer("Ampoule") > 0
        //         E.comparer("Chat") < 0
        //         E.comparer("bANanE") == 0
    	
      return COMPARATEUR.compare(this.mot, x);
    }
}
