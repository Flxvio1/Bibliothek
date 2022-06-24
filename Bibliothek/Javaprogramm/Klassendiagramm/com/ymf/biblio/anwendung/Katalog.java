package Klassendiagramm.com.ymf.biblio.anwendung;


import Klassendiagramm.com.ymf.biblio.db.MediumVerwaltungDao;

/**
 * In dieser Klasse werden die verschiedenen Methoden verwaltet und die Funktion implementiert. Medien können gesucht und Hinzugefügt werden.
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class Katalog {

	public Katalog(){
	}

	/**
	 * Methode um ein Medium hinzuzufügen
	 * @param ean
	 */
	public void mediumHinzufuegen(String ean){
		MediumVerwaltungDao mv = new MediumVerwaltungDao();
		//Uebergabe der ean in Objekt MediumVerwaltungDao

	}

	/**
	 * Mehode um nach einem Medium zu suchen
	 * @param ean
	 */
	public void mediumSuchen(String ean){

	}

}