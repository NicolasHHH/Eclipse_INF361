import java.util.Random;

public interface Objet {

	public static final Random RANDOM = new Random(42);

	/** @return une description de l'objet */
	public String toString();

	/** @return le poids de l'objet en grammes */
	public int poids();

	/** @return la valeur de l'objet en sous */
	public int valeur();

}
