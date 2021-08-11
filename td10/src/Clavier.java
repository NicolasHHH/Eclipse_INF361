import java.util.Scanner;

public class Clavier {

	private static Client client = null;

	public static void attacher(Client c) {
		if (client != null)
			throw new IllegalStateException("the keyboard is already bound to another client");
		if (c == null)
			throw new AssertionError("Client parameter is null");
		client = c;
		System.out.println("Ceci est la console de " + c.getPseudo());
		new Thread(new Runnable() {
			@SuppressWarnings({ "resource", "synthetic-access" })
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					synchronized (client) {
						client.recevoirDuClavier(line);
					}
				}
				System.err.println("Input closed, exiting");
				System.exit(-1);
			}
		}).start();
	}

}
