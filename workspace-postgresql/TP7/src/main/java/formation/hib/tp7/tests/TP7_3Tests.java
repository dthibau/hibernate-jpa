package formation.hib.tp7.tests;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import formation.hib.tp7.dao.DBHelper;
import formation.hib.tp7.metier.Departement;
import formation.hib.tp7.metier.Employe;
import formation.hib.tp7.metier.Poste;
import junit.framework.TestCase;

public class TP7_3Tests extends TestCase {
	
		

	
	// Récupérer les employés d'une mission
	public void testConsulterMissionChargePartielle() throws Exception{
		System.out.println("\nCU : Consulter la liste des employés affecté é la mission [Formation CASA]");
		System.out
				.println("1 - L'utilisateur fournit le libelle de la mission");
		System.out.println("2 - Le systéme affiche la liste des affectés");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Poste> cq = cb.createQuery(Poste.class);
		Root<Poste> root = cq.from(Poste.class);
		
		cq.select(root).where(cb.lt(root.get("charge"),3));
		
		Query hqlQuery = em.createQuery(cq);
		
		@SuppressWarnings("unchecked")
		List<Poste> l =  (List<Poste>)hqlQuery.getResultList();
		for (Poste p : l) {
			System.out.println(p.getLibelle() + "==> " + p.getEmp().getNom() + " pour " + p.getMission().getLibelle());
		}
		assertNotNull(l);
		tx.commit();
		em.close();
	}
	
	
	
	// Récupérer toutes les missions é charge partielle (<5)
	public void testLoadDepartement() throws Exception{
		System.out.println("\nCU : Sélectionnez les postes dont la charge est inférieure é une charge donnée [<3]");
		System.out
				.println("1 - L'utilisateur fournit la charge max [3]");
		System.out.println("2 - Le systéme affiche la liste des postes correspondants avec l'employé affecté et la mission concernée");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EntityGraph entityGraph =
				em.getEntityGraph("departement-with-employes-graph");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Departement> cq = cb.createQuery(Departement.class);
		Root<Departement> root = cq.from(Departement.class);
		TypedQuery<Departement> typedQuery = em.createQuery(cq);
		typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
		
		
		@SuppressWarnings("unchecked")
		List<Departement> departements =  typedQuery.getResultList();
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
