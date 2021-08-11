public class Liquide implements ArgentPhysique{
	private static final int[] VALS = new int[]{
		10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1
	};

	private static final int nb_billets_pieces = VALS.length;
	
	private final int[] coeffs;
	private final Monnaie monnaie;
	
	public Liquide(Argent a) {
		this.coeffs = new int[nb_billets_pieces];
		int e = a.valeurEntiere() * 100 + a.valeurDecimale();
		for(int i = 0; i < nb_billets_pieces; i++) {
			
			this.coeffs[i] = e/VALS[i];
			e %= VALS[i];
		}
		this.monnaie = a.getMonnaie();
	}

    	public Argent montant( ) {
			// __ Changer la valeur de retour __
    		int v = 0;
    		for (int i=0 ;i< VALS.length;i++) {
    			v += VALS[i]*this.coeffs[i];
    		}
    		Argent agretour = new Argent(v,this.monnaie);
    		return agretour;
    	}

	public String toString( ) {
		String res = "";
		for(int i = 0; i < nb_billets_pieces; i++) {
			if(coeffs[i] == 0)
				continue;
			if(! res.equals(""))
				res += ", ";
			res += coeffs[i] + (VALS[i] >= 500 ? " billet" : " piece")
					+ (coeffs[i] > 1 ? "s de " : " de ");
			if(VALS[i]>=100)
				res += (VALS[i]/100) + " " + this.monnaie.nom + (VALS[i] != 100 ? "s" : "");
			else{

				if(this.monnaie.nom.equals("Euro")){
					res += VALS[i] + " centime" + (VALS[i] != 1 ? "s" : "");
				}
				else if(this.monnaie.nom.equals("Livre")){
					res += VALS[i] + " " + (VALS[i] != 1 ? "pence" : "penny");
				}
				else if(this.monnaie.nom.equals("Dollar")){
					res += VALS[i] + " cent" + (VALS[i] != 1 ? "s" : "");
				}
				else if(this.monnaie.nom.equals("Rouble")){
					res += VALS[i] + " kopeck" + (VALS[i] != 1 ? "s" : "");
				}
				else if(this.monnaie.nom.equals("Yuan")){
					res += VALS[i] + " fen" + (VALS[i] != 1 ? "s" : "");
				}
				else{
					res += VALS[i] + " centime" + (VALS[i] != 1 ? "s" : "") + " de " + this.monnaie;
				}
				
			}
				
		}
		if(res.equals(""))
			return "pas de liquide";
		return res;
	}	
	
	public Monnaie getMonnaie(){
		return this.monnaie;
	}	
}
