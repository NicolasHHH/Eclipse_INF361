

public class CandidatComparatorNote implements CandidatComparator {

    private static final String idf = "Ile-de-France";

    public int compare(Candidat c1, Candidat c2) {
    	if (c1.note > c2.note) {
    		return 1;
    	}
    	else if ( c1.note == c2.note) {
    		if (c1.getGenre() != c2.getGenre()) {
    			if (c1.getGenre()==Candidat.Genre.F) return 1;
    			else return -1;
    		}
    		else {
    			if (c1.getRegion().compareTo(idf) == 0 && c2.getRegion().compareTo(idf) != 0) {
    				return -1;
    			}
    			else if(c1.getRegion().compareTo(idf) != 0 && c2.getRegion().compareTo(idf) == 0) {
    				return 1;
    			}
    			else return 0;
   
    		}
    	}
    	else {
    		return -1;
    	}
    }

}
