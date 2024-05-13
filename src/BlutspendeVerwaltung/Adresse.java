package BlutspendeVerwaltung;


public class Adresse {
	private String strasse;
	private int hausnummer;
	private String ort;
	private int plz;
	
	public Adresse(String strasse, int hausnummer, String ort, int plz) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.ort = ort;
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	@Override
	public String toString() {
		return " " + strasse + ", " + hausnummer + ", " + ort + ", " + plz;
	}
	
	
	
}
