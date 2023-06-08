package formation.hib.tp9.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Client;

public class TP9_2Batch  {
	
	@Test
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
	
	

}
