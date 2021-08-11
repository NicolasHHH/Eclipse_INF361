
public class ResolutionExacte implements ResolutionSacADos {

	private Objet[] objets;
	private SacADos sac;
	private SacADos maxsac;

	public SacADos remplirSac(Objet[] objets, int capacite) {
		this.objets = objets;
		this.sac = new SacADos(capacite);
		this.maxsac = new SacADos(capacite);
		remplir(0);
		//System.out.println("final:");
		return maxsac;
	}
	private void remplir(int i0){
		if (i0<this.objets.length) {
			if (this.objets[i0].poids()<=this.sac.capaciteDisponible()) {
				this.sac.ajouter(this.objets[i0]);
				if (this.sac.valeur() > this.maxsac.valeur()) {
					this.maxsac = SacADos.copie(this.sac);
				}
				remplir(i0+1);
				//System.out.println(this.sac);
				this.sac.retirer(this.objets[i0]);
			}
			remplir(i0+1);
		}
    }

	public String name() {
		return "Résolution exacte";
	}

}
