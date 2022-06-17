package Klassendiagramm.com.ymf.biblio.anwendung;


/**
 * Fassade für getAusleihe und getVerwaltung. gibt Methoden für Fassade vor.
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public interface FassadeInterface {

	public AusleiheInterface getAusleihe();

	public VerwaltungInterface getVerwaltung();

}