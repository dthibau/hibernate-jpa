package formation.hib.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		Connection connection = null;
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			connection = DBHelper.getConnection();
			ps = connection.prepareStatement(SelectDptStmt);
			ps.setString(1,nom);
			rs = ps.executeQuery();
			int id = 0;
			if (rs.next()){
				id = rs.getInt(ID);
			}
			else throw new DAOException(null,"dao.error.dpt.notfound");
			
			ps = connection.prepareStatement(SelectEmployeFromDptStmt);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employe courant = new Employe();
				courant.setId(rs.getInt(ID));
				courant.setNom(rs.getString(Nom));
				courant.setEmail(rs.getString(Email));
				courant.setTelephone(rs.getString(Tel));
				ret.add(courant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException(e,"dao.error.sql");
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				if ( ps != null ) {
					ps.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	
	public int createEmploye(String nom, String email, String tel) throws DAOException {
		int ret = 0;
		Connection connection = null;
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			connection = DBHelper.getConnection();
			ps = connection.prepareStatement(CreateEmployeStmt);
			ps.setString(1,nom);
			ps.setString(2,email);
			ps.setString(3,tel);
			ps.executeUpdate();
			
			ps = connection.prepareStatement(SelectEmployeByEmailStmt);
			ps.setString(1,email);
			rs = ps.executeQuery();
			if (rs.next()) {
				ret = rs.getInt(ID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException(e,"dao.error.sql");
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				if ( ps != null ) {
					ps.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	public void integrateEmploye(int empId, String dptNom) throws DAOException {
		try {
			Connection connection = DBHelper.getConnection();
			PreparedStatement ps = connection.prepareStatement(SelectDptStmt);
			ps.setString(1,dptNom);
			ResultSet rs = ps.executeQuery();
			int id = 0;
			if (rs.next()){
				id = rs.getInt(ID);
			}
			else throw new DAOException(null,"dao.error.dpt.notfound");
			
			ps = connection.prepareStatement(UpdateEmployeDptStmt);
			ps.setInt(1,id);
			ps.setInt(2,empId);
		    ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException(e,"dao.error.sql");
		}
	}
	
}
