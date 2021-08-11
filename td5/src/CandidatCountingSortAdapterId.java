
public class CandidatCountingSortAdapterId implements CountingSortAdapter {

	private int pos;

	public CandidatCountingSortAdapterId(int pos) {
		this.pos = pos;
	}

	@Override
	public int getMaxValue() {
		return 36; // 26 lettres + 10 chiffres
	}

	@Override
	public int getValue(Candidat element) {
		char letter = element.dossierId.toString().toUpperCase().charAt(this.pos);
		// on suppose qu'on a un caractere alphanumerique, ce qui est
		// vrai pour nos Id de candidats
		if (Character.isDigit(letter)) {
			return (int) letter - 48;
		} else {
			return (int) letter - 55;
		}
	}

}
