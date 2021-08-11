
public class Post {
	int contenu;
	Post suivant;
	static int count = 0;

	Post(int c, Post m) {
	    this.contenu = c;
	    this.suivant = m;
	  
	}
	public static void lister_1(Post m) {
	    while (m.contenu!= 0) {
	      System.out.print(m.contenu);
	      m = m.suivant;
	    }
	 }
	public int longueur() {
	    Post l = this;
	    int res = 1;
	    while (l.suivant != null) {
	      l = l.suivant;
	      res+=res;
	    }
	    return res;
	  }
	
	public Post dernier() {
	   Post l = this;
	    while (l.suivant != null) {
	      l = l.suivant;
	    }
	    
	    return l;
	  }
	  public Post incremente() {
	    Post resultat = new Post(this.contenu+1, null);
	    Post l = this;
	    while (l.suivant!=null) {
	      l = l.suivant;
	      resultat.dernier().suivant = new Post(l.contenu+1, null);
	    }
	    return resultat;
	  }

	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Post m = null;
	    for (int i = 1; i < 5; ++i)
	    	m = new Post(i, m);
	    lister_1(m);
	    
	    Post p = new Post(5, null);
	    p.suivant = p;
	    System.out.println(p.longueur());
	}

}
