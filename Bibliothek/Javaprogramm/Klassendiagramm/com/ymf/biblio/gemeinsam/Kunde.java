package Klassendiagramm.com.ymf.biblio.gemeinsam;


/**
 * Die Klasse beinhaltet die benötigten Getter und Setter für den Kunden
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class Kunde {

	//Instanzvariablen für den Kunden werden erstellt
	private String name;
	private String vorname;
	private Adresse adresse;
	private String email;
	private int id;

	public Kunde(){

	}
	public Kunde(String name, String vorname, Adresse adresse,String email, int id) {
		this.name = name;
		this.vorname = vorname;
		this.adresse = adresse;
		this.email = email;
		this.id = id;
	}

	/**
	 * Getter und setter für Name, vorname, Email, Adresse und id
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
//Konstruktor




	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}