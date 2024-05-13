package BlutspendeVerwaltung;
import java.util.LinkedList;
import java.util.List;

public class Verwaltung {
	private Spender spender1 = new Spender("Tom", "Hallo", 18, new Blut("A", "-", false), false);
	private Spender spender2 = new Spender("Anton", "Tschuess",20, new Blut("AB", "+", true), true);
	private Spender spender3 = new Spender("Jeff", "Ade",35, new Blut("0", "-", false), false);
	private List<Spender> listeSpender = new LinkedList<>();
	
	private Mitarbeiter mitarbeiter1 = new Mitarbeiter("Anna", "Bauer",20, 2);
	private Mitarbeiter mitarbeiter2 = new Mitarbeiter("Bill", "Baum",35,5);
	private Mitarbeiter mitarbeiter3 = new Mitarbeiter("Heidi", "Zahn",43, 14);
	private List<Mitarbeiter> listeMitarbeiter = new LinkedList<>();
	
	private Krankenhaus krankenhaus1 = new Krankenhaus("Robert-Bosch-Krankenhaus", new Adresse("Auerbachstraße", 110, "Stuttgart", 70376));
	private Krankenhaus krankenhaus2 = new Krankenhaus("Klinikum Stuttgart", new Adresse("Prießnitzweg", 24,"Stuttgart", 70376 ));
	private Krankenhaus krankenhaus3 = new Krankenhaus("Karl-Olga-Krankenhaus", new Adresse("Hackstraße", 61,"Stuttgart", 70376  ));
	private List<Krankenhaus> listeKrankenhaus = new LinkedList<>();

	public Verwaltung() {
		listeSpender.add(spender1);
		listeSpender.add(spender2);
		listeSpender.add(spender3);
		
		listeMitarbeiter.add(mitarbeiter1);
		listeMitarbeiter.add(mitarbeiter2);
		listeMitarbeiter.add(mitarbeiter3);
		
		listeKrankenhaus.add(krankenhaus1);
		listeKrankenhaus.add(krankenhaus2);
		listeKrankenhaus.add(krankenhaus3);
	}

	public List<Mitarbeiter> getListeMitarbeiter() {
		return listeMitarbeiter;
	}

	public void setListeMitarbeiter(List<Mitarbeiter> listeMitarbeiter) {
		this.listeMitarbeiter = listeMitarbeiter;
	}

	public List<Spender> getListeSpender() {
		return listeSpender;
	}

	public void setListeSpender(List<Spender> liste) {
		this.listeSpender = liste;
	}
	
	public List<Krankenhaus> getListeKrankenhaus() {
		return listeKrankenhaus;
	}

	public void setListeKrankenhaus(List<Krankenhaus> listeKrankenhaus) {
		this.listeKrankenhaus = listeKrankenhaus;
	}

}