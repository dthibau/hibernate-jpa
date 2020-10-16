package formation.hib.tp3.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import formation.hib.tp3.metier.Departement;
import formation.hib.tp3.metier.Employe;
import formation.hib.tp3.metier.Genre;

public class DptDAO {
	private static String SelectDptHQL = "from Departement d where d.nom like :nomSearch";
	private static String Nom = "nomSearch";
	
	public Set<Employe> getEmployesDe(String nom) throws DAOException {
		Set<Employe> ret = null;
		EntityManager entityManager = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = null;

		try {

			// A COMPLETER
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (PersistenceException he) {
					he.printStackTrace();
					throw new DAOException(he,"dao.error.jpa");
				}
			}
			e.printStackTrace();
			throw new DAOException(e,"dao.error.jpa");
		} finally {
			try {
				entityManager.close();
			} catch (PersistenceException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.jpa");
			}
		}

		return ret;
	}

	public Employe createEmploye(String nom, String email, String tel, Date entree, Genre genre)
			throws DAOException {
		Employe ret = new Employe();
		ret.setEmail(email);
		ret.setNom(nom);
		ret.setTelephone(tel);
		ret.setEntree(entree);
		ret.setGenre(genre);
		
		EntityManager entityManager = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = null;

		try {
			// A COMPLETER
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (PersistenceException he) {
					he.printStackTrace();
					throw new DAOException(he,"dao.error.jpa");
				}
			}
			e.printStackTrace();
			throw new DAOException(e,"dao.error.jpa");
		} finally {
			try {
				entityManager.close();
			} catch (PersistenceException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.jpa");
			}
		}

		return ret;
	}

	public void integrateEmploye(Employe emp, Departement d) throws DAOException {
		EntityManager entityManager = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = null;

		try {
			// A COMPLETER
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (PersistenceException he) {
					he.printStackTrace();
					throw new DAOException(he,"dao.error.jpa");
				}
			}
			e.printStackTrace();
			throw new DAOException(e,"dao.error.jpa");
		} finally {
			try {
				entityManager.close();
			} catch (PersistenceException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.jpa");
			}
		}
		
	}

}
