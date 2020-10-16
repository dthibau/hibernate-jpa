package formation.hib.tp9.tests;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Client;
import formation.hib.tp9.metier.Departement;

public class TP9_3Tests extends TestCase {
	
	// Récupérer tous les noms des employés et des départements en une seule requéte
	public void testOutOfMemory() throws Exception{

		// Chargement du Department dans le cache 
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for ( int i=0; i< 10000000; i++) {
			Client c = new Client();
			c.setNom("DummyClient");
			em.persist(c);
		}
		
		tx.commit();
		em.close();
	}
	public void testBatch() throws Exception{

		// Chargement du Department dans le cache 
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Session session = ((HibernateEntityManager)em).getSession();
		session.setCacheMode(CacheMode.IGNORE);
		for ( int i=0; i< 10000000; i++) {
			Client c = new Client();
			c.setNom("DummyClient");
			em.persist(c);
			if ( i % 20 == 0 ) { //20, same as the JDBC batch size
		        //flush a batch of inserts and release memory:
		        em.flush();
		        em.clear();
		    }
			
		}
		
		tx.commit();
		em.close();
	}

}
