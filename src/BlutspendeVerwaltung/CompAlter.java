package BlutspendeVerwaltung;

import java.util.Comparator;

public class CompAlter implements Comparator<Spender> {

	@Override
	public int compare(Spender o1, Spender o2) {
		return (o1.getAlter() - o2.getAlter());
	}

}
