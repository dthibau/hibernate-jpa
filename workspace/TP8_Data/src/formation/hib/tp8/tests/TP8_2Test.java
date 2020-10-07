package formation.hib.tp8.tests;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;

import formation.hib.tp8.dao.DBHelper;
import formation.hib.tp8.metier.Employe;

public class TP8_2Test extends TestCase {

	public void testTUHibernateSession() throws Exception {
		// try {

		HibernateEntityManager hem = (HibernateEntityManager) DBHelper
				.getFactory().createEntityManager();
		Session session = hem.getSession();
		
		// A COMPLETER
		// Charger l'employé avec l'id 1 et modifier son attribut nom avec "New nom"
		// Effectuer cette opération dans un contexte transactionnel

		// Vérification qu'il n'y a pas eu de modifications en base
		EntityManager em = DBHelper.getFactory().createEntityManager();
		Employe e2 = em.find(Employe.class, new Long(1));
		assertEquals("Jean Dupond", e2.getNom());
		em.close();

		// A COMPLETER
		// Utiliser l'employé précédement chargé, et provoquer les modifications en base

		// Vérification qu'il n'y a pas eu de modifications en base
		em = DBHelper.getFactory().createEntityManager();
		e2 = em.find(Employe.class, new Long(1));
		assertEquals("New nom", e2.getNom());
		em.close();
	}

	public void testTUEntityManager() throws Exception {

		// A COMPLETER
		// Charger l'employé avec l'id 1 et modifier son attribut nom avec "New nom"

		// Vérification qu'il n'y a pas eu de modifications en base
		EntityManager em2 = DBHelper.getFactory().createEntityManager();
		Employe e2 = em2.find(Employe.class, new Long(1));
		assertEquals("Jean Dupond", e2.getNom());
		em2.close();

		// A COMPLETER
		// Utiliser l'employé précédement chargé, et provoquer les modifications en base
		
		// Vérification qu'il n'y a pas eu de modificcations en base
		em2 = DBHelper.getFactory().createEntityManager();
		e2 = em2.find(Employe.class, new Long(1));
		assertEquals("New nom", e2.getNom());
		em2.close();
	}

}
