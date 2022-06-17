package Klassendiagramm.com.ymf.biblio.db;

import Klassendiagramm.com.ymf.biblio.gemeinsam.Adresse;
import Klassendiagramm.com.ymf.biblio.gemeinsam.Kunde;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Schreibt die Methoden für die KundenVerwaltungDao vor. Desweiteren werden die Parameter vorgegeben.
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public interface KundeDao {


	/**
	 * Methode Kundenadresse wird vorgegeben
	 * @param kunde
	 * @return
	 */
	public int aendereKundenAdresse(Kunde kunde);

	/**
	 * methode neuerKunde wird vorgegeben
	 * @param kunde
	 */
	public void neuerKunde(Kunde kunde);

	/**
	 * Methode sucheKunde wird vorgegeben
	 * @param name
	 * @return
	 */
	public ArrayList<Kunde> sucheKunde(String name) throws SQLException, ClassNotFoundException;





}