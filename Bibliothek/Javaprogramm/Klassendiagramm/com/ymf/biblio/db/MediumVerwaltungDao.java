package Klassendiagramm.com.ymf.biblio.db;


import Klassendiagramm.com.ymf.biblio.gemeinsam.Medium;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:12
 */
public class MediumVerwaltungDao {

	private ConnectionManager connectionMngr;

	public MediumVerwaltungDao(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param medium
	 */
	public void mediumEntfernen(Medium medium){

	}

	/**
	 * 
	 * @param medium
	 */
	public void mediumHinzufuegen(Medium medium){
		String titel;
		String autor;
		String genre;
		int kunde_idkunde = 2;
		int standort_idstandort = (int) (Math.random()*6+1);
		int medientyp_idmedientyp = (int) (Math.random()*4+1);

		//Datenbank verbindung wird aufgerufen
		Connection con = null;
		try {
			// Connection to DB
			con = ConnectionManager.getConnection();
			titel = medium.getTitel();
			autor = medium.getAutor();
			genre = medium.getGenre();

			//SQL Befehl um die Adresse in der Adresstabelle hinzuzufügen
			String insertSql = "insert into Medium(titel, autor, genre,kunde_idkunde,standort_idstandort,medientyp_idmedientyp) values (?, ?, ?, ?, ?, ?);";

			// Neuer SQLQuery
			PreparedStatement stmnt = con.prepareStatement(insertSql);
			stmnt.setString(1, titel);
			stmnt.setString(2, autor);
			stmnt.setString(3, genre);
			stmnt.setInt(4, kunde_idkunde);
			stmnt.setInt(5, standort_idstandort);
			stmnt.setInt(6, medientyp_idmedientyp);

			if (!stmnt.execute()) {
				int n = stmnt.getUpdateCount();
				System.out.println(n);
			}
			stmnt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}