package formation.hib.tp8.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import junit.framework.TestCase;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.ejb.HibernateEntityManager;

import formation.hib.tp8.dao.DBHelper;
import formation.hib.tp8.metier.Employe;

public class TP8_2Test extends TestCase {

	public void testFlushManual() throws Exception {
		// try {

		EntityManager em = DBHelper
				.getFactory().createEntityManager();
		((Session)em).setHibernateFlushMode(FlushMode.MANUAL);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employe e1 = (Employe) em.find(Employe.class, new Long(1));
		String oldName = e1.getNom();
		long ts = System.currentTimeMillis();
		e1.setNom("New nom"+ts);
		System.out.println("No update just after me");
		tx.commit();

		// Vérification qu'il n'y a pas eu de modifications en base
		EntityManager em2 = DBHelper.getFactory().createEntityManager();
		Employe e2 = em2.find(Employe.class, new Long(1));
		assertEquals(oldName, e2.getNom());
		em2.close();

		
		tx = em.getTransaction();
		tx.begin();
		e1.setTelephone("06"+ts);
		System.out.println("It's time to flush");
		em.flush();
		tx.commit();
		em.close();

		// Vérification que les modifications ont eu lieu 
		em2 = DBHelper.getFactory().createEntityManager();
		e2 = em2.find(Employe.class, new Long(1));
		assertEquals("New nom"+ts, e2.getNom());
		assertEquals("06"+ts, e2.getTelephone());
		em.close();
	}


}
