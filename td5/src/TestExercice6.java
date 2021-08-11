import tc.TC;

public class TestExercice6 {

	public static void main(String[] args) {
		System.setProperty("line.separator", "\n");

		Candidat[] table;
		CountingComparator comp = new CountingComparator();

		int size = askForSize();
		while (size > 0) {
			table = new Candidat[size];
			initRandomData(size, table);
			comp.reset();
			TC.println("generated random table of size " + size);
			new MergeSort(table, comp).run();
			TC.println("number of comparisons MergeSort: " + comp.getCount());
			table = new Candidat[size];
			initRandomData(size, table);
			comp.reset();
			new InsertionSort(table, comp).run();
			TC.println("number of comparisons InsertionSort: " + comp.getCount());
			TC.println();
			size = askForSize();
		}
	}

	private static void initRandomData(int size, Candidat[] table) {
		for (int i = 0; i < size; i++) {
			table[i] = new Candidat("dummy", "dummy", (int) (Math.random() * size), new DossierId("000X"));
		}
	}

	private static int askForSize() {
		TC.print("enter a table size to test (0 to exit): ");
		return TC.lireInt();
	}

}
