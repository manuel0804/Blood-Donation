package BlutspendeVerwaltung;

public class Blut implements Comparable<Blut> {
	private String blutgruppe;
	private String rhesusfaktor;
	private boolean krank;

	public Blut(String blutgruppe, String rhesusfaktor, boolean krank) {
		this.blutgruppe = blutgruppe;
		this.rhesusfaktor = rhesusfaktor;
		this.krank = krank;
	}

	public String getBlutgruppe() {
		return blutgruppe;
	}

	public void setBlutgruppe(String blutgruppe) {
		this.blutgruppe = blutgruppe;
	}

	public String getRhesusfaktor() {
		return rhesusfaktor;
	}

	public void setRhesusfaktor(String rhesusfaktor) {
		this.rhesusfaktor = rhesusfaktor;
	}
	
	public boolean isKrank() {
		return krank;
	}

	public void setKrank(boolean krank) {
		this.krank = krank;
	}

	@Override
	public String toString() {
		return blutgruppe + rhesusfaktor;
	}

	@Override
	public int compareTo(Blut o) {
		return blutgruppe.compareTo(o.blutgruppe);
	}

}
