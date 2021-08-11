import java.io.PrintWriter;

public abstract class Client {

	public abstract void recevoirDuCanal(String ligne);

	public abstract void recevoirDuClavier(String ligne);

	private final String nom;
	private final PrintWriter affichage;
	private Canal canal;

	public Client(String pseudo) {
		this.nom = pseudo;
		this.affichage = new PrintWriter(System.out, true);
		Clavier.attacher(this);
	}

	public Client(String pseudo, Dialogue d) {
		this.nom = pseudo;
		this.affichage = d.affichage;
		d.attacher(this);
	}

	public String getPseudo() {
		return this.nom;
	}

	public void afficher(String ligne) {
		synchronized (this.affichage) {
			this.affichage.println(ligne);
		}
	}

	public void attacher(Canal c) {
		this.canal = c;
	}

	public void envoyer(String ligne) {
		if (this.canal != null)
			synchronized (this.canal) {
				this.canal.envoyer(ligne);
			}
	}

}
