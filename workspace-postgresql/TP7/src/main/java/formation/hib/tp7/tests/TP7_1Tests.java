package formation.hib.tp7.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.dto.EmployeNameDto;
import formation.hib.tp7.metier.Employe;
import formation.hib.tp7.metier.Poste;
import junit.framework.TestCase;

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
		
//		Query jpqlQuery = em.createQuery("select emp.nom,d.nom from Departement d left outer join d.employes emp"); 

		Query jpqlQuery = em.createQuery("select emp.nom,d.nom from Departement d right outer join d.employes emp"); 

		@SuppressWarnings("unchecked")
		List<Object[]> l =  (List<Object[]>)jpqlQuery.getResultList();
		for (Object[] courant : l) {
			System.out.println("[Employe :" + courant[0] + ", Departement :" + courant[1]+"]");
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}
	
	public void testRecupererEmployeEtDepartementDto() throws Exception{
		System.out.println("\nCU : Consulter la liste des noms des employés et départements");
		System.out
				.println("1 - L'utilisateur demande à voir la liste des noms de tous les employés et départements");
		System.out.println("2 - Le systéme affiche la liste");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query jpqlQuery = em.createQuery("select new formation.hib.tp7.dto.EmployeNameDto(emp.nom,d.nom) from Departement d left outer join d.employes emp"); 
		
		@SuppressWarnings("unchecked")
		List<EmployeNameDto> l =  (List<EmployeNameDto>)jpqlQuery.getResultList();
		for (EmployeNameDto courant : l) {
			System.out.println("[Employe :" + courant.getName() + ", Departement :" + courant.getDepatementName()+"]");
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

//		Query hqlQuery = em.createQuery("select distinct emp from Employe emp inner join emp.postes poste where poste.mission.libelle = :libelle");
		
		Query hqlQuery = em.createQuery("select distinct poste.emp from Poste poste where poste.mission.libelle = :libelle");
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

		Query hqlQuery = em.createQuery("select poste.emp from Poste poste where poste.mission.client.nom = :nom");
		hqlQuery.setParameter("nom", "Computing corp");
		
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

		Query hqlQuery = em.createQuery("select p, p.emp, p.mission from Poste p where p.charge < 3");
		
		
		@SuppressWarnings("unchecked")
		List<Object[]> l =  (List<Object[]>)hqlQuery.getResultList();
		for (Object [] o : l) {
//			System.out.println(((Poste)o[0]).getLibelle() + "==> " + p.getEmp().getNom() + " pour " + p.getMission().getLibelle());
			System.out.println(((Poste)o[0]).getLibelle());
			
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}

	public void testEmployeSansPostes() throws Exception{
		System.out.println("\nCU : Sélectionnez les postes dont la charge est inférieure é une charge donnée [<3]");
		System.out
				.println("1 - L'utilisateur fournit la charge max [3]");
		System.out.println("2 - Le systéme affiche la liste des postes correspondants avec l'employé affecté et la mission concernée");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query hqlQuery = em.createQuery("select emp from Employe emp where emp.postes is empty ");
		
		
		@SuppressWarnings("unchecked")
		List<Employe> l =  (List<Employe>)hqlQuery.getResultList();
		for (Employe e : l) {
//			System.out.println(((Poste)o[0]).getLibelle() + "==> " + p.getEmp().getNom() + " pour " + p.getMission().getLibelle());
			System.out.println(e);
			
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}
	
	public void testDeletePostesCasa() throws Exception{
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query hqlQuery = em.createQuery("DELETE from Poste p where p in (select p2 from Poste p2 join p2.mission m where m.libelle = :libelle)");
		
		hqlQuery.setParameter("libelle", "Formation CASA");
		
		int deleteCount = hqlQuery.executeUpdate();
		
		
		System.out.println("Postes supprimés " + deleteCount);
			

		tx.commit();
		em.close();
	}

}
