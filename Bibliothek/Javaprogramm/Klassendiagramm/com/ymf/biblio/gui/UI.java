package Klassendiagramm.com.ymf.biblio.gui;

import Klassendiagramm.com.ymf.biblio.anwendung.Verwaltung;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Adresse;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;
import Klassendiagramm.com.ymf.biblio.anwendung.FassadeInterface;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:12
 */
public class UI {
    //Instanzvariablen Initialisieren
    private String nachname;
    private String vorname;
    private String nachname1;
    private String email;
    private String strasse;
    private int hausnummer;
    private String ort;
    private int plz;
    private int id;
    private int auswahleingabe;
    String kundenname;

    //Konstruktor
    public UI() {
        //Aufruf Methode dateneingabe
        datenEingabe();
    }

//Methode um auswahl zu tätigen
    public void datenEingabe() {

        System.out.println("\n Willkommen Zurueck Mitarbeiter! \n Sie koennen folgende Dinge Machen: \n 1) Kundename suechen \t 2) Kunde hinzufuegen \t 3) Kunde adresse aendern \t 4) Programm Schliessen");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ihre Ausahl: ");
        auswahleingabe = sc.nextInt();

        if (auswahleingabe == 1) {
            System.out.println("Sie haben Kundenname suechen ausgewaehlt!");
            //Methodenaufruf von kundeSuechen() in Verwaltung (Package Andwendung)
            kundeSuchen();

        } else if (auswahleingabe == 2) {
            System.out.println("Sie haben Kunde hinzufuegen ausgewaehlt!");
            //Methodenaufruf von kundeHinzufuegen() in Verwaltung (Package Andwendung)
            kundeHinzufuegen();


        } else if (auswahleingabe == 3) {
            System.out.println("Sie haben Kunde adresse aendern ausgewaehlt!");
            //Methodenaufruf von kundeHinzufuegen() in Verwaltung (Package Andwendung)
            adresseBearbeiten();
        } else if (auswahleingabe == 4) {
            System.out.println("Bis Bald!");
            exit(0);
        } else {
            System.out.println("Bitte eingabe erneut machen");
            datenEingabe();
        }

    }

    /**
     * Konsoleneingabe und ausgabe der Werte um einen Kunden hinzuzufügen
     */

    public void kundeHinzufuegen() {
        System.out.print("Bitte Vornamen des neuen Kunden eingeben: ");
        Scanner sc1 = new Scanner(System.in);
        vorname = sc1.next();
        System.out.print("Bitte Nachname des neuen Kunden einngeben: ");
        nachname1 = sc1.next();
        System.out.print("Bitte geben Sie Ihre Email ein: ");
        email = sc1.next();

        System.out.println("Bitte geben Sie ihre Adresse ein");
        System.out.print("Strasse: ");
        strasse = sc1.next();
        System.out.print("Hausnummer: ");
        hausnummer = sc1.nextInt();

        System.out.print("Ort: ");
        ort = sc1.next();
        System.out.print("Plz: ");
        plz = sc1.nextInt();

        Kunde k = new Kunde();
        Adresse a = new Adresse();

        //Setzt die variablen die benötigt werden
        k.setName(nachname1);
        k.setVorname(vorname);
        k.setEmail(email);
        a.setStrasse(strasse);
        a.setHausnummer(hausnummer);
        a.setOrt(ort);
        a.setPlz(plz);
        k.setAdresse(a);

        Verwaltung verwaltung = new Verwaltung();
        verwaltung.kundeHinzufuegen(k);

        datenEingabe();

    }

    /**
     *
     */
    public void kundeSuchen() {
        System.out.print("Bitten geben Sie den Nachnamen des Kunden ein: ");
        Scanner sc1 = new Scanner(System.in);
        nachname = sc1.nextLine();

        Verwaltung verwaltung = new Verwaltung();
// Werte die in SQl ermittelt wurden, werden in der Konsole ausgegeben
        for (Kunde kunde : verwaltung.kundeSuchen(nachname)) {
            System.out.println("\n" + "Vorname: " + kunde.getVorname() + "\n" + "Name: " + kunde.getName() + "\n" + "Email: " + kunde.getEmail() + "\n" + "ID: " + kunde.getId() + "\n" + "Strasse: " + kunde.getAdresse().getStrasse() + "\n" + "Hausnummer: " + kunde.getAdresse().getHausnummer() + "\n" + "PLZ: " + kunde.getAdresse().getPlz() + "\n" + "Ort: " + kunde.getAdresse().getOrt());
        }


        datenEingabe();
    }
    /**
     * Konsoleneingabe und ausgabe der Werte um eine Adresse zu bearbeiten.
     */
    public void adresseBearbeiten() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Geben sie die Kunden ID ein: ");
        id = sc1.nextInt();

        System.out.println("Bitte geben Sie ihre Adresse ein");
        System.out.print("Strasse: ");
        strasse = sc1.next();
        System.out.print("Hausnummer: ");
        hausnummer = sc1.nextInt();


        System.out.print("Ort: ");
        ort = sc1.next();
        System.out.print("Plz: ");
        plz = sc1.nextInt();

        Kunde k = new Kunde();
        Adresse a = new Adresse();

        //Setzt die variablen die benötigt werden
        k.setId(id);
        a.setStrasse(strasse);
        a.setHausnummer(hausnummer);
        a.setOrt(ort);
        a.setPlz(plz);
        k.setAdresse(a);

        Verwaltung verwaltung = new Verwaltung();
        verwaltung.adresseBearbeiten(k);
        datenEingabe();
    }

    /**
     * @param ean
     */
    public void mediumAusgabe(String ean) {

    }

    /**
     * @param mediumId
     */
    public void mediumEinnahme(long mediumId) {

    }

    /**
     * @param mediumId
     */
    public void mediumEntfernen(long mediumId) {

    }

}