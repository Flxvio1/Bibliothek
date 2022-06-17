package Klassendiagramm.com.ymf.biblio.anwendung;


/**
 * Die Fassade Implementiert die verschiedenen Interfaces und geterMethoden der verschiedenen Klassen
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class Fassade implements FassadeInterface {

	public Fassade(){

	}
	public AusleiheInterface getAusleihe(String ean){
		return null;
	}
	@Override
	public AusleiheInterface getAusleihe() {return null;}

	public VerwaltungInterface getVerwaltung(){
		return null;
	}

}