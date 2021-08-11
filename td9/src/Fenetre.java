
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * @author C. Durr (2008), L. Castelli Aleardi (2010)
 */
class DArbre {
    static final int d=5, rad=1;
    
    static int indice=0, indiceValues=0;
    
    int lw, rw;
    String v;
    Color c;
    DArbre l,r;

    DArbre(DArbre _l,DArbre _r,String _v) {
	l = _l;
	c = Color.black;
	v = _v;
	r = _r;
	lw = (l==null) ? 0 : l.lw+l.rw+d/2;
	rw = (r==null) ? 0 : r.lw+r.rw+d/2;
    }

    // it works only for binary search trees
    public static DArbre decodeArbre (String code, String[] labels) {
    	DArbre gauche=null, droit=null;
    	
    	String element=labels[indiceValues];
    	indiceValues++;
    	indice++;
    	    	
    	while(code.charAt(indice)!='0'){
    		if(gauche==null && labels[indiceValues].compareTo(element)<=0) {
    			gauche=decodeArbre(code,labels);
    		}
    		else{
    			droit=decodeArbre(code,labels);
    		}
    	}
    	indice++;
    	return new DArbre(gauche,droit,element);
	     
    }

    public static DArbre creeDArbre(Noeud a) {
    	if(a==null)
    		return null;
    	String s="("+a.contenu().mot+","+a.contenu().occurrences+")";
    	return new DArbre(creeDArbre(a.gauche), creeDArbre(a.droit), s);
    	
    }

    void paint(Graphics g, int x, int y, int f, boolean showl) {
	int xx, yy;
	if (l!=null) {
	    xx = x - d/2 - l.rw;
	    yy = y+d;
	    g.drawLine(x*f,y*f,xx*f,yy*f);
	    l.paint(g, xx, yy, f, showl);
	}
	if (r!=null) {
	    xx = x + d/2 + r.lw;
	    yy = y+d;
	    g.drawLine(x*f,y*f,xx*f,yy*f);
	    r.paint(g, xx, yy, f, showl);
	}
	g.setColor(showl ? Color.white : c);
//	g.fillOval((x-rad)*f, (y-rad)*f, 2*rad*f, 2*rad*f);
	g.fillOval((x-(int)(1.25*rad))*f, (y-rad)*f, (int)(2.5*rad*f), 2*rad*f);
	if (showl) {
	    g.setColor(c);
	    FontMetrics m = g.getFontMetrics();
	    String label  = ""+v;
	    g.drawOval((x-(int)(1.25*rad))*f, (y-rad)*f, (int)(2.5*rad*f), 2*rad*f);
	    g.drawString(label, 
			 (int)(1.05*x*f)-(int)(label.length()*m.charWidth('0')/2.), 
			 y*f+m.getAscent()/2);
	}
	g.setColor(Color.black);
    }
}

class Fenetre extends Canvas {
    DArbre a;

    static int compteur = 1;

   Fenetre(String encoding, String[] labels) {		
	a=DArbre.decodeArbre(encoding,labels);
	Frame f = new Frame("Arbre " + compteur++);
	f.add(this);
	f.setSize(400, 600);
	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    System.exit(0);
		}
	    });
	f.setVisible(true);
    }
   
   public Fenetre(DArbre a) {		
	   this.a=a;
	   Frame f = new Frame("Arbre " + compteur++);
		f.add(this);
		f.setSize(400, 600);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			    System.exit(0);
			}
		    });
		f.setVisible(true);
	    }
   
   public Fenetre(Noeud n) {
	   this.a=DArbre.creeDArbre(n);
	   Frame f = new Frame("Arbre " + compteur++);
		f.add(this);
		f.setSize(400, 600);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			    System.exit(0);
			}
		    });
		f.setVisible(true);
   }

    public void paint(Graphics g) {
	if (a!=null) {
	    int f = getWidth()/(a.lw+2*a.d+a.rw);
	    int x = a.lw + DArbre.d;
	    int y = DArbre.d;
	    a.paint(g,x,y, Math.max(f,1), f>6);
	}
    }
    
    /*
    public static void main(String[] args) {
    	Noeud n=null;
    	n=Arbre.ajout(n, "eleve");
    	n=Arbre.ajout(n, "ecole");
    	n=Arbre.ajout(n, "x");
    	n=Arbre.ajout(n, "eleve");
    	n=Arbre.ajout(n, "x");
    	n=Arbre.ajout(n, "prof");
    	n=Arbre.ajout(n, "ecole");
    	DArbre a=DArbre.creeDArbre(n);
    	
    	DArbre a0=new DArbre(null, null,"zut");
    	DArbre a1=new DArbre(null, null,"abc");
    	DArbre a2=new DArbre(null, a0,"eleve");
    	DArbre a3=new DArbre(a1, a2,"bac");
    	
    	new Fenetre(a);
    	new Fenetre(a3);
    }
    */
}
