package formation.hib.tp9.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.junit.Test;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Client;

public class TP9_2Batch {
	
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
	
	@Test
	public void testBatch() throws Exception{

		long ts = System.currentTimeMillis();

		EntityManager em = DBHelper.getFactory().createEntityManager();
		Session session = em.unwrap(Session.class);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		session.setCacheMode(CacheMode.IGNORE);
		for ( int i=0; i< 1000000; i++) {
			Client c = new Client();
			c.setNom("DummyClient");
			em.persist(c);
			if ( i % 25 == 0 ) { //20, same as the JDBC batch size
		        //flush a batch of inserts and release memory:
		        em.flush();
		        em.clear();
		    }
			
		}
		
		tx.commit();
		em.close();
		System.out.println(System.currentTimeMillis()-ts +"ms");
	}

	@Test
	public void testScroll() throws Exception {
		int batchSize = 25;
		
		long start = System.currentTimeMillis();
		
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Session session = em.unwrap( Session.class );

		tx.begin();
		ScrollableResults scrollableResults = session
		  .createQuery( "select c from Client c" )
		  .setCacheMode( CacheMode.IGNORE )
		  .scroll( ScrollMode.FORWARD_ONLY );

		int count = 0;
		while ( scrollableResults.next() ) {
		  Client client = (Client) scrollableResults.get( 0 );
		  long ts = System.currentTimeMillis();
		  client.setNom("name"+ts);
		  if ( ++count % batchSize == 0 ) {
		    //flush a batch of updates and release memory:
		    em.flush();
		    em.clear();
		  }
		}

		tx.commit();
		em.close();
		System.out.println(System.currentTimeMillis()-start +"ms");

	}
	
	@Test
	public void testAllScroll() throws Exception {
		testBatch();
		
		testScroll();
	}

}
