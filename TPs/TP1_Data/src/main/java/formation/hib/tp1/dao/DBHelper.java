package formation.hib.tp1.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author D. Thibau
 * Classe minimale qui encapsule le chargement du driver et
 * permet d'obtenir une connexion.
 * Attention pas de gestion de pool de connexion ici.
 */

public class DBHelper {
	static {
		
		//TODO Charger la classe du driver 

	}
	
	public static Connection getConnection() throws SQLException {
		//TODO renvoyer une connection
		return null;
	}
}
