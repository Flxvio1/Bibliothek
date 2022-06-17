package Klassendiagramm.com.ymf.biblio.gemeinsam;


/**
 * Die Klasse beinhaltet die benötigten Getter und Setter für die Adresse
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class Adresse {

	//Instanzvariablen für die Adresse werden erstellt
	private int hausnummer;
	private String ort;
	private int plz;
	private String strasse;
	private int id;

	public Adresse(){

	}

	/**
	 * Getter für Hausnummer, Ort, PLZ, Strasse und ID
	 * @return
	 */

	public int getHausnummer() {
		return hausnummer;
	}

	public String getOrt() {
		return ort;
	}

	public int getPlz() {
		return plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getId() {
		return id;
	}

	/**
	 * Setzt die verschiedenen werte und gibt diese zurück
	 * @param hausnummer
	 */
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setId(int id) {
		this.id = id;
	}
}