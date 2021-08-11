import tc.TC;

public class ListeCandidats implements CollectionCandidats {

    private Maillon tete;
    private Maillon queue;

    public ListeCandidats() {
        this.tete = null;
        this.queue = null;
    }

    public void afficher() {
        if (this.tete == null) TC.println("<liste vide>");
        else Maillon.afficher(this.tete);
    }

    public boolean estVide() {
        return this.tete == null && this.queue == null;
    }

    public void ajouterEnTete(Candidat c) {
        Maillon m = new Maillon(c,this.tete);
        this.tete = m;
        if (this.queue == null)
            /* on a ajoute un candidat a la liste vide: il est
             * a la fois le premier et le dernier.
             */
            this.queue = m;
    }

    // Les methodes ci-dessous sont a completer au cours des exercices du TP

    public int nombreCandidats() {
    	if (estVide()) 
    		return 0;
    	else 
    		return Maillon.longueur(this.tete);
    }

    public boolean estCorrecte() {
    	if (estVide())
    		return true;
    	if (this.tete != null && Maillon.dernier(this.tete) == this.queue) {
    		return true;
    	}
    	else 
    		return false;
    }

    public void ajouterEnQueue(Candidat c) {
    	if (this.queue==null) {
    		this.tete = this.queue = new Maillon(c);
    	}
    	else {
        	this.queue = this.queue.ajouterApres(c);
    	}
    }

    public void ajouterFichierEnQueue(String nomFichier) {
    		TC.lectureDansFichier(nomFichier);
    		String region =TC.lireLigne();
    		while(TC.finEntree()==false) {
    			String str = TC.lireLigne(); 
    			ajouterEnQueue(new Candidat(region,str));

    		}
    		TC.println("Candidats de la region "+region+ " ajoutes. Il y a maintenant "+Maillon.longueur(tete)+" candidats");
    }

    public void enleverSuivant(Maillon precedent) {
    	if (precedent == null) {
    		this.tete = this.tete.suivant();
    		if (this.tete == null) {
    			this.queue = null;
    		}
    	}
    	else if (precedent !=this.queue) {
    		Maillon.enleverSuivant(precedent);
    		if (precedent.suivant()==null) {
    			this.queue = precedent;
    		}
    	}
    }

    public void desistement(Candidat c, CandidatComparator cmp) {
    	if (this.tete != null) {
    		Maillon M = this.tete;
    		if ( cmp.compare(c, M.contenu) == 0 ) 
        		enleverSuivant(null);
        	else {
    			Maillon K = M.suivant();
        		while(K != null) {
        			if ( cmp.compare(c, K.contenu) == 0 ) {
        				enleverSuivant(M);
        				break;
        			}
        			else {
        				M = K;
        				K = M.suivant();
        			}
        		}
        	}
    	}
    }

    public void desistementFichier(String nomFichier) {
        CandidatComparator cmp = new CandidatComparatorNom();
        TC.lectureDansFichier(nomFichier);
		while(TC.finEntree()==false) {
			String str = TC.lireLigne()+" 0"; 
			desistement(new Candidat("",str),cmp);
		}
    
    }

    public void selection(CandidatComparator cmp) {
    	if (estVide()==false) {
    		Maillon M = this.tete;
        	Maillon K = M.suivant();
        	//int count = 0;
        	
    		while(K != null) {
    			int res_comp = cmp.compare(this.tete.contenu,K.contenu);
    			if (res_comp > 0) {
    				Maillon.enleverSuivant(M);
    				this.queue = M;
    			}
    			else if ( res_comp < 0 ) {
    				this.tete = K;
    				M = this.tete;
    			}
    			else {
    				M = K;
    				//count++;
    			}
    			K = K.suivant();
    			if( K != null) {
    				this.queue = K;
    			}
    			
    			//count ++;
        	}
    		//TC.print(count);
    	}
		
    }

    public void ajouterFichierTrie(String nomFichier) {
        CandidatComparator cmp = new CandidatComparatorNom();
        TC.lectureDansFichier(nomFichier);
		String region =TC.lireLigne();
		
		if (estVide()) {
			while(TC.finEntree()==false) {
				
    			String str = TC.lireLigne(); 
    			ajouterEnQueue(new Candidat(region,str)); ///
    			
    		}
		}
		else if( TC.finEntree()==false ){
			
			String str = TC.lireLigne(); 
			Candidat New = new Candidat(region,str); ///
			
			Maillon P = this.tete;
			Maillon Next =P.suivant();
			int res_comp = cmp.compare(this.tete.contenu,New);
			if (res_comp > 0) {
				ajouterEnTete(New);
				P = this.tete;
				Next =P.suivant(); 
			}
			else {
				while (Next != null) {
					res_comp = cmp.compare(Next.contenu,New);
					if (res_comp > 0) {
						P.ajouterApres(New);
						P = P.suivant();
						break;
					}
					else {
						P = Next;
						Next = Next.suivant();
					}
				}
			}
			
			while (TC.finEntree()==false) {
				str = TC.lireLigne(); 
				New = new Candidat(region,str);//
				while ( Next != null) {
					res_comp = cmp.compare(Next.contenu,New);
					if (res_comp > 0) {
						P.ajouterApres(New);
						P = P.suivant();
						break;
					}
					else {
						P = Next;
						Next = Next.suivant();
					}
				}
				if (Next == null) {
	    			ajouterEnQueue(New);
				}
			}
		}
		TC.println("Candidats de la region "+region+ " ajoutes. Il y a maintenant "+Maillon.longueur(tete)+" candidats");
        
        
    }

}
