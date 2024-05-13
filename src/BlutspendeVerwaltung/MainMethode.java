package BlutspendeVerwaltung;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class MainMethode {
	private static Verwaltung verwaltungSpender = new Verwaltung();
	private static Verwaltung verwaltungMitarbeiter = new Verwaltung();
	private static Verwaltung verwaltungKrankenhaus = new Verwaltung();
	private static Lager lager = new Lager();

	public static void main(String[] args) {
		mainMenue();
	}

	public static void mainMenue() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("<<<< Hauptmenue >>>>");
		System.out.println("1 - Blutspendeverwaltung");
		System.out.println("2 - Mitarbeiterverwaltung");
		System.out.println("3 - Lagerverwaltung");
		System.out.println("0 - Exit");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();

		if (auswahl < 0 || auswahl > 3) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 0,1,2 oder 3 waehlen!");
			mainMenue();
			return;
		}
		mainMenue(auswahl);
	}

	public static int scannerAusgabe() {
		Scanner scanner = new Scanner(System.in);
		int auswahl = 0;
		try {
			auswahl = scanner.nextInt();
		} catch (Exception e) {
			System.err.println("Bitte geben Sie eine Zahl ein!");
			mainMenue();
		}
		return auswahl;
	}
	
	public static void enter() {
		System.out.print(">>> [Enter]");
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
		return;
	}

	public static void mainMenue(int auswahl) {
		switch (auswahl) {
		case 1:
			blutspendeMenue();
			break;

		case 2:
			mitarbeiterMenue();
			break;

		case 3:
			lagerMenue();
			break;

		case 0:
			System.out.println("***Programm beendet***");
			System.exit(0);
		}

	}

	public static void blutspendeMenue() {

		System.out.println("----------------------------------------------------------------");
		System.out.println("<<<< Blutspendeverwaltung >>>>");
		System.out.println("1 - Spender verwalten");
		System.out.println("2 - Blut ans Krankenhaus übergeben");
		System.out.println("3 - Zurueck zum Hauptmenue");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();

		if (auswahl < 1 || auswahl > 3) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 1,2 oder 3 waehlen!");
			blutspendeMenue();
			return;
		}
		blutspendeMenue(auswahl);
		return;
	}

	public static void blutspendeMenue(int auswahl) {
		switch (auswahl) {
		case 1:
			spenderMenue();
			break;

		case 2:
			spendenAnsKrankenhaus();
			break;

		case 3:
			mainMenue();
			break;
		}

	}

	public static void spenderMenue() {

		System.out.println("----------------------------------------------------------------");
		System.out.println("<<<< Spenderverwaltung >>>>");
		System.out.println("1 - Spender anlegen");
		System.out.println("2 - Spender entfernen");
		System.out.println("3 - Spenderliste ausgeben und als Datei speichern");
		System.out.println("4 - Spenderliste sortieren");
		System.out.println("5 - Zurueck zur Blutspendenverwaltung");
		System.out.println("6 - Zurueck zum Hauptmenue");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();

		if (auswahl < 1 || auswahl > 6) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 1,2,3,4,5 oder 6 waehlen!");
			spenderMenue();
			return;
		}
		spendeMenue(auswahl);
		return;
	}

	public static void spendeMenue(int auswahl) {
		switch (auswahl) {
		case 1:
			spenderAnlegenMenue();
			break;
		case 2:
			spenderEntfernen();
			break;
		case 3:
			spenderListe();
			break;
		case 4:
			spenderSortierenMenue();
			break;
		case 5:
			blutspendeMenue();
			break;
		case 6:
			mainMenue();
			break;
		}
	}

	public static void spenderAnlegenMenue() {

		System.out.println("----------------------------------------------------------------");
		System.out.println("<<<< Spender anlegen >>>>");
		System.out.println("1 - Spender hinzufuegen ohne Ausweis");
		System.out.println("2 - Spender hinzufuegen mit Ausweis");
		System.out.println("3 - Zurueck zum Spendermenue");
		System.out.println("4 - Zurueck zum Hauptmenue");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();

		if (auswahl < 1 || auswahl > 4) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 1,2,3 oder 4 waehlen!");
			spenderAnlegenMenue();
			return;
		}
		spenderAnlegenMenue(auswahl);
		return;
	}

	public static void spenderAnlegenMenue(int auswahl) {
		switch (auswahl) {
		case 1:
			spenderHinzufuegen();
			break;
		case 2:
			ausweisErstellen();
			break;
		case 3:
			spenderMenue();
			break;
		case 4:
			mainMenue();
			break;
		}
	}

	public static void spenderHinzufuegen() {
		Scanner daten = new Scanner(System.in);
		System.out.println("Wie lautet der Vorname?");
		String vorname = daten.nextLine();
		System.out.println("Wie lautet der Nachname?");
		String nachname = daten.nextLine();
		System.out.println("Was ist die Blutgruppe? (AB/A/B/0)");
		String blut = daten.nextLine().toUpperCase();
		if (!(blut.equals("0") | blut.equals("A") | blut.equals("AB") | blut.equals("B"))) {
			System.err.println("Eingabe ist keine Blutgruppe!");
			spenderHinzufuegen();
			return;
		}
		System.out.println("Was ist der Rhesusfaktor? (+/-)");
		String rhesusfaktor = daten.nextLine();
		if (!(rhesusfaktor.equals("+") | rhesusfaktor.equals("-"))) {
			System.err.println("Eingabe ist kein Rhesusfaktor!");
			spenderHinzufuegen();
			return;
		}
		System.out.println("Wie alt ist der Spender? (bitte 18+)");
		int alter;
		try {
			alter = daten.nextInt();
		} catch (Exception e) {
			System.err.println("Geben Sie eine Zahl ein!");
			spenderHinzufuegen();
			return;
		}
		if (alter < 18) {
			System.err.println("Spender muessen 18 oder aelter sein!");
			spenderHinzufuegen();
			return;
		}

		try {
			File datei = new File("Krankheiten.txt");
			System.out.println("Hat der Spender eine der folgenden Krankheiten? (y/n)");
			Scanner scan = new Scanner(datei);
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			System.out.print("Auswahl >>> ");
		} catch (FileNotFoundException e) {
			System.err.println("Datei nicht vorhanden");
			System.out.println("Hat der Spender eine Krankheit? (y/n)");
		}
		boolean krankheit = true;
		Scanner scanner = new Scanner(System.in);
		String eingabe = scanner.nextLine();
		if (eingabe.equals("y")) {
			krankheit = true;
		} else if (eingabe.equals("n")) {
			krankheit = false;
		} else {
			System.err.println("Falsche Eingabe!");
			spenderHinzufuegen();
			return;
		}

		verwaltungSpender.getListeSpender()
				.add(new Spender(vorname, nachname, alter, new Blut(blut, rhesusfaktor, krankheit), krankheit));
		System.out.println("Spender erfolgreich angelegt (ohne Ausweis):");
		for (int j = 0; j < verwaltungSpender.getListeSpender().size(); j++) {
			System.out.println("Spender " + (j + 1) + " | " + verwaltungSpender.getListeSpender().get(j).toString());
		}
		enter();
		spenderAnlegenMenue();
		return;
	}

	public static void ausweisErstellen() {
		Scanner daten = new Scanner(System.in);
		System.out.println("Wie lautet der Vorname?");
		String vorname = daten.nextLine();
		System.out.println("Wie lautet der Nachname?");
		String nachname = daten.nextLine();
		System.out.println("Was ist die Blutgruppe? (AB/A/B/0)");
		String blut = daten.nextLine().toUpperCase();
		if (!(blut.equals("0") | blut.equals("A") | blut.equals("AB") | blut.equals("B"))) {
			System.err.println("Eingabe ist keine Blutgruppe!");
			ausweisErstellen();
			return;
		}
		System.out.println("Was ist der Rhesusfaktor? (+/-)");
		String rhesusfaktor = daten.nextLine();
		if (!(rhesusfaktor.equals("+") | rhesusfaktor.equals("-"))) {
			System.err.println("Eingabe ist kein Rhesusfaktor!");
			ausweisErstellen();
			return;
		}

		System.out.println("Wie alt ist der Spender? (bitte 18+)");
		int alter;
		try {
			alter = daten.nextInt();
		} catch (Exception e) {
			System.err.println("Geben Sie eine Zahl ein!");
			ausweisErstellen();
			return;
		}
		if (alter < 18) {
			System.err.println("Spender muessen 18 oder aelter sein!");
			ausweisErstellen();
			return;
		}
		try {
			File datei = new File("Krankheiten.txt");
			System.out.println("Hat der Spender eine der folgenden Krankheiten? (y/n)");
			Scanner scan = new Scanner(datei);
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.err.println("Datei nicht vorhanden!");
			System.out.println("Hat der Spender eine Krankheit? (y/n)");
		}
		boolean krankheit = true;
		Scanner scanner = new Scanner(System.in);
		String eingabe = scanner.nextLine();
		if (eingabe.equals("y")) {
			krankheit = true;
		} else if (eingabe.equals("n")) {
			krankheit = false;
		} else {
			System.err.println("Falsche Eingabe!");
			spenderHinzufuegen();
			return;
		}

		verwaltungSpender.getListeSpender()
				.add(new Spender(vorname, nachname, alter, new Blut(blut, rhesusfaktor, krankheit), krankheit));

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(vorname + " " + nachname + ".txt"));
			writer.write("---------------------------------" + "\n");
			writer.write("| Name: " + vorname + " " + nachname + "\n");
			writer.write("| Alter: " + alter + "\n");
			writer.write("| Blutgruppe: " + blut + rhesusfaktor + "\n");
			writer.write("| Krankheit: " + krankheit + "\n");
			writer.write("---------------------------------");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Spender erfolgreich angelegt - Ausweis wurde erfolgreich erstellt:");
		for (int j = 0; j < verwaltungSpender.getListeSpender().size(); j++) {
			System.out.println("Spender " + (j + 1) + " | " + verwaltungSpender.getListeSpender().get(j).toString());
		}
		enter();
		spenderAnlegenMenue();
		return;
	}

	public static void spenderEntfernen() {
		if (verwaltungSpender.getListeSpender().isEmpty()) {
			System.err.println("Liste ist leer!");
			System.err.println("Bitte erst einen Spender anlegen!");
			spenderMenue();
			return;
		} else {
			System.out.println("> aktuelle Spender: ");
			for (int j = 0; j < verwaltungSpender.getListeSpender().size(); j++) {
				System.out
						.println("Spender " + (j + 1) + " | " + verwaltungSpender.getListeSpender().get(j).toString());
			}

			System.out.println("> Welchen Spender möchten sie entfernen? (Nummer eingeben)");
			System.out.print("Auswahl >>> ");
			int auswahl = scannerAusgabe();

			for (int i = 0; i < verwaltungSpender.getListeSpender().size(); i++) {
				if (auswahl - 1 == i) {
					verwaltungSpender.getListeSpender().remove(i);
				} else if (auswahl > verwaltungSpender.getListeSpender().size() || auswahl < 1) {
					System.err.println("Auswahl nicht vorhanden");
					spenderEntfernen();
					return;
				}
			}
			System.out.println("Spender " + auswahl + " wurde entfernt - neue Liste:");
			for (int j = 0; j < verwaltungSpender.getListeSpender().size(); j++) {
				System.out
						.println("Spender " + (j + 1) + " | " + verwaltungSpender.getListeSpender().get(j).toString());
			}
			enter();
			spenderAnlegenMenue();
			return;
		}
	}

	public static void spenderListe() {
		if (verwaltungSpender.getListeSpender().isEmpty()) {
			System.err.println("Liste ist leer!");
			System.err.println("Bitte erst einen Spender anlegen!");
			spenderMenue();
			return;
		} else {
			int counter = 1;
			for (int j = 0; j < verwaltungSpender.getListeSpender().size(); j++) {
				System.out
						.println("Spender " + counter + " | " + verwaltungSpender.getListeSpender().get(j).toString());
				counter++;
			}
			String string = "";
			for (int i = 0; i < verwaltungSpender.getListeSpender().size(); i++) {
				string = string + verwaltungSpender.getListeSpender().get(i).toString() + "\n";
			}
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("Spender.txt"));
				writer.write("Spenderliste: \n");
				writer.write(string);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Datei mit Spenderliste wurde erfolgreich erstellt!");
		enter();
		spenderMenue();;
		return;
	}

	public static void spenderSortierenMenue() {
		System.out.println("Wonach sollen die Spender sortiert werden?");
		System.out.println("1 - Vorname"); 
		System.out.println("2 - Nachname");
		System.out.println("3 - Alter");
		System.out.println("4 - Blutgruppe");
		System.out.println("5 - Krankheit");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();
		if (auswahl < 1 || auswahl > 5) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 1,2,3,4, oder 5 waehlen!");
			spenderMenue();
			return;
		}
		spenderSortierenMenue(auswahl);
		return;
	}

	public static void spenderSortierenMenue(int auswahl) {
		if (verwaltungSpender.getListeSpender().isEmpty()) {
			System.err.println("Liste ist leer!");
			System.err.println("Bitte erst einen Spender anlegen!");
			spenderMenue();
			return;
		} else {
			Comparator<Spender> comp = null;

			switch (auswahl) {
			case 1:
				comp = new CompVorname();
				break;
			case 2:
				comp = new CompNachname();
				break;
			case 3:
				comp = new CompAlter();
				break;
			case 4:
				comp = new CompBlutgruppe();
				break;
			case 5:
				comp = new CompKrankheit();
				break;
			}
			Collections.sort(verwaltungSpender.getListeSpender(), comp);
			int counter = 1;
			for (Spender s : verwaltungSpender.getListeSpender()) {
				System.out.println("Spender " + counter + " | " + s);
				counter++;
			}
			enter();
			spenderMenue();
			return;
		}
	}

	public static void spendenAnsKrankenhaus() {
		if (lager.getBlutListe().isEmpty()) {
			System.err.println("Lager ist leer!");
			System.out.println("Wollen sie direkt zum Blut abnehmen? (y/n)");
			System.out.print("Auswahl >>> ");
			Scanner scanner = new Scanner(System.in);
			String auswahl = scanner.nextLine();
			if (!(auswahl.equals("y") | auswahl.equals("n"))) {
				System.err.println("Falsche Eingabe!");
				spendenAnsKrankenhaus();
				return;
			}
			switch (auswahl) {
			case "y":
				abnehmenVonBlut();
				break;
			case "n":
				blutspendeMenue();
				break;
			}
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("An welches Krankenhaus soll Blut gespendet werden? (Nummer eingeben)");
			for (int i = 0; i < verwaltungKrankenhaus.getListeKrankenhaus().size(); i++) {
				System.out
						.println("Krankenhaus " + (i + 1) + ": " + verwaltungKrankenhaus.getListeKrankenhaus().get(i));
			}
			System.out.print("Auswahl >>> ");
			int auswahl = scannerAusgabe();

			if (auswahl < 1 || auswahl > verwaltungKrankenhaus.getListeKrankenhaus().size()) {
				System.err.println("Ungueltige Eingabe");
				spendenAnsKrankenhaus();
				return;
			}

			Krankenhaus temp = verwaltungKrankenhaus.getListeKrankenhaus().get(auswahl - 1);

			System.out.println("Soll eine bestimmte Blutgruppe gespendet werden? (y/n)");
			System.out.print("Auswahl >>> ");
			Scanner scanner = new Scanner(System.in);
			String auswahl2 = scanner.nextLine();
			if (!(auswahl2.equals("y") | auswahl2.equals("n"))) {
				System.err.println("Falsche Eingabe!");
				spendenAnsKrankenhaus();
				return;
			}

			boolean booo = true;
			if (auswahl2.equals("y")) {
				booo = true;
			} else if (auswahl2.equals("n")) {
				booo = false;
			} else {
				System.err.println("Falsche Eingabe!");
				return;
			}

			if (booo == false) {
				System.out.println(
						"Wie viele Blutspenden sollen an das Krankenhaus uebergeben werden? (Nummer eingeben)");
				System.out.print("Auswahl >>> ");
				int anzahl = scannerAusgabe();

				if (anzahl > lager.getBlutListe().size()) {
					System.err.println(
							"So viele Spenden sind nicht im Lager - aktuelle Anzahl: " + lager.getBlutListe().size());
					spendenAnsKrankenhaus();
					return;
				} else {
					for (int i = 0; i < anzahl; i++) {
						temp.getListeAnBlut().add(lager.getBlutListe().get(0));
						lager.getBlutListe().remove(0);
					}
				}

				System.out.println(
						"Es wurden erfolgreich " + anzahl + " Spenden an das " + temp.getName() + " uebergeben!");
				enter();
				blutspendeMenue();
				return; 
			}

			else {
				System.out.println("Welche Blutgruppe soll uebergeben werden? (0,A,B,AB)");
				String auswahl3 = scanner.next();
				String blutgruppe = auswahl3.toUpperCase();
				if (!(blutgruppe.equals("0") | blutgruppe.equals("A") | blutgruppe.equals("B")
						| blutgruppe.equals("AB"))) {
					System.err.println("Falsche Eingabe!");
					spendenAnsKrankenhaus();
					return;
				}

				for (int i = 0; i < lager.getBlutListe().size(); i++) {
					if (blutgruppe.equals(lager.getBlutListe().get(i).getBlutgruppe())) {
						temp.getListeAnBlut().add(lager.getBlutListe().get(i));
						lager.getBlutListe().remove(i);
						System.out.println("Eine Spende mit der Blutgruppe " + blutgruppe + " wurde erfolgreich an das "
								+ temp.getName() + " uebergeben!");
						enter();
						blutspendeMenue();
						return;
					}
				}
				System.err.println("Die Blutgruppe " + blutgruppe + " ist aktuell leider nicht vorhanden im Lager!");
				enter();
				blutspendeMenue();
				return;
			}
		}

	}

	public static void mitarbeiterMenue() {

		System.out.println("----------------------------------------------------------------");
		System.out.println("<<<< Mitarbeiterverwaltung >>>>");
		System.out.println("1 - Mitarbeiter hinzufügen");
		System.out.println("2 - Mitarbeiter entfernen");
		System.out.println("3 - Mitarbeiterliste");
		System.out.println("4 - Blut abnehmen");
		System.out.println("5 - Zurueck zum Hauptmenue");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();

		if (auswahl < 1 || auswahl > 5) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 1,2,3,4 oder 5 waehlen!");
			mitarbeiterMenue();
			return;
		}
		mitarbeiterMenue(auswahl);
		return;
	}

	public static void mitarbeiterMenue(int auswahl) {
		switch (auswahl) {
		case 1:
			mitarbeiterAnlegen();
			break;
		case 2:
			mitarbeiterEntfernen();
			break;
		case 3:
			mitarbeiterAusgeben();
			break;
		case 4:
			abnehmenVonBlut();
			break;
		case 5:
			mainMenue();
		}
	}

	public static void mitarbeiterAnlegen() {
		Scanner daten = new Scanner(System.in);
		System.out.println("Wie lautet der Vorname?");
		String vorname = daten.nextLine();
		System.out.println("Wie lautet der Nachname?");
		String nachname = daten.nextLine();
		System.out.println("Wie alt ist der Mitarbeiter? (bitte 16+)");
		int alter;
		try {
			alter = daten.nextInt();
		} catch (Exception e) {
			System.err.println("Geben Sie eine Zahl ein!");
			mitarbeiterAnlegen();
			return;
		}
		if (alter < 16) {
			System.err.println("Mitarbeiter muessen 16 oder aelter sein!");
			mitarbeiterAnlegen();
			return;
		}
		System.out.println("Wie viele Jahre ist er im Dienst?");
		int dienstjahre;

		try {
			dienstjahre = daten.nextInt();
		} catch (Exception e) {
			System.err.println("Geben Sie eine Zahl ein!");
			mitarbeiterAnlegen();
			return;
		}
		if (dienstjahre < 0) {
			System.out.println("Dienstjahre koennen nicht negativ sein!");
			mitarbeiterAnlegen();
			return;
		}
		if (alter - dienstjahre < 16) {
			System.err.println("Mitarbeiter waere bei Dienstantritt nicht 16 gewesen!");
			mitarbeiterAnlegen();
			return;
		}

		verwaltungMitarbeiter.getListeMitarbeiter().add(new Mitarbeiter(vorname, nachname, alter, dienstjahre));
		System.out.println("Mitarbeiter erfolgreich angelegt:");
		for (int j = 0; j < verwaltungMitarbeiter.getListeMitarbeiter().size(); j++) {
			System.out.println(
					"Mitarbeiter " + (j + 1) + " | " + verwaltungMitarbeiter.getListeMitarbeiter().get(j).toString());
		}
		enter();
		mitarbeiterMenue();
		return;
	}

	public static void mitarbeiterEntfernen() {

		if (verwaltungMitarbeiter.getListeMitarbeiter().isEmpty()) {
			System.err.println("Liste ist leer!");
			System.err.println("Bitte zuerst einen Mitarbeiter anlegen!");
			mitarbeiterMenue();
			return;
		} else {
			System.out.println("> aktuelle Mitarbeiter: ");
			for (int j = 0; j < verwaltungMitarbeiter.getListeMitarbeiter().size(); j++) {
				System.out.println("Mitarbeiter " + (j + 1) + " | "
						+ verwaltungMitarbeiter.getListeMitarbeiter().get(j).toString());
			}

			System.out.println("> Welchen Mitarbeiter möchten sie entfernen? (Nummer eingeben)");
			System.out.print("Auswahl >>> ");
			int auswahl = scannerAusgabe();

			for (int i = 0; i < verwaltungMitarbeiter.getListeMitarbeiter().size(); i++) {
				if (auswahl - 1 == i) {
					verwaltungMitarbeiter.getListeMitarbeiter().remove(i);
				} else if (auswahl > verwaltungMitarbeiter.getListeMitarbeiter().size() || auswahl < 1) {
					System.err.println("Auswahl nicht vorhanden!");
					mitarbeiterEntfernen();
					return;
				}
			}
			System.out.println("Mitarbeiter " + auswahl + " wurde entfernt - neue Liste:");
			for (int j = 0; j < verwaltungMitarbeiter.getListeMitarbeiter().size(); j++) {
				System.out.println("Mitarbeiter " + (j + 1) + " | "
						+ verwaltungMitarbeiter.getListeMitarbeiter().get(j).toString());
			}
			enter();
			mitarbeiterMenue();
			return;
		}
	}

	public static void mitarbeiterAusgeben() {
		if (verwaltungMitarbeiter.getListeMitarbeiter().isEmpty()) {
			System.err.println("Liste ist leer!");
			System.err.println("Bitte zuerst einen Mitarbeiter anlegen!");
			mitarbeiterMenue();
			return;
		} else {
			for (int j = 0; j < verwaltungMitarbeiter.getListeMitarbeiter().size(); j++) {
				System.out.println("Mitarbeiter " + (j + 1) + " | "
						+ verwaltungMitarbeiter.getListeMitarbeiter().get(j).toString());
			}
			enter();
			mitarbeiterMenue();
			return;

		}
	}

	public static void abnehmenVonBlut() {

		if (verwaltungMitarbeiter.getListeMitarbeiter().isEmpty()) {
			System.err.println("Kein Mitarbeiter vorhanden zum Blutabnehmen!");
			System.err.println("Bitte zuerst einen Mitarbeiter anlegen!");
			mitarbeiterMenue();
			return;
		} else if (verwaltungSpender.getListeSpender().isEmpty()) {
			System.err.println("Kein Spender vorhanden zum Blutabnehmen!");
			System.out.println("Wollen sie direkt einen Spender anlegen? (y/n)");
			System.out.print("Auswahl >>> ");
			Scanner scanner = new Scanner(System.in);
			String auswahl = scanner.nextLine();
			if (!(auswahl.equals("y") | auswahl.equals("n"))) {
				System.err.println("Falsche Eingabe!");
				abnehmenVonBlut();
				return;
			}
			switch (auswahl) {
			case "y":
				spenderHinzufuegen();
				break;
			case "n":
				mitarbeiterMenue();
				break;
			}
		} else {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Welcher Mitarbeiter soll das Blut abnehmen? ");
			for (int i = 0; i < verwaltungMitarbeiter.getListeMitarbeiter().size(); i++) {
				System.out.println("Mitarbeiter " + (i + 1) + " | "
						+ verwaltungMitarbeiter.getListeMitarbeiter().get(i).toString());
			}
			System.out.print("Auswahl >>> ");
			int auswahl = scannerAusgabe() - 1;

			if (auswahl < 0 || auswahl > verwaltungMitarbeiter.getListeMitarbeiter().size()) {
				System.err.println("Ungueltige Auswahl! Bitte zwischen 1 und "
						+ verwaltungMitarbeiter.getListeMitarbeiter().size() + " waehlen!");
				abnehmenVonBlut();
				return;
			}
			System.out.println("----------------------------------------------------------------");
			System.out.println("Von welchem Spender soll Blut abgenommen werden?");
			for (int i = 0; i < verwaltungSpender.getListeSpender().size(); i++) {
				System.out
						.println("Spender " + (i + 1) + " | " + verwaltungSpender.getListeSpender().get(i).toString());
			}
			System.out.print("Auswahl >>> ");
			int auswahl2 = scannerAusgabe() - 1;

			if (auswahl2 < 0 || auswahl2 > verwaltungSpender.getListeSpender().size()) {
				System.err.println("Ungueltige Auswahl! Bitte zwischen 1 und "
						+ verwaltungSpender.getListeSpender().size() + " waehlen!");
				abnehmenVonBlut();
				return;
			}
			verwaltungMitarbeiter.getListeMitarbeiter().get(auswahl)
					.blutabnehmen(verwaltungSpender.getListeSpender().get(auswahl2).getBlutgruppe(), lager);
			enter();
			mitarbeiterMenue();
			return; 
		}
	}

	public static void lagerMenue() {

		System.out.println("----------------------------------------------------------------");
		System.out.println("<<<< Lagerverwaltung >>>>");
		System.out.println("1 - krankes Blut aussortieren");
		System.out.println("2 - sortieren nach Blutgruppe und Datei erstellen");
		System.out.println("3 - Lager ausgeben");
		System.out.println("4 - Zurueck zum Hauptmenue");
		System.out.print("Auswahl >>> ");
		int auswahl = scannerAusgabe();

		if (auswahl < 1 || auswahl > 4) {
			System.err.println("Ungueltige Auswahl! Bitte zwischen 1,2,3 oder 4 waehlen!");
			lagerMenue();
			return;
		}
		lagerMenue(auswahl);
	}

	public static void lagerMenue(int auswahl) {
		switch (auswahl) {
		case 1:
			aussortieren();
			break;
		case 2:
			sortieren();
			break;
		case 3:
			lagerAusgeben();
			break;
		case 4:
			mainMenue();
			break;
		}
	}

	public static void aussortieren() {
		if (lager.getBlutListe().isEmpty()) {
			zurBlutabnahme();
			return;
		} else {
			for (int j = 0; j < lager.getBlutListe().size(); j++) {
				if (lager.getBlutListe().get(j).isKrank() == true) {
					lager.getBlutListe().remove(j);
				}
			}
		}
		System.out.println("Blut mit Krankheit wurde entfernt!");
		enter();
		lagerMenue();
		return;
	}

	private static void sortieren() {
		if (lager.getBlutListe().isEmpty()) {
			zurBlutabnahme();
			return;
		} else {
			Collections.sort(lager.getBlutListe());
			String string = "";
			int counter = 0;
			for (int j = 0; j < lager.getBlutListe().size(); j++) {
				System.out.println(lager.getBlutListe().get(j).toString());
				counter++;
			}
			for (int i = 0; i < lager.getBlutListe().size(); i++) {
				string = string + lager.getBlutListe().get(i).toString() + "\n";
			}
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("Blut.txt"));
				writer.write("Sortierte Blutausgabe: \n");
				writer.write(string);
				writer.write("Gesamt: " + counter + " Spenden");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Datei mit Lagerinhalt wurde erfolgreich erstellt!");
			enter();
			lagerMenue();
			return;
		}
	}

	public static void lagerAusgeben() {
		if (lager.getBlutListe().isEmpty()) {
			zurBlutabnahme();
			return;
		} else {
			int counter1 = 0;
			int counter2 = 0;
			int counter3 = 0;
			int counter4 = 0;
			int counter5 = 0;
			int counter6 = 0;
			int counter7 = 0;
			int counter8 = 0;
			for (int j = 0; j < lager.getBlutListe().size(); j++) {
				if (lager.getBlutListe().get(j).getBlutgruppe() == "A"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "+") {
					counter1++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "A"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "-") {
					counter2++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "B"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "+") {
					counter3++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "B"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "-") {
					counter4++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "0"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "+") {
					counter5++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "0"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "-") {
					counter6++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "AB"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "+") {
					counter7++;
				} else if (lager.getBlutListe().get(j).getBlutgruppe() == "AB"
						&& lager.getBlutListe().get(j).getRhesusfaktor() == "-") {
					counter8++;
				}
			}

			if (counter1 == 0) {
				System.out.print("");
			} else {
				System.out.println(" A+ : " + counter1 + "x");
			}
			if (counter2 == 0) {
				System.out.print("");
			} else {
				System.out.println(" A- : " + counter2 + "x");
			}
			if (counter3 == 0) {
				System.out.print("");
			} else {
				System.out.println(" B+ : " + counter3 + "x");
			}
			if (counter4 == 0) {
				System.out.print("");
			} else {
				System.out.println(" B- : " + counter4 + "x");
			}
			if (counter5 == 0) {
				System.out.print("");
			} else {
				System.out.println(" 0+ : " + counter5 + "x");
			}
			if (counter6 == 0) {
				System.out.print("");
			} else {
				System.out.println(" 0- : " + counter6 + "x");
			}
			if (counter7 == 0) {
				System.out.print("");
			} else {
				System.out.println("AB+ : " + counter7 + "x");
			}
			if (counter8 == 0) {
				System.out.print("");
			} else {
				System.out.println("AB- : " + counter8 + "x");
			}
			int gesamtanzahl = counter1 + counter2 + counter3 + counter4 + counter5 + counter6 + counter7 + counter8;
			System.out.println("Gesamtanzahl an Spenden: " + gesamtanzahl);
			enter();
			lagerMenue();
			return;
		}
	}

	public static void zurBlutabnahme() {
		System.err.println("Lager ist leer!");
		System.out.println("Wollen sie direkt zum Blut abnehmen? (y/n)");
		System.out.print("Auswahl >>> ");
		Scanner scanner = new Scanner(System.in);
		String auswahl = scanner.nextLine();
		if (!(auswahl.equals("y") | auswahl.equals("n"))) {
			System.err.println("Falsche Eingabe!");
			abnehmenVonBlut();
			return;
		}
		switch (auswahl) {
		case "y":
			abnehmenVonBlut();
			break;
		case "n":
			lagerMenue();
			break;
		}
	}
}