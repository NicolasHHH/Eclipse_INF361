import tc.TC;
public class Argent {

	private final int valeur;
	private final Monnaie monnaie;

	public Argent(int v) {
		this.valeur = v;
		this.monnaie = new Monnaie("Euro", 1.0);
	}

	public Argent(int v, Monnaie monnaie) {
		if (monnaie == null)
			throw new IllegalArgumentException("le parametre monnaie est null");
		this.valeur = v;
		this.monnaie = monnaie;
	}
	
	
	public Argent(String str, Monnaie[] tab) {
		String[] coupe = TC.motsDeChaine(str);
		String money = coupe[1];
		String[] ncoupe = TC.decoupage(coupe[0], '.');
		int entier = Integer.parseInt(ncoupe[0]);
		int decim = Integer.parseInt(ncoupe[1]);
		this.monnaie = Monnaie.trouverMonnaie(money,tab);
		this.valeur = entier*100+decim;
		
	}

	public Monnaie getMonnaie() {
		return this.monnaie;
	}
	
	public int getValeur() {
		return this.valeur;
	}

	public int valeurEntiere() {
		return this.valeur / 100;
	}

	public int valeurDecimale() {
		return this.valeur % 100;
	}
	
	public boolean estEgalA(Argent a) {
		if ( a != null) {
			if( this.valeur == a.valeur && this.monnaie.estEgalA(a.monnaie)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		
		String res = "";
		int entier = this.valeur/100;
		res+=this.valeur/100+".";
		int decimal = this.valeur%100;
		if (decimal<10) {
			res+="0"+decimal;
		}
		else res+=decimal;
		res+=" ";
		if (entier>=2) {
			res += this.monnaie.pluriel();
		}
		else
			res += this.monnaie.nom;
		return res;
	}

	public Argent convertir(Monnaie autreMonnaie) {
		if (this.monnaie.estEgalA(autreMonnaie)) {
			return this;
		}
		double conversion = autreMonnaie.getTaux()/this.monnaie.getTaux();
		int val = (int) (this.valeur*conversion);
		Argent ag = new Argent(val,autreMonnaie);
		
		return ag;
	}

	public Argent plus(Argent x) {
		Argent xPrime = x.convertir(this.monnaie);
		Argent res = new Argent(this.valeur+xPrime.valeur,this.monnaie);
		
		return res;
	}

	public Argent moins(Argent x) {
		Argent xPrime = x.convertir(this.monnaie);
		if (this.valeur-xPrime.valeur<0)
			return null;
		else
			{
			Argent res = new Argent(this.valeur-xPrime.valeur,this.monnaie);
			return res;
			}
	}
}
