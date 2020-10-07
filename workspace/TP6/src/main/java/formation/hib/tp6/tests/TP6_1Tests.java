package formation.hib.tp6.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;
import formation.hib.tp6.dao.DBHelper;
import formation.hib.tp6.metier.Email;
import formation.hib.tp6.metier.Employe;

public class TP6_1Tests extends TestCase {

	public void testConsulterEmployes() throws Exception {
		System.out.println("\nCU : Consulter la liste des employés");
		System.out
				.println("1 - L'utilisateur demande de voir la liste de tous les employés avec leur email");
		System.out.println("2 - Le système affiche les employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("from Employe");
		@SuppressWarnings("unchecked")
		List<Employe> lEmp = (List<Employe>) hqlQuery.getResultList();
		for (Employe e : lEmp) {
			System.out.println(e.getId() + ") " + e.getNom() + " adresse -> "
					+ e.getEmail() + " [" + (e.getEmail() != null ? e.getEmail().getDomainName() : "") + "]");

		}
		assertNotNull(lEmp);
		tx.commit();
		em.close();

	}
	
	//Modifier l'adresse d'un employé
	public void testUpdateEmailEmploye() throws Exception{
		System.out.println("\nCU : Mise à jour de l'adresse email d'un employé");
		System.out
				.println("1 - L'utilisateur charge l'employé n° 3");
		System.out.println("2 - Met à jour l'adresse email");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employe e3 = em.find(Employe.class,new Long(3));
		e3.getEmail().setAdresse("newAdresse@plb.fr");
		tx.commit();
		em.close();
		// Vérification de la mise en jour en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		e3 = em.find(Employe.class,new Long(3));
		assertEquals("newAdresse@plb.fr", e3.getEmail().getAdresse());
		tx.commit();
		em.close();
	}
	
	//Création de l'adresse d'un employé
	public void testCreateEmailEmploye() throws Exception{
		System.out.println("\nCU : Mise à jour de l'adresse email d'un employé");
		System.out
				.println("1 - L'utilisateur charge l'employé n° 3");
		System.out.println("2 - Il renseigne une nouvelle adresse email");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employe e3 = em.find(Employe.class,new Long(3));
		e3.setEmail(new Email("newAdresse@plb.fr"));
		tx.commit();
		em.close();
		// Vérification de la mise en jour en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		e3 = em.find(Employe.class,new Long(3));
		assertEquals("newAdresse@plb.fr", e3.getEmail().getAdresse());
		tx.commit();
		em.close();
	}

}
