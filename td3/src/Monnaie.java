
public class Monnaie {
	public final String nom;
	private double taux;
	
	public Monnaie(String n,double t) {
		this.nom = n;
		this.taux = t;
	}
	public double getTaux() {
		return this.taux;
	}
	
	public void setTaux(double autreTaux) {
		this.taux = autreTaux;

	}
	 public boolean estEgalA(Monnaie m) {
		 if (m!=null) {
			 if (m.taux == this.taux && this.nom.equals(m.nom)) {
				 return true;
			 }
		 }
		 return false;
		 
	 }
	 public String pluriel() { 
		    return this.nom+"s"; 
	}
	 public static Monnaie trouverMonnaie(String s, Monnaie[] tab) {
		 for (Monnaie money:tab) {
			 if (s.equals(money.nom))
				 return  money;
			 if (s.equals(money.nom+"s"))
				 return money;
		 }
		 return null;
		 
	 }
	
}
