public class TIP implements ArgentPhysique {
	public final String destinataire;
	public final int montant;
	public final String signature;
	public final Monnaie monnaie;
	
	public TIP(String destinataire, Argent a, String signature){
		this.destinataire = destinataire;
		this.montant = a.valeurEntiere()*100+a.valeurDecimale();
		this.monnaie = a.getMonnaie();
		this.signature = signature;
	}
	
	public Argent montant(){
		return new Argent(montant, monnaie);
	}
	
	public String toString( ) {
		int valeurDecimale = (int)(this.montant%100);
		long valeurEntiere = this.montant/100;
		String res =  "TIP de " + valeurEntiere + " " + monnaie.nom + (valeurEntiere > 1 ? "s" : "") + " et ";
		res += valeurDecimale + " ";
		if(this.monnaie.nom.equals("Euro")){
			res += "centime" + (valeurDecimale > 1 ? "s de " : " de ");
		}
		else if(this.monnaie.nom.equals("Livre")){
			res += (valeurDecimale > 1 ? "pence de " : "penny de ");
		}
		else if(this.monnaie.nom.equals("Dollar")){
			res +=  "cent" + (valeurDecimale > 1 ? "s de " : " de ");
		}
		else if(this.monnaie.nom.equals("Rouble")){
			res += "kopeck" + (valeurDecimale > 1 ? "s de " : " de ");
		}
		else if(this.monnaie.nom.equals("Yuan")){
			res += "fen" + (valeurDecimale > 1 ? "s de " : " de ");
		}
		else{
			res += "centime" + (valeurDecimale >1 ? "s" : "") + " de ";
		}
		res += this.signature + " a destination de la compagnie " + this.destinataire;
		return res;
	}

}
