package formation.hib.tp9.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Forfait;
import formation.hib.tp9.metier.Tache;
import junit.framework.TestCase;

public class TP9_3Cache extends TestCase {

	// Show Use of cache
	public void testCache() {
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
		em.find(Forfait.class, oneForfait.getId());

		tx.commit();
		em.close();
	}

	// Show Use of cache
	public void testCollections() {

		// Dans la même idée la méthode précédente
		// Tester l'usage du cache pour les collections
	}

	// Insertion does not write to cache
	public void testCreateWithCache() {

		// Dans la même idée la méthode précédente
		// Tester l'usage du cache lors d'une insertion en base
	}

	// Insertion does not write to cache
	public void testUpdateWithCache() {
		// Dans la même idée la méthode précédente
				// Tester l'usage du cache lors d'une mise à jour

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
		
		// manual invalidate
		((SessionFactory)DBHelper.getFactory()).getCache().evict(Forfait.class, oneForfait.getId());
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
