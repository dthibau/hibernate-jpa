package formation.hib.tp6.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;
import formation.hib.tp6.dao.DBHelper;
import formation.hib.tp6.metier.Client;
import formation.hib.tp6.metier.Employe;
import formation.hib.tp6.metier.Forfait;
import formation.hib.tp6.metier.Poste;
import formation.hib.tp6.metier.Tache;

public class TP6_2Tests extends TestCase {

	public void testConsulterForfaitEtTaches() throws Exception {
		System.out.println("\nCU : Consulter la liste des forfaits et des tâches associées");
		System.out
				.println("1 - L'utilisateur demande de voir la liste de tous les forfaits");
		System.out.println("2 - Le système affiche les forfaits et les taches associées");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("from Forfait");
		List<Forfait> forfaits = (List<Forfait>) hqlQuery.getResultList();
		for (Forfait f : forfaits) {
			System.out.println(f.getId() + ") " + f.getLibelle());
			for ( Tache t : f.getTaches() ) {
				System.out.println("\t" + t.getId() + ") " + t.getLibelle() + " Charge :" + t.getCharge());
			}
		}
		assertNotNull(forfaits);
		tx.commit();
		em.close();

	}
	
	// Récupérer tous les noms des employés et des départements en une seule requéte
	public void testModifierTache() throws Exception{
		System.out.println("\nCU : Modifier la charge d'une tâche");
		System.out
				.println("1 - L'utilisateur charge le Forfait et met à jour la charge de la 1ère tache avec 1000 ");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Forfait f = em.find(Forfait.class, new Long(3));
		Tache t0 = f.getTaches().get(0);
		t0.setCharge(1000);
		tx.commit();
		em.close();
		// Vérification des effets en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(3));
		t0 = f.getTaches().get(0);
		assertEquals(1000, t0.getCharge());
		tx.commit();
		em.close();
	}
	
//	 Consulter tous les employés par départements
	public void testCreerTache() throws Exception{
		System.out.println("\nCU : Créer une nouvelle tâche");
		System.out
				.println("1 - L'utilisateur charge le Forfait et ajoute une nouvelle tache ");
		System.out.println("2 - Le système affiche la liste");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Forfait f = em.find(Forfait.class, new Long(3));
		// A COMPLETER
		// Ajouter une tâche

		tx.commit();
		em.close();
		// Vérification des effets en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(3));
		assertEquals(4, f.getTaches().size());
		tx.commit();
		em.close();
	}
	
	// Retirer une tache d'un forfait
	// Dépend tu test précédent
	public void testEnleverTache() throws Exception{
		System.out.println("\nCU : Retirer une tâche");
		System.out
				.println("1 - L'utilisateur charge le Forfait et retire une tache ");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Forfait f = em.find(Forfait.class, new Long(3));
		// A COMPLETER
		// Enlever la 4ème tâche
		
		tx.commit();
		em.close();
		// Vérification des effets en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(3));
		assertEquals(3, f.getTaches().size());
		tx.commit();
		em.close();
	}
	
	// Récupérer les employés travaillant pour un client donné
	public void testNouveauForfait() throws Exception{
		System.out.println("\nCU : Créer un forfait avec ses tâches associées");
		System.out
				.println("1 - L'utilisateur créé une nouveau forfait et y ajoute des tâches");
		System.out.println("2 - Le système persiste le nouveau forfait et les tâches associées");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Créer un nouveau forfait 
		// avec 2 tâches
		
		tx.commit();
		em.close();
		// Vérification le nouveau forfait a 2 tâches associées 
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(4));
		assertEquals(2, f.getTaches().size());
		tx.commit();
		em.close();
	}
	
	public void testSupprimerForfait() throws Exception{
		System.out.println("\nCU : Supprimer un forfait (et ses tâches associées)");
		System.out
				.println("1 - L'utilisateur charge le forfait (4) et le supprime");
		System.out.println("2 - Le système supprime le forfait et les tâches associées");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// A COMPLETER
		// Suppression du forfait

		
		tx.commit();
		em.close();
		// Vérification 
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("from Tache");
		assertEquals(3, q.getResultList().size());
		tx.commit();
		em.close();
	}

}
