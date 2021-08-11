import tc.TC;

public class Position {
	private final Instant instant;
	private final int latitude, longitude;

	public Position(Instant pinstant, int platitude, int plongitude) {
		this.instant = pinstant;
		this.latitude = platitude;
		this.longitude = plongitude;
	}

	public Position(int platitude, int plongitude) {
		this.instant = null;
		this.latitude = platitude;
		this.longitude = plongitude;
	}

	public Instant instant() {
		return this.instant;
	}

	@Override
	public String toString() {
		if (instant == null)
			return "(" + this.latitude + ',' + this.longitude + ")";
		else {

			return "(" + this.latitude + ',' + this.longitude + ")" + " heure " + this.instant.toString();
		}
	}

	public int distance(Position autre) {
		if (autre == null) {
			throw new AssertionError("null argument passed to Position.distance");
		}
		return Math.abs(autre.latitude - this.latitude) + Math.abs(autre.longitude - this.longitude);
	}

}
