import java.util.Comparator;
import java.util.Locale;

public class Comparateur implements Comparator<String> {

  private final Locale locale;

  public Comparateur(Locale _locale) {
    this.locale = _locale;
  }

  @Override
  public int compare(String s1, String s2) {
    // TODO Auto-generated method stub
    return s1.toUpperCase(this.locale).compareTo(s2.toUpperCase(this.locale));
  }

}
