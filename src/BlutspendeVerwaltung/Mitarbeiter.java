package BlutspendeVerwaltung;

public class Mitarbeiter extends Mensch implements JobBeschreibung {
	private int dienstjahre;

	public Mitarbeiter(String vorname, String nachname,int alter, int dienstjahre) {
		super(vorname, nachname, alter);
		this.dienstjahre = dienstjahre;
	}
	
	public void blutabnehmen(Blut blut, Lager lager) {
		lager.getBlutListe().add(blut);
		System.out.println("Das Blut wurde erfolgreich abgenommen");
		System.out.println("Dem Spender wurde ein Kaesbrot gegeben");
	}

	public double getDienstjahre() {
		return dienstjahre;
	}

	public void setDienstjahre(int dienstjahre) {
		this.dienstjahre = dienstjahre;
	}

	@Override
	public String toString() {
		return super.toString() + ", Dienstjahre: " + dienstjahre;
	}
	
}
