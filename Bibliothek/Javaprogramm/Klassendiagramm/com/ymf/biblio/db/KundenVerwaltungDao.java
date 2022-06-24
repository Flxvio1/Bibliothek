package Klassendiagramm.com.ymf.biblio.db;

import Klassendiagramm.com.ymf.biblio.gemeinsam.Adresse;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

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

            String selectAdressSql = "select idAdresse from adresse " +
                    "where idAdresse=(SELECT max(idAdresse) FROM adresse)";
            PreparedStatement stmnt = con.prepareStatement(selectAdressSql);
            ResultSet rs = stmnt.executeQuery();


            // SQL Builder
            PreparedStatement stmt=con.prepareStatement("update adresse set hausnummer = ?,strasse = ?,ort = ?,plz = ? where idAdresse = ?;");
            stmt.setInt(1,hausnummer);
            stmt.setString(2,strasse);
            stmt.setString(3,ort);
            stmt.setInt(4,plz);
            stmt.setInt(5,id);

            stmt.execute();

            Date d = new Date();
            
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

        //Datenbank verbindung wird aufgerufen
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            //Nimmt die Werte von den verschiedenen Columnen und schreibt sie in die entspechenden Instanzvariabeln
            vorname = kunde.getVorname();
            nachname = kunde.getName();
            email = kunde.getEmail();
            strasse = kunde.getAdresse().getStrasse();
            hausnummer = kunde.getAdresse().getHausnummer();
            ort = kunde.getAdresse().getOrt();
            plz = kunde.getAdresse().getPlz();

            //SQL Befehl um die Adresse in der Adresstabelle hinzuzufügen
            String insertSql ="insert into adresse(strasse,hausnummer,plz,ort) values (?,?,?,?);";

            // Neuer SQLQuery
            PreparedStatement stmnt = con.prepareStatement(insertSql);
            stmnt.setString(1, strasse);
            stmnt.setInt(2, hausnummer);
            stmnt.setInt(3, plz);
            stmnt.setString(4, ort);
            if (!stmnt.execute()) {
                int n = stmnt.getUpdateCount();
                System.out.println(n);
            }
            stmnt.close();

            //Wählt die neuste AdresseID aus
            String selectAdressSql = "select idAdresse from adresse " +
                    "where idAdresse=(SELECT max(idAdresse) FROM adresse)";
            stmnt = con.prepareStatement(selectAdressSql);
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

            insertSql = "insert into kunde (name,vorname,email,adresse_idadresse) values (?,?,?,?);";
            stmnt = con.prepareStatement(insertSql);
            stmnt.setString(1, nachname);
            stmnt.setString(2, vorname);
            stmnt.setString(3, email);
            stmnt.setInt(4, Integer.parseInt(field));
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
            String selectKundeAdresseSql = "select * from kunde k " +
                    "left join adresse a " +
                    "on k.adresse_idAdresse = a.idAdresse";
            PreparedStatement stmt = con.prepareStatement(selectKundeAdresseSql);
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


    }


}