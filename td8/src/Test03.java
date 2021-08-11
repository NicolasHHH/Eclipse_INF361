import tc.TC;

public class Test03 {
    public static void main(String[] args) {
        CollectionCandidats e = new ListeCandidats();
        // CollectionCandidats e = new LinkedListCandidats();
        e.ajouterFichierEnQueue("candidatsBourgogneFrancheComte.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: apres ajout des candidats, la liste n'est pas correcte");
        TC.ecritureDansNouveauFichier("output03.txt");
        TC.println("Bourgogne-Franche-Comte");
        e.afficher();
    }

}
