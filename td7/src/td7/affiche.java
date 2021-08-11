package td7;

public class affiche {
	public static void affiche(int n ) {
		if (n>0) {
			affiche(n-1);
			System.out.println(n);
			affiche(n-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		affiche(5);
	}

}
