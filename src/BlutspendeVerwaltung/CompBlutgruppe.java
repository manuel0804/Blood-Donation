package BlutspendeVerwaltung;

import java.util.Comparator;

public class CompBlutgruppe implements Comparator<Spender> {

	@Override
	public int compare(Spender o1, Spender o2) {
		return o1.getBlutgruppe().compareTo(o2.getBlutgruppe());
	}

}
