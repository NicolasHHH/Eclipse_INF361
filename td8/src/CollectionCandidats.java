public interface CollectionCandidats {

    /*
     * retourne le nombre de candidats contenus dans l'objet courant.
     */
    public int nombreCandidats();

    /*
     * retourne true si et seulement si l'objet courant est vide
     */
    public boolean estVide();

    /*
     * retourne true si et seulement si l'objet courant est dans un etat correct
     */
    public boolean estCorrecte();
    
    /*
     * ajoute un candidat au debut de l'objet courant
     */
    public void ajouterEnTete(Candidat c);

    /*
     * ajoute un candidat a la fin de l'objet courant
     */
    public void ajouterEnQueue(Candidat c);

    /*
     * affiche sur la sortie courante chacun des candidats contenus dans l'objet
     * courant, dans l'ordre dans lequel ils se presentent.
     */
    public void afficher();

    /*
     * retire un candidat de l'objet courant s'il y est present (c'est à dire
     * si un maillon comporte un candidat equivalent au sens de cmp),
     * Sinon, l'objet courant reste inchange.
     */
    public void desistement(Candidat c, CandidatComparator cmp);

    /*
     * retire tous les candidats mentionnes dans le fichier nomFichier de
     * l'objet courant. Si certains candidats ne sont pas presents dans l'objet
     * courant, ils sont simplement ignores.
     */
    public void desistementFichier(String nomFichier);

    /*
     * ne garde que les candidats les meilleurs (au sens de cmp)
         * parmi ceux presents dans l'objet courant.
     */
    public void selection(CandidatComparator cmp);

    /*
     * ajoute tous les candidats mentionnes dans nomFichier a la fin de l'objet
     * courant.
     */
    public void ajouterFichierEnQueue(String nomFichier);

    /*
     * En supposant que les candidats deja presents sont tries par ordre
     * alphabetique nom+prenom, et que c'est aussi le cas pour ceux mentionnes
     * dans nomFichier, insere ces derniers en respectant ledit ordre
     * alphabetique.
     */
    public void ajouterFichierTrie(String nomFichier);
}
