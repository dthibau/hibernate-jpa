package formation.hib.tp1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import formation.hib.tp1.metier.Employe;

/**
 * 
 * @author H. Van-eylen
 * Cette classe est chargée de gérer le mapping O/R pour les département et les employés.
 *
 */

public class DptDAO {
	private static String SelectDptStmt = "select * from tdpt where nom = ?";
	private static String SelectEmployeFromDptStmt = "select * from temploye where idDpt = ?";
	private static String CreateEmployeStmt = "insert into temploye(nom,email,tel) values(?,?,?)";
	private static String SelectEmployeByEmailStmt = "select * from temploye where email = ?";
	private static String UpdateEmployeDptStmt = "update temploye set idDpt = ? where id = ?";
	
	private static String ID = "ID";
	private static String Nom = "nom";
	private static String Email = "email";
	private static String Tel = "tel";
	
	public List<Employe> getEmployesDe(String nom) throws DAOException {
		List<Employe> ret = new ArrayList<Employe>();
		try {
			Connection connection = DBHelper.getConnection();
			//TODO récupérer l'ID du département
			
			// si on ne trouve pas de dpt, c'est une erreur !

			
			//TODO récupérer les employés dont l'id de Département a été récupéré
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException(e,"dao.error.sql");
		}
		
		return ret;
	}
	
	
	public int createEmploye(String nom, String email, String tel) throws DAOException {
		int ret = 0;
		try {
			Connection connection = DBHelper.getConnection();
			//TODO créer le nouvel employé

			
			//TODO récupérer la clé pour la renvoyer (utiliser l'email comme identifiant)
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException(e,"dao.error.sql");
		}
		
		return ret;
	}
	
	public void integrateEmploye(int empId, String dptNom) throws DAOException {
		try {
			//TODO récupérer l'id du département
			Connection connection = DBHelper.getConnection();
			
			
			//TODO effectuer l'update permettant de donner l'IdDpt de l'employé
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException(e,"dao.error.sql");
		}
	}
	
}
