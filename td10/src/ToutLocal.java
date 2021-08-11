public class ToutLocal {

	public static void main(String[] args) {
		CanalLocal canal = new CanalLocal();
		canal.lancer();
		canal.attacher(new SimpleClient("Alice", new Dialogue(400, 0)));
		canal.attacher(new SimpleClient("Bob", new Dialogue(400, 0)));
		canal.attacher(new SimpleClient("Eve", new Dialogue(400, 0)));
		canal.attacher(new SimpleClient("Chuck"));
	}

}
