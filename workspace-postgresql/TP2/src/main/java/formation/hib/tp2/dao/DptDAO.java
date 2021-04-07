package formation.hib.tp2.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import formation.hib.tp2.metier.Departement;
import formation.hib.tp2.metier.Employe;

public class DptDAO {
	private static String SelectDptHQL = "from Departement d where d.nom like :nomSearch";
	private static String Nom = "nomSearch";
	
	public Set<Employe> getEmployesDe(String nom) throws DAOException {
		Set<Employe> ret = null;
		Session session = DBHelper.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			//TODO utiliser la requete HQL fournie et récupérer les employés pour le département
			// de nom donné
			@SuppressWarnings("unchecked")
			Query<Departement> q = session.createQuery(SelectDptHQL);
			q.setParameter(Nom, nom);
			Departement d = q.uniqueResult();
			ret =  d.getEmployes();
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

	public Employe createEmploye(String nom, String email, String tel)
			throws DAOException {
		Employe ret = null;
		
		Session session = DBHelper.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			//TODO Créer l'employé
			ret = new Employe(nom,email,tel);
			session.save(ret);
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

	public void integrateEmploye(Employe emp, Departement d) throws DAOException {
		Session session = DBHelper.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			//TODO intégrer l'employé au département
//			d.integreEmploye(emp);
//			session.merge(d);
			d = session.load(Departement.class, d.getId());
			d.integreEmploye(emp);
			
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
