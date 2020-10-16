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
			//TODO Charger la classe du driver 
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("problème de chargement de driver. L'application est arrêtée : "+e);
			System.exit(1);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		//TODO renvoyer une connection
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5434/ssii",
				"postgres", "postgres");
		return connection;
	}
}
