import tc.TC;

public class Message {
	private final String[] champs;
	private final String expediteur;
	private final String destinataire;
	private final TypeMessage type;

	public Message(String ligne) {
		if (ligne == null) {
			this.champs = new String[0];
			this.expediteur = null;
			this.destinataire = null;
			this.type = TypeMessage.__WRONG__;
			return;
		}
		this.champs = TC.decoupage(ligne, ';');
		if (this.champs.length < 3 || this.champs[0].length() == 0 || this.champs[1].length() == 0) {
			this.expediteur = null;
			this.destinataire = null;
			this.type = TypeMessage.__WRONG__;
			return;
		}
		this.expediteur = this.champs[0];
		this.destinataire = this.champs[1];
		TypeMessage t = TypeMessage.typeOf(this.champs[2]);
		if (this.champs.length < t.nFields) {
			this.type = TypeMessage.__WRONG__;
			return;
		}
		if (t == TypeMessage.__MESSAGE__ && (this.champs[3].length() == 0 || this.champs[4].length() == 0)) {
			this.type = TypeMessage.__WRONG__;
			return;
		}
		this.type = t;
	}

	public String getExpediteur() {
		return this.expediteur;
	}

	public String getDestinataire() {
		return this.destinataire;
	}

	public TypeMessage getType() {
		return this.type;
	}

	public String getChamp(int i) {
		if (i < 0 || i >= this.type.nFields)
			throw new IndexOutOfBoundsException(i + " vs. " + this.type.nFields);
		return this.champs[i];
	}

	@Override
	public String toString() {
		if (this.type == TypeMessage.__WRONG__)
			return this.type.toString();
		String s = this.expediteur;
		for (int i = 1; i < this.type.nFields; ++i)
			s += ';' + this.champs[i];
		return s;
	}
}
