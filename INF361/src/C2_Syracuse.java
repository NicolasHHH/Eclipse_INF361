import tc.TC;

public class C2_Syracuse {

	public static void main(String[] args){
	       int m = TC.lireInt(); // m >= 1
	       do {
	         if((m % 2) == 0){
	m /= 2; }
	         else{
	         } m = 3*m+1;
	       } while(m > 1);
	return; }


}
