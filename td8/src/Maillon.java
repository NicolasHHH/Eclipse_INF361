import tc.TC;

public class Maillon {
    public final Candidat contenu;
    private Maillon suivant;

    public Maillon(Candidat c) {
        this.contenu = c;
        this.suivant = null;
    }

    public Maillon(Candidat c, Maillon reste) {
        this.contenu = c;
        this.suivant = reste;
    }

    public static void afficher(Maillon m) {
        Maillon courant = m;
        while (courant != null) {
            TC.println(courant.contenu);
            courant = courant.suivant;
        }
    }

    public Maillon suivant() {
        return this.suivant;
    }

    // Les methodes ci-dessous sont a completer au cours des exercices du TP

    public static int longueur(Maillon m) {
    	int len = 0;
    	if (m == null) return 0;
    	else {
    		len = 1;
    		while (m.suivant != null) {
        		m = m.suivant;
        		len ++;
        	}
    		return len;
    	}
    }

    public static Maillon dernier(Maillon m) {
    	if (m ==  null)
    		return null;
    	if (m.suivant == null) {
    		return m;
    	}
    	else return dernier(m.suivant);
    }

    public Maillon ajouterApres(Candidat c) {
    	Maillon Apres = new Maillon(c);
    	
    	if (this.suivant == null) {
    		this.suivant = Apres;
    	}
    	else {
    		Maillon suite = this.suivant;
    		Apres.suivant = suite;
        	this.suivant = Apres;
    	}
        return Apres;
    }

    public static void enleverSuivant(Maillon m) {
    	if (m != null && m.suivant != null) {
    		Maillon suite = m.suivant.suivant;
        	m.suivant = suite;
    	}
    }

}
