package formation.hib.tp7.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;
import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.metier.Employe;
import formation.hib.tp7.metier.Poste;

public class TP7_1Tests extends TestCase {
	
	// Récupérer tous les noms des employés et des départements en une seule requéte
	public void testRecupererEmployeEtDepartement() throws Exception{
		System.out.println("\nCU : Consulter la liste des noms des employés et départements");
		System.out
				.println("1 - L'utilisateur demande à voir la liste des noms de tous les employés et départements");
		System.out.println("2 - Le systéme affiche la liste");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("select  emp.nom, dpt.nom from Departement dpt join dpt.employes emp");

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
	public void testConsulterEmployeDUneMission() throws Exception{
		System.out.println("\nCU : Consulter la liste des employés affecté é la mission [Formation CASA]");
		System.out
				.println("1 - L'utilisateur fournit le libelle de la mission");
		System.out.println("2 - Le systéme affiche la liste des affectés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query hqlQuery = em.createQuery(" from Employe emp inner join emp.postes poste where poste.mission.libelle = :libelle");
		hqlQuery.setParameter("libelle", "Formation CASA");
		
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
	public void testConsulterEmployeDUnClient() throws Exception{
		System.out.println("\nCU : Consulter la liste des employés travaillant pour [Computing corp]");
		System.out
				.println("1 - L'utilisateur fournit le libelle du client [Computing corp]");
		System.out.println("2 - Le systéme affiche la liste des employés concernés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("select emp from Employe emp join emp.postes p where p.mission.client.nom = :nomClient");
		hqlQuery.setParameter("nomClient","Computing corp");
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
	public void testConsulterMissionChargePartielle() throws Exception{
		System.out.println("\nCU : Sélectionnez les postes dont la charge est inférieure é une charge donnée [<3]");
		System.out
				.println("1 - L'utilisateur fournit la charge max [3]");
		System.out.println("2 - Le systéme affiche la liste des postes correspondants avec l'employé affecté et la mission concernée");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("select p from Poste p  where p.charge < :charge");
		hqlQuery.setParameter("charge",3.0f);
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
