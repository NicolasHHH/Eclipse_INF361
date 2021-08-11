import java.util.Arrays;
import java.util.Comparator;

public class Itineraire {
	public final String pseudo;
	private final Position[] positions;
	private int nPositions; // nombre actuel de positions

	public Itineraire(String unPseudo, int maxPositions) {
		 this.pseudo = unPseudo;
		 this.positions = new Position[maxPositions];
	}

	public String toString() {
		return "Itineraire de " + this.pseudo + " contenant " + this.nPositions + " position(s) sur "
				+ this.positions.length;
	}

	public void ajouter(Position position) {
		this.positions[this.nPositions++] = position;
	}

	public Instant[] instants() {
		Instant[] ins_list = new Instant[this.nPositions];
		for (int i =0;i<this.nPositions;i++) {
			ins_list[i] = positions[i].instant();
		}
    	return ins_list;
	}

	public Position plusProche(Position autre) {
		if(this.positions.length == 0 || this.positions == null )
			return null;
		else {
			int dis_min = autre.distance(positions[0]);
			int indice = 0;
			for (int i =1;i<this.nPositions;i++) {
				int dis = autre.distance(positions[i]);
				if (dis<dis_min) {
					dis_min = dis;
					indice = i;
				}
			}
	    	return positions[indice];
		}
	}

	// NE PAS MODIFIER
	private static final Comparator<Position> comparateur = new Comparator<Position>() {
		public int compare(Position p1, Position p2) {
			return p1.instant().compareTo(p2.instant());
		}
	};

	// NE PAS MODIFIER
	public void trier() {
		Arrays.sort(this.positions, 0, this.nPositions, comparateur);
	}

	public Position[] contacts(Itineraire autre, int seuil) {
		int n1 = this.nPositions;
		int n2 = autre.nPositions;
		int i = 0;
		int j = 0;
		int count = 0;
		Position[] temp = new Position[n1];
		Position Pos1, Pos2;
		
		while (i<n1 && j < n2) {
			Pos1 = this.positions[i];
			Pos2 = autre.positions[j];
			
			if (Pos1.instant().compareTo(Pos2.instant())==0) {
				if (Pos1.distance(Pos2)<=seuil) {
					temp[count] = Pos1;
					//System.out.println("pos1"+ Pos1.toString());
					count++;
;				}
				i ++;
				j ++;
			}
			else if (Pos1.instant().compareTo(Pos2.instant())<0) {
				i++;
			}
			else j ++;
		}
		
		Position[] res = new Position[count];
		for(int k = 0; k< count ; k++) {
			res[k] = temp[k];
		}
		
    	return res;
	}

}
