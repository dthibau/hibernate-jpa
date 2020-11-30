package formation.hib.tp9.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Departement;
import formation.hib.tp9.metier.Forfait;
import formation.hib.tp9.metier.Tache;
import junit.framework.TestCase;

public class TP9_3Cache extends TestCase {

	private void _printCacheRegionStatistiques(String regionName) {
		
		SessionFactory sessionFactory = DBHelper.getFactory().unwrap(SessionFactory.class);
		System.out.println(sessionFactory.getStatistics().getCacheRegionStatistics(regionName));
		
	}
	
	// Show Use of cache
	public void testCache() {
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query hqlQuery = em.createQuery("from Forfait");
		@SuppressWarnings("unchecked")
		Forfait oneForfait = (Forfait)hqlQuery.getResultList().get(0);
		tx.commit();
		em.close();

		_printCacheRegionStatistiques("Mission");
		
		// Acess to tache when session is closed
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		System.out.println("There should be no SQL statements after ME");
		em.find(Forfait.class, oneForfait.getId());

		tx.commit();
		em.close();
	}

	// Show Use of cache
		public void testCollections() {
			EntityManager em = DBHelper.getFactory().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Query hqlQuery = em.createQuery("from Forfait");
			@SuppressWarnings("unchecked")
			Forfait oneForfait = ((List<Forfait>) hqlQuery.getResultList()).get(0);

			tx.commit();
			em.close();

			// Acess to tache when session is closed
			em = DBHelper.getFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			System.out.println("There should be no SQL statements after ME");
			oneForfait = em.find(Forfait.class, oneForfait.getId());
			System.out.println("Collections are not cached then SQL please");
			System.out.println("There are " + oneForfait.getTaches().size() + " taches");

			tx.commit();
			em.close();
		}

		// Insertion does not write to cache
		public void testCreateWithCache() {
			// Create a Forfait (Do not Write in the cache)
			EntityManager em = DBHelper.getFactory().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Forfait f = new Forfait();
			f.setPrix(1000);
			f.setProjet("MyProject");
			Tache t = new Tache();
			t.setCharge(10);
			t.setLibelle("Nouvelle tache");
			f.addTache(t);
			Tache t2 = new Tache();
			t2.setCharge(20);
			t2.setLibelle("2 ème Nouvelle tache");
			f.addTache(t2);

			em.persist(f);
			tx.commit();
			em.close();

			// Previous forfait is in cache
			em = DBHelper.getFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			System.out.println("There should be no SQL statements after ME");
			Forfait newForfait = em.find(Forfait.class, f.getId());

			tx.commit();
			em.close();
		}

		// Insertion does not write to cache
		public void testUpdateWithCache() {
			EntityManager em = DBHelper.getFactory().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Query hqlQuery = em.createQuery("from Forfait");
			@SuppressWarnings("unchecked")
			Forfait oneForfait = ((List<Forfait>) hqlQuery.getResultList()).get(0);

			tx.commit();
			em.close();

			// Update One Forfait
			em = DBHelper.getFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			System.out.println("NO SELECT but one update which writes to the cache");
			oneForfait = em.find(Forfait.class, oneForfait.getId());
			long ts = System.currentTimeMillis();
			oneForfait.setProjet(""+ts);

			tx.commit();
			em.close();

			// Load fron cache
			em = DBHelper.getFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			System.out.println("There should be no SQL statements after ME");
			oneForfait = em.find(Forfait.class, oneForfait.getId());

			tx.commit();
			em.close();

			assertEquals(oneForfait.getProjet(), ""+ts);

		}

		public void testCacheModeGet() {
			// Entities are cached
			EntityManager em = DBHelper.getFactory().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Query hqlQuery = em.createQuery("from Forfait");
			@SuppressWarnings("unchecked")
			Forfait oneForfait = ((List<Forfait>) hqlQuery.getResultList()).get(0);

			tx.commit();
			em.close();

			// We want to ignore the cache
			em = DBHelper.getFactory().createEntityManager();
			((Session) em).setCacheMode(CacheMode.GET);
			tx = em.getTransaction();
			tx.begin();
			System.out.println("I DO NOT CARE ABOUT CACHE");
			oneForfait = em.find(Forfait.class, oneForfait.getId());
			long ts = System.currentTimeMillis();
			oneForfait.setProjet(""+ts);
			
			tx.commit();
			em.close();

			// Cache was invalidated
			em = DBHelper.getFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			System.out.println("There should be a SQL statements after ME");
			oneForfait = em.find(Forfait.class, oneForfait.getId());

			tx.commit();
			em.close();

			assertEquals(oneForfait.getProjet(), ""+ts);
		}
}
