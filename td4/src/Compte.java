import tc.TC;
public class Compte {
	public final long numero;
	public final String nom;  // hyp : pas d'espace
	private Argent solde;
	private int plafond;
		
	public Compte(long numero, String nom, Argent a, int plafond){
		this.numero = numero;
		this.nom = nom;
		this.solde = a;
		this.plafond=plafond;
	}
	
	public Compte(String str, Monnaie[] tab) {
		String[] sCoupe = TC.motsDeChaine(str);
		this.numero = Long.parseLong(sCoupe[0]);
		this.nom = sCoupe[1];
		this.solde = new Argent(sCoupe[2]+" "+sCoupe[3],tab);
		this.plafond = Integer.parseInt(sCoupe[4]);
	}
			
	public Argent getSolde(){
		return this.solde;
	}
	
	public Monnaie getMonnaie(){
		return this.solde.getMonnaie();
	}
	
	public int getPlafond(){
		return this.plafond;
	}
		
	public void setPlafond(int p){
		this.plafond=p;
	}
	
	public String toString() {
		return this.numero+" "+this.nom+" "+this.getSolde().toString()+" "+this.getPlafond();
	}
	
	public void deposer(Argent argent) {
		this.solde = this.solde.plus(argent);
	}
	
	public boolean prelever(Argent argent, boolean avecPlafond) {
		if (avecPlafond && argent.convertir(this.getSolde().getMonnaie()).getValeur()>100*this.plafond)
			return false;
		Argent newAg = this.solde.moins(argent);
		if (newAg == null) {
			return false;
		}
		this.solde = newAg;
		return true;
	}
}
