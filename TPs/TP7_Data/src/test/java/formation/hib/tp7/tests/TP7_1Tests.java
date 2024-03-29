package formation.hib.tp7.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.metier.Employe;
import formation.hib.tp7.metier.Poste;

public class TP7_1Tests {
	
	// Récupérer tous les noms des employés et des départements en une seule requéte
	@Test
	public void testRecupererEmployeEtDepartement() throws Exception{
		System.out.println("\nCU : Consulter la liste des noms des employés et départements");
		System.out
				.println("1 - L'utilisateur demande à voir la liste des noms de tous les employés et départements");
		System.out.println("2 - Le systéme affiche la liste");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// A COMPLETER
		
		@SuppressWarnings("unchecked")
		List<Object> l =  (List<Object>)hqlQuery.getResultList();
		for (Object o : l) {
			Object[] courant = (Object[])o;
			System.out.println("[Employe :" + courant[0] + ", Departement :" + courant[1]+"]");
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}
	

	
	// Récupérer les employés d'une mission
	@Test
	public void testConsulterEmployeDUneMission() throws Exception{
		System.out.println("\nCU : Consulter la liste des employés affecté é la mission [Formation CASA]");
		System.out
				.println("1 - L'utilisateur fournit le libelle de la mission");
		System.out.println("2 - Le systéme affiche la liste des affectés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A COMPLETER
		
		@SuppressWarnings("unchecked")
		List<Employe> l =  (List<Employe>)hqlQuery.getResultList();
		assertNotNull(l);
		tx.commit();
		em.close();
		for (Employe e : l) {
			System.out.println(e.getNom());
		}
	}
	
	// Récupérer les employés travaillant pour un client donné
	@Test
	public void testConsulterEmployeDUnClient() throws Exception{
		System.out.println("\nCU : Consulter la liste des employés travaillant pour [Computing corp]");
		System.out
				.println("1 - L'utilisateur fournit le libelle du client [Computing corp]");
		System.out.println("2 - Le systéme affiche la liste des employés concernés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A COMPLETER
		
		@SuppressWarnings("unchecked")
		List<Employe> l =  (List<Employe>)hqlQuery.getResultList();
		for (Employe e : l) {
			System.out.println(e.getNom());
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}
	
	// Récupérer toutes les missions é charge partielle (<5)
	@Test
	public void testConsulterMissionChargePartielle() throws Exception{
		System.out.println("\nCU : Sélectionnez les postes dont la charge est inférieure é une charge donnée [<3]");
		System.out
				.println("1 - L'utilisateur fournit la charge max [3]");
		System.out.println("2 - Le systéme affiche la liste des postes correspondants avec l'employé affecté et la mission concernée");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// A COMPLETER
		
		@SuppressWarnings("unchecked")
		List<Poste> l =  (List<Poste>)hqlQuery.getResultList();
		for (Poste p : l) {
			System.out.println(p.getLibelle() + "==> " + p.getEmp().getNom() + " pour " + p.getMission().getLibelle());
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}

}
