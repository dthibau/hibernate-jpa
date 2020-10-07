package formation.hib.tp7.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;
import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.metier.Departement;
import formation.hib.tp7.metier.Employe;

public class TP7_2Test extends TestCase {
	
	// Récupérer tous les noms des employés et des départements en une seule requéte
	public void testRecupererDepartementEtEmployes() throws Exception{
		System.out.println("\nCU : Consulter les départements et leurs employés");
		System.out
				.println("1 - L'utilisateur demande à charger les départements et leurs employés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("select distinct d from Departement d left join fetch d.employes employes ");
//		Query hqlQuery = em.createQuery("from Departement");
		@SuppressWarnings("unchecked")
		List<Departement> departements =  hqlQuery.getResultList();
		assertNotNull(departements);
		tx.commit();
		em.close();
		System.out.println("2 - Le système affiche tous les départements et leurs employés");
		for (Departement d : departements) {
			System.out.println("[Departement :" + d.getNom()+"]");
			for ( Employe e : d.getEmployes() ) {
				System.out.println("\t[Employé :" + e.getNom()+"]");
			}
		}
	}
	

	

}
