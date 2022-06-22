package Klassendiagramm.com.ymf.biblio.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Stellt die Verbindung zur datenbank her
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class ConnectionManager {

	public ConnectionManager(){

	}

	//Verbindung zur DB wird hergstellt.
	public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
		String serverAuswahl = "MariaDB"; // Auswahl welche DB verwendet werden soll
		Connection con;
			// Für PostgreSql
			System.out.println("Use PostgreSql");
			Class.forName("org.postgresql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.40.63:5432/bibliothek?user=lufla&password=password");

  		//Gibt con zurück, damit verbinung von anderen Klassen möglich ist
		return con;

	}

}