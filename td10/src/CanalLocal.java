import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class CanalLocal implements Canal {

	private final Collection<Client> clients = new LinkedList<>();
	private final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
	private static final int DELAY = 2000; // en millisecondes

	public void lancer() { //
		new Thread(new Runnable() {
			@SuppressWarnings("synthetic-access")
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					try {
						String line = CanalLocal.this.queue.take();
						for (Client client : CanalLocal.this.clients)
							synchronized (client) {
								client.recevoirDuCanal(line);
							}
						try {
							Thread.sleep(DELAY);
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					} catch (InterruptedException e) {
						return;
					}
				}
			}
		}).start();
	}

	public void attacher(Client client) {
		if (client == null)
			throw new AssertionError("Client parameter is null");
		this.clients.add(client);
		client.attacher(this);
	}

	@Override
	public void envoyer(String ligne) {
		try {
			this.queue.put(ligne);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
