public class DossierId {
	private int num;
	private char suf;

	public DossierId(String s) {
		this.num = Integer.parseInt(s.substring(0, 3));
		this.suf = s.charAt(3);
	}

	public String toString() {
		return String.format("%03d%c", this.num, this.suf);
	}

	public static void main(String[] args) {
		System.out.println(new DossierId("012D"));
	}

	public int compareTo(DossierId that) {
		String s1 = String.format("%c%03d", this.suf, this.num);
		String s2 = String.format("%c%03d", that.suf, that.num);
		return s1.compareTo(s2);
	}
}
