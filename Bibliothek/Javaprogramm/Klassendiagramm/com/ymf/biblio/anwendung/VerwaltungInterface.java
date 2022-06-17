package Klassendiagramm.com.ymf.biblio.anwendung;


import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;

/**
 * Gibt Methoden für Klassen Verwaltung vor. Hierbei werden in der Klassen die entsprechenden Parameter übergeben.
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:12
 */
public interface VerwaltungInterface {

	/**
	 * Methode erstellen von adresseBearbeten, damit die Klasse Verwaltung es Implementieren muss.
	 * @param k
	 */
	public void adresseBearbeiten(Kunde k);

	/**
	 * Methode erstellen von kundeHinzuguegen, damit die Klasse Verwaltung es Implementieren muss.
	 * @param k
	 */
	public void kundeHinzufuegen(Kunde k);

	/**
	 * Methode erstellen von kundeSuechen, damit die Klasse Verwaltung es Implementieren muss.
	 */
	public void kundeSuechen();


	public void kundeAnmelden();







	public void mediumEntfernen();

}