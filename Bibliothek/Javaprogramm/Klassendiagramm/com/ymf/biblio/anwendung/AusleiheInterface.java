package Klassendiagramm.com.ymf.biblio.anwendung;


/**
 * Gibt Methoden für Klassen Ausleihe vor. Hierbei werden in der Klassen die entsprechenden Parameter übergeben.
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public interface AusleiheInterface {

	/**
	 * 
	 * @param mediumId
	 * @param kundeId
	 */
	public void ausgabeMedium(long mediumId, long kundeId);

	/**
	 * 
	 * @param mediumId
	 * @param kundeId
	 */
	public void einahmeMedium(long mediumId, long kundeId);

}