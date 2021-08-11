import java.util.Arrays;

public class ResolutionApprochee implements ResolutionSacADos {

	public SacADos remplirSac(Objet[] obj, int capacite) {
		Objet[] objets = obj.clone();
		Arrays.sort(objets, new ObjetComparator());

		SacADos premier = new SacADos(capacite);
		SacADos deuxieme = new SacADos(capacite);
		int i = 0;
		while(i < objets.length) {
			if(objets[i].poids()<=premier.capaciteDisponible()) {
				premier.ajouter(objets[i]);
			}
			else if(objets[i].poids()<=deuxieme.capaciteDisponible()) {
				deuxieme.ajouter(objets[i]);
			}
			i++;
		}
		
		if (premier.valeur()>=deuxieme.valeur()) {
			return premier;
		}
		else return deuxieme;
	}
	
	public String name() {
		return "Résolution approchée";
	}
	
}
