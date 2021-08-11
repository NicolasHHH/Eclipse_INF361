import tc.TC;

public class Test07b {
    public static void main(String[] args) {
        CollectionCandidats e = new ListeCandidats();
        //CollectionCandidats e = new LinkedListCandidats();
        CandidatComparator cmp = new CandidatComparatorNote();
        e.ajouterFichierTrie("candidatsAuvergneRhoneAlpes.txt");
        e.ajouterFichierTrie("candidatsBourgogneFrancheComte.txt");
        e.ajouterFichierTrie("candidatsBretagne.txt");
        e.ajouterFichierTrie("candidatsCentreValDeLoire.txt");
        e.ajouterFichierTrie("candidatsCorse.txt");
        e.ajouterFichierTrie("candidatsGrandEst.txt");
        e.ajouterFichierTrie("candidatsHautsDeFrance.txt");
        e.ajouterFichierTrie("candidatsIleDeFrance.txt");
        e.ajouterFichierTrie("candidatsNormandie.txt");
        e.ajouterFichierTrie("candidatsNouvelleAquitaine.txt");
        e.ajouterFichierTrie("candidatsOccitanie.txt");
        e.ajouterFichierTrie("candidatsPaysDeLaLoire.txt");
        e.ajouterFichierTrie("candidatsProvenceAlpesCoteDAzur.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres ajout de tous les fichiers");
        e.desistementFichier("desistements.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres desistements");
        e.selection(cmp);
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres selection");
        TC.println("Il reste " + e.nombreCandidats() + " candidat(s)");
        e.afficher();
    }

}
