package formation.hib.tp1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author H.Van-eylen
 * classe minimale qui encapsule le chargement du driver et
 * permet d'obtenir une connexion.
 * Attention pas de gestion de pool de connexion ici.
 */

public class DBHelper {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("problème de chargement de driver. L'application est arrêtée :" + e);
			System.exit(1);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/ssii?&serverTimezone=UTC", "root", "root");
		return connection;
	}
}
