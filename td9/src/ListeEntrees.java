public class ListeEntrees {
	class Node {
		Entree entree;
		Node suivant;
		
		public Node(Entree e, Node n) {
			this.entree = e;
			this.suivant = n;
		}		
	}
	
	private Node first;
	private Node last;
	public int size;
	

	
	// Constructeur.
	public ListeEntrees() {
		first = null;
		last = null;		
		size = 0;
	}
	
	// Ajouter une Entree à la fin de la liste.
	public void ajouterEnQueue(Entree entree) {
		if (size == 0) {
			first = new Node(entree, null);
			last = first;
		} else {
			Node n = new Node(entree, null);
			last.suivant = n;
			last = n;
		}
		
		size++;
	}
	
	// Concaténer deux listes. Le résultat est stocké dans la 
	// liste actuelle.
	public void concatener(ListeEntrees liste) {
	    if (liste != null && liste.size > 0) {
		if(this.size > 0) {
			this.last.suivant = liste.first; 
			this.last = liste.last;
		} else {
			this.first = liste.first;
			this.last = liste.last;
		}
		this.size = this.size + liste.size;		
	    }
	}
	
	// Convertir la liste en String, e.g., pour l'affichage.
	public String toString( ) {
		String output = "";

		Node n = first;
		while (n != null) {
			output += n.entree.mot + " : " + n.entree.occurrences;
			if (n.suivant != null) {
				output += "\n";
			}
			n = n.suivant;
		}
		
		return output;
	}
	
	// Convertir la liste en un tableau.
	public Entree[] toArray() {
		Entree[] t = new Entree[this.size];
		
		Node n = first;
		int i = 0;
		while(n != null) {
			t[i++] = n.entree;
			n = n.suivant;
		}
		
		return t;		
	}
	
	/**
	 * returns the Entree object at the specified position
	 * @param index
	 * @return the Entree object at the specified position
	 */
//	public Entree get(int index){
//		if(index < 0 || index >= size)
//			throw new IndexOutOfBoundsException();
//		
//		Node node  = first;
//		for(int i=0; i < index; i++){
//			node = node.suivant;
//		}
//			
//		return node.entree;
//	}

}
