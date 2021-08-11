import tc.TC;

public class Test04 {
    public static void main(String[] args) {
        CollectionCandidats e = new ListeCandidats();
        CandidatComparator cmp = new CandidatComparatorNom();
        // CollectionCandidats e = new LinkedListCandidats();
        e.ajouterFichierEnQueue("candidatsBretagne.txt");
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres ajout de candidats");
        e.desistement(new Candidat("","PANCOLET ALEXANDRE M 0"),cmp);
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres un desistement");
        e.desistement(new Candidat("", "DANCTOVILLE GERALDE F 0"),cmp);
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres deux desistements");
        e.desistement(new Candidat("", "VAUDRUDE SYLVAIN M 0"),cmp);
        if (!e.estCorrecte()) TC.println("ERREUR: liste incorrecte apres trois desistements");
        TC.println("Il reste " + e.nombreCandidats() + " candidats");
        TC.ecritureDansNouveauFichier("output04.txt");
        e.afficher();
    }

}
