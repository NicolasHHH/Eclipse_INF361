import tc.TC;
import java.util.ListIterator;
import java.util.LinkedList;

public class LinkedListCandidats implements CollectionCandidats {
    private final LinkedList<Candidat> candidats;

    public LinkedListCandidats() {
        this.candidats = new LinkedList<Candidat>();
    }

    public boolean estVide() {
        return candidats.isEmpty();
    }

    public void afficher() {
        if (this.candidats.isEmpty())
            TC.println("<liste vide>");
        else {
                  for (Candidat c : this.candidats)
                    TC.println(c);
                }
    }

    public void ajouterEnTete(Candidat c) {
        this.candidats.addFirst(c);
    }

    public boolean estCorrecte() {
        return true;
    }

    public void ajouterEnQueue(Candidat c) {
    }

    public int nombreCandidats() {
        return 0;
    }

    public void ajouterFichierEnQueue(String nomFichier) {
    }

    public void desistement(Candidat c, CandidatComparator cmp) {
    }

    public void desistementFichier(String nomFichier) {
        CandidatComparator cmp = new CandidatComparatorNom ();
    }

    public void selection(CandidatComparator cmp) {
    }

    public void ajouterFichierTrie(String nomFichier) {
        CandidatComparator cmp = new CandidatComparatorNom();
    }

}
