package Klassendiagramm.com.ymf.biblio.anwendung;

import Klassendiagramm.com.ymf.biblio.db.KundenVerwaltungDao;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Adresse;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;

import java.util.ArrayList;

/**
 * In dieser Klasse werden die Methoden für das Verwalten der Kunden implementiert. Die Funktionen werde in der entsprechenen Klasse hinzugefügt.
 * Es können Kunden gesucht, hinzugefügt, adressen bearbeitet und anmeldungen gemacht werden.
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:12
 */
public class Verwaltung implements VerwaltungInterface {


    public Verwaltung() {

    }


    /**
     * kundeSuechen Methode mit Parameter nachname mit ArrayList von Kunde
     * @param nachname
     * @return
     */
    public ArrayList<Kunde> kundeSuchen(String nachname) {
        KundenVerwaltungDao kundenVerwaltungDao = new KundenVerwaltungDao();
        //return von  dem nachnamen (Es wird nach nachname gesucht)
        return kundenVerwaltungDao.sucheKunde(nachname);

    }

    /**
     * Adresse Bearbeiten Methode mit Parameter Kunde k
     * @param k
     */
    public void adresseBearbeiten(Kunde k) {
        KundenVerwaltungDao kundenVerwaltungDao = new KundenVerwaltungDao();
        //Uebergabe von k in Objekt Kundenverwaltung.aendereKundenAdresse (Dient zur auswahlt des Kunden beidem die Adresse bearbeitet werden musss)
        kundenVerwaltungDao.aendereKundenAdresse(k);
    }

    /**
     * kundeHinzufuegen Methode mit Parameter Kunde k. Dient der kundenHinzufuegen und übergibt werte
     * @param k
     */
    public void kundeHinzufuegen(Kunde k) {
        KundenVerwaltungDao kundenVerwaltungDao = new KundenVerwaltungDao();
        //Uebergabe des k in Objekt Kundenverwaltung.neuerKunde. (Dient zur erstelleng eines neuen Kunden
        kundenVerwaltungDao.neuerKunde(k);
    }

    /**
     * @param passwort
     * @param username
     */
    public void kundeAnmelden(String passwort, String username) {

    }

    /**
     * @param kundenName
     * @param kundeAdresse
     */
    public void kundeHinzufuegen(Kunde kundenName, Adresse kundeAdresse) {

    }


    /**
     * @param mediumId
     */
    public void mediumEntfernen(long mediumId) {

    }


    public void kundeAnmelden() {

    }


    public void kundeSuechen() {

    }

    public void mediumEntfernen() {

    }

}