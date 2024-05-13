package BlutspendeVerwaltung;

public class Mensch {
	private int alter;
	private String vorname;
	private String nachname;
	
	public Mensch(String vorname, String nachname, int alter) {
		this.alter = alter;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		return " Name: " + vorname + " " + nachname + ", Alter: "+ alter;
	}

	

}
