package BlutspendeVerwaltung;


public class Spender extends Mensch { 
	private Blut blutgruppe;
	private boolean krankheit;

	public Spender(String vorname, String nachname,int alter, Blut blutgruppe, boolean krankheit) {
		super(vorname, nachname, alter);
		this.blutgruppe = blutgruppe;
		this.krankheit = krankheit;
	}

	public Blut getBlutgruppe() {
		return blutgruppe;
	}

	public void setBlutgruppe(Blut blutgruppe) {
		this.blutgruppe = blutgruppe;
	}
	
	public boolean isKrankheit() {
		return krankheit;
	}

	public void setKrankheit(boolean krankheit) {
		this.krankheit = krankheit;
	}

	@Override
	public String toString() {
		return  super.toString() + ", Blutgruppe: " + blutgruppe + ", krank: " + krankheit;
	}

}
