package formation.hib.tp4.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import formation.hib.tp4.dao.DAOException;
import formation.hib.tp4.dao.DBHelper;
import formation.hib.tp4.metier.Mission;

public class MissionDAO {
		
	@SuppressWarnings("unchecked")
	public List<Mission> getAllMissions() throws DAOException {
		List<Mission> ret = new ArrayList<Mission>();
		Session session = DBHelper.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query hqlQuery = session.createQuery("from Mission");
	        ret = (List<Mission>)hqlQuery.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (HibernateException he) {
					he.printStackTrace();
					throw new DAOException(he,"dao.error.hibernate");
				}
			}
			e.printStackTrace();
			throw new DAOException(e,"dao.error.hibernate");
		} finally {
			try {
				session.close();
			} catch (HibernateException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.hibernate");
			}
		}
		
		return ret;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Mission> getAllMissionsDeType(@SuppressWarnings("rawtypes") Class classe) throws DAOException {
		List<Mission> ret = new ArrayList<Mission>();
		Session session = DBHelper.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query hqlQuery = session.createQuery("from " + classe.getName());
	        ret = (List<Mission>)hqlQuery.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (HibernateException he) {
					he.printStackTrace();
					throw new DAOException(he,"dao.error.hibernate");
				}
			}
			e.printStackTrace();
			throw new DAOException(e,"dao.error.hibernate");
		} finally {
			try {
				session.close();
			} catch (HibernateException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.hibernate");
			}
		}
		
		return ret;	
	}
	
	public void creerMission(Mission m) throws DAOException {
		Session session = DBHelper.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(m);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (HibernateException he) {
					he.printStackTrace();
					throw new DAOException(he,"dao.error.hibernate");
				}
			}
			e.printStackTrace();
			throw new DAOException(e,"dao.error.hibernate");
		} finally {
			try {
				session.close();
			} catch (HibernateException he) {
				he.printStackTrace();
				throw new DAOException(he,"dao.error.hibernate");
			}
		}
	}

}
