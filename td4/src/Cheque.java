public class Cheque implements ArgentPhysique{

	public final int montant;
	public final Monnaie monnaie;
	public final String signature;
	
	public Cheque(Argent a, String signature) {
		this.montant = a.valeurEntiere()*100+a.valeurDecimale();
		this.signature = signature;
		this.monnaie = a.getMonnaie();
	}

    	public Argent montant( ) {
    		return new Argent(montant, monnaie);
    	}
	
	public String toString( ) {
		int valeurDecimale = (int)(this.montant%100);
		long valeurEntiere = this.montant/100;
		String res =  "CHEQUE de " + valeurEntiere + " " + monnaie.nom + (valeurEntiere > 1 ? "s" : "") + " et ";
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
		res += this.signature;
		return res;
	}

}
