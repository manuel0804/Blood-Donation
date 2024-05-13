package BlutspendeVerwaltung;

import java.util.Comparator;

public class CompNachname implements Comparator<Spender> {

	@Override
	public int compare(Spender o1, Spender o2) {
		return o1.getNachname().toLowerCase().compareTo(o2.getNachname().toLowerCase());
	}

}
