package formation.hib.tp8.tests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Test;

import formation.hib.tp8.dao.DBHelper;
import formation.hib.tp8.metier.Employe;

public class TP8_2Test {

	@Test
	public void testTUHibernateSession() throws Exception {
		// try {

		Session session = DBHelper
				.getFactory().createEntityManager().unwrap(Session.class);

		
		// A COMPLETER
		// Charger l'employé avec l'id 1 et modifier son attribut nom avec "New nom"
		// Effectuer cette opération dans un contexte transactionnel

		// Vérification qu'il n'y a pas eu de modifications en base
		EntityManager em = DBHelper.getFactory().createEntityManager();
		Employe e2 = em.find(Employe.class, 1l);
		assertEquals("Jean Dupond", e2.getNom());
		em.close();

		// A COMPLETER
		// Utiliser l'employé précédement chargé, et provoquer les modifications en base

		// Vérification qu'il n'y a pas eu de modifications en base
		em = DBHelper.getFactory().createEntityManager();
		e2 = em.find(Employe.class, 1l);
		assertEquals("New nom", e2.getNom());
		em.close();
	}

	@Test
	public void testTUEntityManager() throws Exception {

		// A COMPLETER
		// Charger l'employé avec l'id 1 et modifier son attribut nom avec "New nom"

		// Vérification qu'il n'y a pas eu de modifications en base
		EntityManager em2 = DBHelper.getFactory().createEntityManager();
		Employe e2 = em2.find(Employe.class, 1l);
		assertEquals("Jean Dupond", e2.getNom());
		em2.close();

		// A COMPLETER
		// Utiliser l'employé précédement chargé, et provoquer les modifications en base
		
		// Vérification qu'il n'y a pas eu de modificcations en base
		em2 = DBHelper.getFactory().createEntityManager();
		e2 = em2.find(Employe.class, 1l);
		assertEquals("New nom", e2.getNom());
		em2.close();
	}

}
