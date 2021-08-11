import tc.TC;

public class Candidat {

    public enum Genre { M, F };

    private final String nom;
    private final String prenom;
    private final Genre genre;
    private final String region;
    public final int note;

    public Candidat(String nom, String prenom, Genre g, String region, int note) {
        this.nom = nom;
        this.prenom = prenom;
                this.genre = g;
                this.region = region;
        this.note = note;
    }

    /**
     * Crée un candidat à partir d'une chaîne de la forme "nom prénom genre note"
     * et évalué dans la region donnée.
         * @param region la région du candidat.
     * @param ligne
     *            la chaîne à analyser. On suppose qu'elle est de la forme
     *            indiquée ci-dessus
     */
    public Candidat(String region, String ligne) {
        String[] mots = TC.motsDeChaine(ligne);
        this.nom = mots[0];
        this.prenom = mots[1];
                if (mots[2].equals("M")) {
                    this.genre = Genre.M;
                } else {
                    this.genre = Genre.F;
                }
                this.region = region;
        this.note = Integer.parseInt(mots[3]);
    }

    public String toString() {
        return (this.nom + " " + this.prenom + " " + this.genre + " " +this.note);
    }

    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public Genre getGenre() { return this.genre; }
    public String getRegion() { return this.region; }

}
