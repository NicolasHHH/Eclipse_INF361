public class ToutLocalChat {

	public static void main(String[] args) {
		CanalLocal canal = new CanalLocal();
		canal.lancer();
		canal.attacher(new Chat("Alice", new Dialogue(400, 0)));
		canal.attacher(new Chat("Bob",new Dialogue(400, 0)));
		canal.attacher(new Chat("Charlie", new Dialogue(400, 0)));
	}
}
