import tc.TC;

public class Palindromes{

	public static boolean estPalindrome(String mot){
		return estPalindrome(mot, 0, mot.length());
	}

	public static boolean estPalindrome(String mot, int g, int d){
		int len = mot.length();
		
		if ( g>=d-1 ) return true;
		if (mot.charAt(g) == mot.charAt(d-1) ) {
			if (g+1<len && d-1>=0) {
				return estPalindrome(mot,g+1,d-1);
			}
			else return false;
		}
		else 
			return false;
	}

	public static void testPalindrome(String mot){
		if(estPalindrome(mot)){
			TC.println(mot + " est un palindrome");
		}
		else{
			TC.println(mot + " n'est pas un palindrome");
		}
	}

	public static void main(String[] args){
		testPalindrome("AB");
		testPalindrome("BAOBAB");
		testPalindrome("KAYAK");
		testPalindrome("ABBA");
		testPalindrome("BOBAR");
		testPalindrome("ESOPERESTEICIETSEREPOSE");
	}

}
