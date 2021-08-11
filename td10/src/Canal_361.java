import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Canal_361 implements Canal {
	// private static final String HOST = "localhost";
	// private static final int PORT = 1234;
	// private static final String HOST = "129.104.49.1";
	// private static final int PORT = 9094;
	private static final String HOST = "rolls.polytechnique.fr";
	private static final int PORT = 60500;

	private final Client client;
	private Socket socket;
	private PrintWriter out = null;

	public Canal_361(final Client c) {
		this.client = c;
		if (c == null)
			throw new AssertionError("Client parameter is null");
		try {
			this.socket = new Socket(HOST, PORT);
			this.socket.setTcpNoDelay(true);
			this.socket.setSoLinger(true, 0);
			this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream(), StandardCharsets.UTF_8),
					true);
		} catch (IOException e) {
			System.err.println("initialization error: " + e.getMessage());
			System.exit(-1);
		}
		c.attacher(this);
	}

	@Override
	public void envoyer(String ligne) {
		if (this.out != null) {
			this.out.println(ligne);
			if (this.out.checkError()) {
				System.err.println("Sending error, exiting");
				System.exit(-1);
			}
		}
	}

	public void lancer() {
		new Thread(new Runnable() {
			@SuppressWarnings({ "resource", "synthetic-access" })
			@Override
			public void run() {
				Scanner scanner;
				try {
					scanner = new Scanner(Canal_361.this.socket.getInputStream(), "UTF-8");
				} catch (IOException e) {
					System.err.println("Scanner error: " + e.getMessage());
					return;
				}
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					synchronized (Canal_361.this.client) {
						Canal_361.this.client.recevoirDuCanal(line);
					}
				}
				IOException error = scanner.ioException();
				if (error != null)
					System.err.println("Network error while reading: " + error);
				scanner.close();
				System.exit(-1);
			}
		}).start();
	}
}
