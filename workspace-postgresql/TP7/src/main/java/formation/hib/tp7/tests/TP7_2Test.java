package formation.hib.tp7.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;

import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.metier.Departement;
import formation.hib.tp7.metier.Employe;
import junit.framework.TestCase;

public class TP7_2Test extends TestCase {

	// Récupérer tous les noms des employés et des départements en une seule requéte
	public void testLazy() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query hqlQuery = em.createQuery("from Departement");

		List<Departement> departements = hqlQuery.getResultList();
		assertNotNull(departements);
		tx.commit();
		em.close();

		System.out.println("2 - Le système affiche tous les départements et leurs employés");
		departements.stream().forEach(d -> {
			try {
				d.getEmployes().stream().forEach(System.out::println);
				fail("Exception non lancée");
			} catch (LazyInitializationException e) {
				System.out.println("LAZY EXCEPTION");
			}

		});

	}

	public void testAvoidLazyWithInitialize() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query hqlQuery = em.createQuery("from Departement ");

		List<Departement> departements = hqlQuery.getResultList();
		departements.stream().forEach(d -> Hibernate.initialize(d.getEmployes()));

		assertNotNull(departements);
		tx.commit();
		em.close();

		System.out.println("2 - Le système affiche tous les départements et leurs employés");
		for (Departement d : departements) {
			System.out.println("[Departement :" + d.getNom() + "]");
			for (Employe e : d.getEmployes()) {
				System.out.println("\t[Employé :" + e.getNom() + "]");
			}
		}
	}

	public void testAvoidLazyWithHSQL() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query hqlQuery = em.createQuery("select distinct d from Departement d LEFT JOIN FETCH d.employes");

		List<Departement> departements = hqlQuery.getResultList();
		assertNotNull(departements);
		tx.commit();
		em.close();

		System.out.println("2 - Le système affiche tous les départements et leurs employés");
		departements.stream().forEach(d -> {
				d.getEmployes().stream().forEach(System.out::println);
			});
	}

	public void testAvoidLazyWithFetchProfile() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Session session = em.unwrap(Session.class);
		session.enableFetchProfile("departement-with-employes");
		tx.begin();

		Query hqlQuery = em.createQuery("from Departement");

		List<Departement> departements = hqlQuery.getResultList();
		assertNotNull(departements);
		tx.commit();
		em.close();

		System.out.println("2 - Le système affiche tous les départements et leurs employés");
		for (Departement d : departements) {
			System.out.println("[Departement :" + d.getNom() + "]");
			for (Employe e : d.getEmployes()) {
				System.out.println("\t[Employé :" + e.getNom() + "]");
			}
		}
	}

	
	public void testAvoidLazyWithEntityGraph() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityGraph entityGraph =
				em.getEntityGraph("departement-with-employes-graph");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		@SuppressWarnings("unchecked")
//		List<Departement> departements = em.createQuery("from Departement")
//				  .setHint("javax.persistence.fetchgraph", entityGraph)
//				  .getResultList();
//		assertNotNull(departements);
		
		Map<String,Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", entityGraph);
		Departement dep = em.find(Departement.class,1l,properties);
		tx.commit();
		em.close();
		
		System.out.println(dep.getEmployes());

		System.out.println("2 - Le système affiche tous les départements et leurs employés");
//		for (Departement d : departements) {
//			System.out.println("[Departement :" + d.getNom() + "]");
//			for (Employe e : d.getEmployes()) {
//				System.out.println("\t[Employé :" + e.getNom() + "]");
//			}
//		}
	}

}
