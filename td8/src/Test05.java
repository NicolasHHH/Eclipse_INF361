import tc.TC;

public class Test05 {
    public static void main(String[] args) {
        CollectionCandidats e = new ListeCandidats();
        CandidatComparator cmp = new CandidatComparatorNom();
        // CollectionCandidats e = new LinkedListCandidats();
        e.ajouterFichierEnQueue("candidatsCentreValDeLoire.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres ajout de candidats");
        e.desistementFichier("desistements.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres desistement de candidats");
        TC.println("Il reste " + e.nombreCandidats() + " candidats");
        TC.ecritureDansNouveauFichier("output05.txt");
        e.afficher();
    }

}
