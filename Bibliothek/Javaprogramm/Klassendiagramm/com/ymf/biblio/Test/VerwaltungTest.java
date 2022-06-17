package Klassendiagramm.com.ymf.biblio.Test;

import Klassendiagramm.com.ymf.biblio.anwendung.Verwaltung;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Adresse;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Beinhaltet die benötigten JUnit testfälle für die Klasse Verwaltung. Es wird geprüft ob Kunden hinzugefügt, gesucht und die Adresse der Kunden bearbeitet werden kann.
 *
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:12
 */

class VerwaltungTest extends Object {

    Verwaltung v = new Verwaltung();

    /**
     * Es wird georüft ob ein Kunde hinzugefügt werden kann.
     */
    @Test
    void kundeHinzufuegen() {
        //Erstellen von Objekten mit definierten Werten
        Kunde k = new Kunde();
        Adresse a = new Adresse();
        k.setName("marjanovic");
        k.setVorname("noel");
        k.setEmail("noelmar@gmail.com");
        a.setStrasse("Grellingerstrasse");
        a.setHausnummer(1);
        a.setOrt("Grellingen");
        a.setPlz(4203);
        k.setAdresse(a);

        v.kundeHinzufuegen(k);

        //Überprüft ob die einträge in der Datenbank hineingeschreiben werden und mit den oben angegebenen Daten übereinstimmen.
        assertTrue(k.getName() == "marjanovic");
        assertTrue(k.getVorname() == "noel");
        assertTrue(k.getEmail() == "noelmar@gmail.com");
        assertTrue(a.getStrasse() == "Grellingerstrasse");
        assertTrue(a.getHausnummer() == 1);
        assertTrue(a.getOrt() == "Grellingen");
        assertTrue(a.getPlz() == 4203);
    }

    /**
     * Es wird georüft ob nach einem Kunden gesucht werden kann.
     */
    @Test
    void kundeSuechen() {
        //Der Kunde Banner wird durch die for-Schleife gesucht.
        for (Kunde k : v.kundeSuchen("Banner")) {
            //Überprüft ob der Name mit Banner übereinstimmt
            assertTrue(k.getName().equals("Banner"));
        }
    }

    /**
     * Es wird georüft ob die Kundenaresse Bearbeitet werden kann.
     */
    @Test
    void adresseBearbeiten() {
        //Erstellen von Objekten mit definierten Werten
        Kunde k = new Kunde();
        Adresse a = new Adresse();
        k.setId(1);
        a.setStrasse("Mauerstrasse");
        a.setHausnummer(1);
        a.setOrt("Basel");
        a.setPlz(4057);
        k.setAdresse(a);

        v.adresseBearbeiten(k);

        //Überprüft ob die einträge in der Datenbank geändert werden und mit den oben angegebenen Daten übereinstimmen.
        assertTrue(a.getStrasse() == "Mauerstrasse");
        assertTrue(a.getHausnummer() == 1);
        assertTrue(a.getOrt() == "Basel");
        assertTrue(a.getPlz() == 4057);
    }
}