import java.math.BigInteger;

import tc.TC;

/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Cette classe permet de tester differentes implantations du calcul de Fibonacci
 */
public class TestFibonacci {

	/**
	 * Calcule et affiche les premiers n termes de la suite de Fibonacci (exo 3)
	 */
	public static void calculePremiersTermes(Fibonacci algo, int n) {
		TC.println("Test pour "+algo.name());
		for(int i=0;i<n;i++)
			TC.println("F("+i+")="+algo.fibo(i)+" ("+algo.operations()+" ops)");
	}

	/**
	 * Evalue les performances d'une implantation donnée pour le calcul de F(n) (exo 3)
	 */
	public static void evaluePerformances(Fibonacci algo, int n) {
		long  startTime = System.nanoTime();
		BigInteger r1 = algo.fibo(n);
		String s1 = r1.toString();
		int n1 = s1.length();
		if(n1 > 50) s1 = s1.substring(0, 30) + "... (" + (n1 - 30) + " chiffres non affichés)";
		System.out.println();
		System.out.printf("F(%d)= %s%n", n, s1, algo.operations());
		System.out.printf("%s : %d ops, %d ms%n", algo.name(), algo.operations(), (System.nanoTime() - startTime) / 1000000);
	}

	/**
	 * Evalue et compare les performances des différentes implantations (exo 3)
	 */
	public static void evaluePerformances(int n, boolean tous, boolean noRapide) {
		evaluePerformances(new FibonacciMatrice(new PuissanceRapide()), n);
		if(noRapide==false)
			evaluePerformances(new FibonacciMatrice(new PuissanceNaive()), n);
		evaluePerformances(new FibonacciIteratif(), n);
		if(tous==true)
			evaluePerformances(new FibonacciRec(), n);
	}


	/**
	 * Testing Fibonacci computation (exo 3)
	 */
	public static void main(String[] args) {
		int n=10;

		Fibonacci algo; // choix de l'implantation
		//algo=new FibonacciRec();
		//algo=new FibonacciIteratif();
		//algo=new FibonacciMatrice(new PuissanceNaive());
		algo=new FibonacciMatrice(new PuissanceRapide());

		calculePremiersTermes(algo, n);

		/*
		System.out.println("\n------ Evaluation des performances ------");

		System.out.println("\n--- Compare tous les algorithmes (n petit) ---");
		evaluePerformances(42, true, false);
		*/
		/*
		System.out.println("\n--- Compare les algorithmes, sauf Fibonacci Rec (n grand) ---");
		evaluePerformances(2000, false, false);
		*/
		/*
		System.out.println("\n--- Compare les algorithmes: iteratif vs. Fibonacci rapide (n tres grand) ---");
		evaluePerformances(400000, false, true);
		*/
	}

}
