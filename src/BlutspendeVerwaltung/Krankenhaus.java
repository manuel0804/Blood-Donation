package BlutspendeVerwaltung;

import java.util.LinkedList;
import java.util.List;

public class Krankenhaus {
	private List<Blut> listeAnBlut;
	private String name;
	private Adresse adresse;
	
	public Krankenhaus(String name, Adresse adresse) {
		this.name = name;
		this.adresse = adresse;
		listeAnBlut = new LinkedList<>();
	}

	public List<Blut> getListeAnBlut() {
		return listeAnBlut;
	}

	public void setListeAnBlut(List<Blut> listeAnBlut) {
		this.listeAnBlut = listeAnBlut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return   name + ", " + adresse;
	}
	
	
}
