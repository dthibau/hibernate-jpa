package formation.hib.tp9.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.junit.Test;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Departement;

public class TP9_4CAcheAndMonitor {
	
	private void _printCacheRegionStatistiques(String regionName) {
	
	}
	// Récupérer tous les noms des employés et des départements en une seule requéte
	@Test
	public void testCacheDepartement() throws Exception{

		// Chargement du Department dans le cache 
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Departement d = (Departement)em.find(Departement.class, new Long(1));
		tx.commit();
		em.close();
		
		_printCacheRegionStatistiques("Departement");

		// L'accès à Département ne doit pas provoquer de requête SELECT
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		d = (Departement)em.find(Departement.class, new Long(1));
		tx.commit();
		em.close();
		
		// Mise à jour du département => Invalidation du cache
		em = DBHelper.getFactory().createEntityManager();
		Session session = em.unwrap(Session.class);
		System.out.println(session.getCacheMode());
		tx = em.getTransaction();
		tx.begin();

		d = (Departement)em.find(Departement.class, new Long(1));
		d.setNom(d.getNom()+"X");
		tx.commit();
		em.close();
		
		_printCacheRegionStatistiques("Departement");
		
		// Le cache a été invalidé => rechargement du département dans le cache
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		d = (Departement)em.find(Departement.class, new Long(1));
		System.out.println("Departement :"+d.getNom());
		tx.commit();
		em.close();
		_printCacheRegionStatistiques("Departement");
		
		// En mode PUT, la session ne lit pas dans le cache
		em = DBHelper.getFactory().createEntityManager();
		session = em.unwrap(Session.class);

		session.setCacheMode(CacheMode.PUT);
		tx = em.getTransaction();
		tx.begin();

		d = (Departement)session.load(Departement.class, new Long(1));
		System.out.println("Departement :"+d.getNom());
		tx.commit();
		em.close();
		_printCacheRegionStatistiques("Departement");
	}

	@Test
	public void testCacheQuery() throws Exception{

		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createNamedQuery("grandDepartement");
		List<Departement> depts = (List<Departement>)q.getResultList();
		tx.commit();
		em.close();
		System.out.println("Departements :"+depts.size());
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		q = em.createNamedQuery("grandDepartement");
		depts = (List<Departement>)q.getResultList();
		tx.commit();
		em.close();
		System.out.println("Departements :"+depts.size());

	}
}
