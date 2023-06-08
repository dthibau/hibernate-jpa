package formation.hib.tp7.tests;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.LazyInitializationException;
import org.junit.Test;

import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.metier.Departement;
import formation.hib.tp7.metier.Employe;

public class TP7_2Test {
	
// Récupérer tous les noms des employés et des départements en une seule requéte
	@Test
	public void testLazy() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A compléter 

		tx.commit();
		em.close();

		System.out.println("2 - Le système affiche tous les départements et leurs employés");
		for (Departement d : departements) {
			System.out.println("[Departement :" + d.getNom() + "]");
			try {
				for (Employe e : d.getEmployes()) {
					System.out.println("\t[Employé :" + e.getNom() + "]");
				}
			} catch (LazyInitializationException e) {
				System.out.println("LAZY EXCEPTION");
			}
		}
	}

	@Test
	public void testAvoidLazyWithInitialize() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A compléter

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

	@Test
	public void testAvoidLazyWithHSQL() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A compléter

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

	@Test
	public void testAvoidLazyWithFetchProfile() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
// A compléter

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

	@Test
	public void testAvoidLazyWithEntityGraph() throws Exception {
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
				
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A compléter

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

	

	

}
