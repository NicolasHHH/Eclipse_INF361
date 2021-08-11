import tc.TC;

public class Test06b {
    public static void main(String[] args) {
        CollectionCandidats e = new ListeCandidats();
        //CollectionCandidats e = new LinkedListCandidats();
        CandidatComparator cmp = new CandidatComparatorNote();
        e.ajouterFichierEnQueue("candidatsNormandie.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres ajout de candidats");
        e.selection(cmp);
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres selection");
        TC.println("Il reste " + e.nombreCandidats() + " candidats");
        TC.ecritureDansNouveauFichier("output06b.txt");
        e.afficher();
    }

}
