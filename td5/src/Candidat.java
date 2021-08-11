import tc.TC;

public class Candidat {

	public String nom;
	public String prenom;
	public int note;
	public DossierId dossierId;

	public Candidat(String nom, String prenom, int note, DossierId dossierId) {
		// a completer
		this.nom = nom;
		this.prenom = prenom;
		this.dossierId = dossierId;
		this.note= note;
	}

	public Candidat(String ligne) {
		// a completer
		String[] recu = TC.motsDeChaine(ligne);
		this.nom = recu[0];
		this.prenom = recu[1];
		this.note = Integer.parseInt(recu[2]);
		this.dossierId = new DossierId(recu[3]);
	}

	public String toString() {
		return this.nom+" "+this.prenom+" "+this.note+" "+this.dossierId.toString();
		
	}

	public boolean equals(Candidat candidat) {
		return this.nom.equals(candidat.nom) && this.prenom.equals(candidat.prenom);
	}

}
