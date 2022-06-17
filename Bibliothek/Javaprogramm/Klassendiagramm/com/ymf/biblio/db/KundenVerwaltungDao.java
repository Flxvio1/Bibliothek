package Klassendiagramm.com.ymf.biblio.db;

import Klassendiagramm.com.ymf.biblio.gemeinsam.Adresse;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

/**
 * Steuert die Datenbank und übergibt die Parameter in die Anwedungsschicht
 *
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class KundenVerwaltungDao implements KundeDao {

    private ConnectionManager connectionMngr;

    public KundenVerwaltungDao() {

    }

    /**
     * Methode um die Adresse der Kunden zu Bearbeiten
     *
     * @param kunde
     * @return
     */
    public int aendereKundenAdresse(Kunde kunde) {
        //Benötigte Variabeln für Sql Befehle
        String strasse;
        int hausnummer;
        String ort;
        int plz;
        int id;

        //Datenbank verbindung wird aufgerufen
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            //Nimmt die Werte von den verschiedenen Columnen und schreibt sie in die entspechenden Instanzvariabeln
            strasse = kunde.getAdresse().getStrasse();
            hausnummer = kunde.getAdresse().getHausnummer();
            ort = kunde.getAdresse().getOrt();
            plz = kunde.getAdresse().getPlz();
            id = kunde.getId();

            //SQL befehl umd die Adresse eines Kunden zu bearbeiten
            PreparedStatement stmnt = con.prepareStatement("update Adresse set Hausnummer = \"" + hausnummer + "\", Strasse = \"" + strasse + "\", Ort = \"" + ort + "\", PLZ = \"" + plz + "\" where idAdresse = \"" + id + "\"");
            stmnt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * Methode um einen neuen Kunden zu erstellen
     *
     * @param kunde
     */
    public void neuerKunde(Kunde kunde) {
        //Inszanzvariabeln für SQL befehl werden festgelegt
        String nachname;
        String vorname;
        String email;
        String strasse;
        int hausnummer;
        String ort;
        int plz;
        int id;

        //Datenbank verbindung wird aufgerufen
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            //Nimmt die Werte von den verschiedenen Columnen und schreibt sie in die entspechenden Instanzvariabeln
            vorname = kunde.getVorname();
            nachname = kunde.getName();
            id = kunde.getAdresse().getId();
            email = kunde.getEmail();
            strasse = kunde.getAdresse().getStrasse();
            hausnummer = kunde.getAdresse().getHausnummer();
            ort = kunde.getAdresse().getOrt();
            plz = kunde.getAdresse().getPlz();

            //SQL Befehl um die Adresse in der Adresstabelle hinzuzufügen
            PreparedStatement stmnt = con.prepareStatement("insert into Adresse (Strasse, Hausnummer, PLZ ,ORT) values ( \"" + strasse + "\",\"" + hausnummer + "\",\"" + plz + "\",\"" + ort + "\")");
            stmnt.execute();

            //Wählt die neuste AdresseID aus
            stmnt = con.prepareStatement("select idAdresse from Adresse where idAdresse=(SELECT max(idAdresse) FROM Adresse)");
            ResultSet rs = stmnt.executeQuery();

            // Konvertiert Ergebnis in String
            String field = null;
            int cols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    field = rs.getString(i);
                }
            }

            //SQL Befehl um den Kunden in der Kundentabelle hinzuzufügen.
            stmnt = con.prepareStatement("insert into Kunde (Name, Vorname, Email ,adresse_idadresse) values ( \"" + nachname + "\",\"" + vorname + "\",\"" + email + "\",\"" + field + "\")");
            stmnt.execute();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Methode damit nach einem Kunden gesucht werden kann
     *
     * @param nachname
     * @return
     */
    public ArrayList<Kunde> sucheKunde(String nachname) {

        //Datenbank verbindung wird aufgerufen
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            //Daten von einem bestimmten Kunden, der mit nachnamen gesucht werden kann, werden mit einem sql befehl ausgeben
            PreparedStatement stmt = con.prepareStatement("select * from bibliothek.Kunde left join bibliothek.Adresse on Kunde.Adresse_idAdresse = Adresse.idAdresse");
            ResultSet rs = stmt.executeQuery();
            // Array list damit es mehrere Kunden mit gleichem nachnamen anzeigen kann
            ArrayList<Kunde> kunden = new ArrayList<>();


            while (rs.next()) {
                //If-Schlaufe sorgt dafür, dass namen nicht ganz ausgeschrieben werden müssen.
                if (rs.getString("name").toLowerCase().contains(nachname.toLowerCase())) {
                    //Werte die für den SQl-Befehl nötig sind werden gesetzt
                    Kunde kunde = new Kunde();
                    kunde.setName(rs.getString("name"));
                    kunde.setVorname(rs.getString("vorname"));
                    kunde.setEmail(rs.getString(("email")));
                    kunde.setId((rs.getInt("idKunde")));

                    Adresse adresse = new Adresse();

                    adresse.setStrasse(rs.getString("Strasse"));
                    adresse.setHausnummer(rs.getInt("Hausnummer"));
                    adresse.setOrt(rs.getString("Ort"));
                    adresse.setPlz(rs.getInt("PLZ"));

                    kunde.setAdresse(adresse);
                    kunden.add(kunde);
                }


            }
            return kunden;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Ergebnis ausgeben1


    }


}