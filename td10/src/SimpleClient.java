public class SimpleClient extends Client {

	public SimpleClient(String pseudo) {
		super(pseudo);
	}

	public SimpleClient(String pseudo, Dialogue d) {
		super(pseudo, d);
	}

	@Override
	public void recevoirDuCanal(String ligne) {
		// on affiche simplement ce qui arrive du canal
		afficher("-- " + ligne + " --");
	}

	@Override
	public void recevoirDuClavier(String ligne) {
		// on envoie simplement ce qui arrive du clavier
		envoyer("++ " + ligne + " ++");
	}

	public static void main(String[] args) {
		new Canal_361(new SimpleClient("Alice")).lancer();  // un seul
		new Canal_361(new SimpleClient("Bob", new Dialogue(400, 0))).lancer();
		
	}

}
