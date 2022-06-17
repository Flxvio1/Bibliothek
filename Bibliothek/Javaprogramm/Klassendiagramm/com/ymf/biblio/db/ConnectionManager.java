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
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.20.10/bibliothek?user=test2&password=InfLb20.admin");
		//Gibt con zurück, damit verbinung von anderen Klassen möglich ist
		return con;
	}

}