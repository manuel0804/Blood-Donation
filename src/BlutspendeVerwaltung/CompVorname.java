package BlutspendeVerwaltung;

import java.util.Comparator;

public class CompVorname implements Comparator<Spender> {

	@Override
	public int compare(Spender o1, Spender o2) {
		return o1.getVorname().toLowerCase().compareTo(o2.getVorname().toLowerCase());
	}

}
