import java.util.Comparator;

public class ObjetComparator implements Comparator<Objet> {

	public int compare(Objet obj1, Objet obj2) {
		int rapport1 = obj1.valeur()*obj2.poids();
		int rapport2 = obj2.valeur()*obj1.poids();
		
		if ( rapport1 > rapport2) return -1;
		else if(rapport1 == rapport2) return 0;
		else return 1;
	}

}
