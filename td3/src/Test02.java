import tc.TC;

public class Test02 {
  public static void main(String[] args) {	  
	Monnaie euro=new Monnaie("Euro",1);
	Monnaie yuan=new Monnaie("Yuan",0.14); 
	Monnaie yuan2=new Monnaie("Yuan",0.14);
	Monnaie yuan3=new Monnaie("Yuan",0.13);
	
	TC.println("-- test estEgalA() de Monnaie: attend false, true, false");
	TC.println(euro.estEgalA(yuan)+ ", " + yuan.estEgalA(yuan2)+ ", " + yuan2.estEgalA(yuan3));
	TC.println();
	
    	Argent a1 = new Argent(13468); // Euro implicite
    	Argent a2 = new Argent(13468, euro);
    	Argent a3 = new Argent(13399, euro); 
    	Argent a4 = new Argent(13468, yuan);
    	Argent a5 = new Argent(13468, yuan2);
    
    	TC.println("-- test estEgalA() de Argent: attend true, false, false, true");
    	TC.println(a1.estEgalA(a2)+ ", " + a1.estEgalA(a3)+ ", " + a2.estEgalA(a4)+ ", " + a4.estEgalA(a5));   
  }
}
