import java.util.Iterator;
import java.util.LinkedList;

public class ListeEntiers {
	private LinkedList<Integer> l;
	
	// Constructeur.
	public ListeEntiers() {
		l = new LinkedList<Integer>();
	}

	// Ajouter un entier à la fin de la liste.
	public void ajouterEnQueue(int n) {
		if(l.size() == 0 || l.getLast() != n) {
			l.addLast(n);
		}
	}
	
	// Convertir en String, e.g., pour l'affichage.
	public String toString( ) {
		String output = "";
		
		Iterator<Integer> it = l.iterator();
		while(it.hasNext()) {
			output += it.next();
			if(it.hasNext()) {
				output += ", ";
			}
		}
		
		return output;
	}
	
	// Convertir la liste en un tableau.
	public int[] toArray() {
		int[] t = new int[l.size()];
		
		Iterator<Integer> it = l.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			t[i++] = it.next();
		}
		
		return t;		
	}
}
