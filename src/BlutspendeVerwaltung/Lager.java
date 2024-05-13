package BlutspendeVerwaltung;
import java.util.LinkedList;
import java.util.List;

public class Lager{
	
	private List<Blut> blutListe = new LinkedList<>();

	public List<Blut> getBlutListe() {
		return blutListe;
	}

	public void setBlutListe(List<Blut> blutListe) {
		this.blutListe = blutListe;
	}

	public Lager() {
		blutListe.add(new Blut("A","-", false));
		blutListe.add(new Blut("0","+", true));
		blutListe.add(new Blut("B","-", false));
		blutListe.add(new Blut("A","+", false));
		blutListe.add(new Blut("B","-", true));
		blutListe.add(new Blut("AB","+", false));
		blutListe.add(new Blut("A","-", true));
		blutListe.add(new Blut("0","-", false));
		blutListe.add(new Blut("AB","-", false));
	}

}
