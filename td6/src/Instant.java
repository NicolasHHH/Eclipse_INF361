import tc.TC;

public class Instant {

	private final String t;

	public Instant(String s) {
		if (s == null) {
			throw new AssertionError("null argument passed to Instant constructor");
		}
		this.t = s;
	}

	public String toString() {
		String[] mots = TC.decoupage(this.t, ':');
		int heures = Integer.parseInt(mots[0]);
		int minutes = Integer.parseInt(mots[1]);
		if (heures < 10 && minutes < 10) {
			return "0" + heures + ":" + "0" + minutes;
		} else if (heures < 10 && minutes >= 10) {
			return "0" + heures + ":" + minutes;
		} else if (heures >= 10 && minutes < 10) {
			return heures + ":" + "0" + minutes;
		} else
			return heures + ":" + minutes;
	}

	public boolean estAvant(Instant autre) {
		if (autre == null) {
			throw new AssertionError("null argument passed to Instant.estAvant");
		}
		String[] mots1 = TC.decoupage(this.t, ':');
		String[] mots2 = TC.decoupage(autre.t, ':');
		int minutes1 = Integer.parseInt(mots1[0]) * 60 + Integer.parseInt(mots1[1]);
		int minutes2 = Integer.parseInt(mots2[0]) * 60 + Integer.parseInt(mots2[1]);
		return minutes1 < minutes2;

	}

	public int compareTo(Instant autre) {
		if (autre == null) {
			throw new AssertionError("null argument passed to Position.compareTo");
		}
		String[] mots1 = TC.decoupage(this.t, ':');
		String[] mots2 = TC.decoupage(autre.t, ':');
		int minutes1 = Integer.parseInt(mots1[0]) * 60 + Integer.parseInt(mots1[1]);
		int minutes2 = Integer.parseInt(mots2[0]) * 60 + Integer.parseInt(mots2[1]);
		return minutes1 - minutes2;
	}

}
