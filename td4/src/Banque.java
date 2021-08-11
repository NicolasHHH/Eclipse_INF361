
import tc.TC;
public class Banque {
	public static final int TAILLE_INITIALE = 10;
	public final String nom;
	private Compte[] comptes; // Longueur taille ini
	private int nombreDeComptes;
	
	public Banque(String nom) {
		this.nom = nom;
		this.comptes = new Compte[TAILLE_INITIALE];
		this.nombreDeComptes = 0;
	}
	public int getNombreDeComptes(){
		return this.nombreDeComptes;
	}
	public String toString() {
		return "BANQUE "+ this.nom;
	}
	
	public void afficher(){
	    TC.println(nom);
	    TC.println(this.nombreDeComptes);
	    for (int i=0; i < this.nombreDeComptes;++i){
	        TC.println(comptes[i]);
	    }   
	}
	public Compte trouverCompte(long numero) {
		for (Compte c : comptes) {
			if (c!= null && c.numero  ==  numero) {
				return c;
			}
		}
		return null;
	}
	public boolean ajouterCompte(Compte c) {
		if ( c!= null) {
			if(trouverCompte(c.numero)== null ) {
				if (this.nombreDeComptes<this.comptes.length){
					this.comptes[this.nombreDeComptes++] = c;
					return true;
				}
				else if(this.nombreDeComptes==this.comptes.length) {
					Compte[] Double = new Compte[2*this.nombreDeComptes];
					int i = 0;
					for (Compte com : this.comptes) {
						Double[i++] = com;
					}
					Double[this.nombreDeComptes++] = c;
					this.comptes = Double;
					return true;
				}
			}
		}
		return false;
		
	}
	public boolean deposer(long numero, Argent argent) {
		Compte c = trouverCompte(numero) ;
		if (c != null){
			c.deposer(argent);
			return true;
		}
		return false;
	}
	public boolean deposer(long numero, ArgentPhysique agp) {
		return deposer(numero,agp.montant());
	}
	
	/***
	public boolean deposer(long numero, Liquide liq) {
		return deposer(numero,liq.montant());
	}
	
	public boolean deposer(long numero, Cheque ch) {
		return deposer(numero,ch.montant());
		
	}
	public boolean deposer(long numero, TIP t) {
		return deposer(numero,t.montant());
	}
	**/
	
	
	
	public Liquide retirer(long numero, Argent a){
		if (prelever(numero,a, true)) return new Liquide(a);
		else return null;
	}
	
	public boolean prelever(long numero, Argent argent, boolean avecPlafond){
		Compte c = trouverCompte(numero) ;
		if (c != null){
			return c.prelever(argent,avecPlafond);
		}
		return false;
	}
	
	
	
}
