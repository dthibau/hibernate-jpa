package formation.hib.tp4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import formation.hib.tp4.metier.Mission;

public class MissionDAO {
		
	@SuppressWarnings("unchecked")
	public List<Mission> getAllMissions() throws DAOException {
		List<Mission> ret = new ArrayList<Mission>();
		EntityManager entityManager = JPADBHelper.getFactory().createEntityManager();
		EntityTransaction tx = null;

		try {
			tx = entityManager.getTransaction();
			tx.begin();
			// A COMPLETER
			
			tx.commit();
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
	
	public List<Mission> getAllMissionsDeType(Class classe) throws DAOException {
		List<Mission> ret = new ArrayList<Mission>();
		EntityManager entityManager = JPADBHelper.getFactory().createEntityManager();
		EntityTransaction tx = null;

		try {
			tx = entityManager.getTransaction();
			tx.begin();
			// A COMPLETER
			tx.commit();
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
	
	public void creerMission(Mission m) throws DAOException {
		EntityManager entityManager = JPADBHelper.getFactory().createEntityManager();
		EntityTransaction tx = null;

		try {
			tx = entityManager.getTransaction();
			tx.begin();
			// A COMPLETER
			tx.commit();
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
				tx = entityManager.getTransaction();
				tx.begin();
				entityManager.close();
			} catch (PersistenceException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.jpa");
			}
		}
		
	}

}
