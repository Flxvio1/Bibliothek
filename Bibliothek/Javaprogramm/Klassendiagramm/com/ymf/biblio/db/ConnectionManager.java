package Klassendiagramm.com.ymf.biblio.db;


import org.postgresql.core.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Stellt die Verbindung zur datenbank her
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2022 08:27:11
 */
public class ConnectionManager {

	public ConnectionManager(){

	}

	// Über Properties file
	private static Properties props = new Properties();

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			InputStream in = ConnectionManager.class.getResourceAsStream("biblio.properties");
			props.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Class.forName(props.getProperty("Driver"));

		String connection = props.getProperty("connection");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		return DriverManager.getConnection(connection, user, password);
	}

}


//Verbindung zur DB wird hergstellt.
//	public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
//		Connection con;
//			// Für PostgreSql
//		System.out.println("Use PostgreSql");
//			Class.forName("org.postgresql.Driver");
//
//			con = DriverManager.getConnection(
//					"jdbc:postgresql://192.168.40.63:5432/bibliothek?user=lufla&password=password&ssl=false");
//
//  		//Gibt con zurück, damit verbinung von anderen Klassen möglich ist
//		return con;
//
//	}