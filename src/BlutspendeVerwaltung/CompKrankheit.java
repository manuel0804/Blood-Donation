package BlutspendeVerwaltung;

import java.util.Comparator;

public class CompKrankheit implements Comparator<Spender> {

	@Override
	public int compare(Spender o1, Spender o2) {
		return Boolean.compare(o1.isKrankheit(), o2.isKrankheit());
	}

}
