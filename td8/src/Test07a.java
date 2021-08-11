import tc.TC;

public class Test07a {
    public static void main(String[] args) {
        CollectionCandidats e = new ListeCandidats();
        // CollectionCandidats e = new LinkedListCandidats();
        e.ajouterFichierTrie("candidatsGrandEst.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres ajout fichier 1");
        e.ajouterFichierTrie("candidatsHautsDeFrance.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres ajout fichier 2");
        TC.ecritureDansNouveauFichier("output07a.txt");
        e.afficher();
    }

}
