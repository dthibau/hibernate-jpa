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
			for ( String k : f.getTaches().keySet() ) {
				System.out.println("\t" + f.getTaches().get(k).getId() + ") " + f.getTaches().get(k).getLibelle() + " Charge :" + f.getTaches().get(k).getCharge());
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
		Tache t0 = f.getTaches().values().iterator().next();
		t0.setCharge(1000);
		tx.commit();
		em.close();
		// Vérification des effets en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(3));
		t0 = f.getTaches().values().iterator().next();
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
		Tache t = new Tache();
		t.setLibelle("Ateliers");
		t.setCharge(20);
		f.getTaches().put(t.getLibelle(), t);

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
		int firstSize = f.getTaches().entrySet().size();
		// Enlever la 1ère tache
		Tache t0 = f.getTaches().values().iterator().next();
		f.getTaches().remove(t0.getLibelle());
		tx.commit();
		em.close();
		// Vérification des effets en base
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(3));
		int afterSize = f.getTaches().entrySet().size();
		assertEquals(afterSize, firstSize-1);
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
		Forfait f = new Forfait();
		f.setClient(em.find(Client.class, new Long(1)));
		f.setLibelle("libelle");
		f.setProjet("New project");
		Tache t0 = new Tache();
		t0.setCharge(10);
		t0.setLibelle("Audit");
		Tache t1 = new Tache();
		t1.setCharge(15);
		t1.setLibelle("Spécifications");
		f.getTaches().put(t0.getLibelle(),t0);
		f.getTaches().put(t1.getLibelle(),t1);
		em.persist(f);
		tx.commit();
		
		em.close();
		// Vérification le nouveau forfait a 2 tâches associées 
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
//		f = em.find(Forfait.class, new Long(4));
//		assertEquals(2, f.getTaches().size());
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
		Forfait f = em.find(Forfait.class, new Long(3));
		em.remove(f);
		tx.commit();
		em.close();
		// Vérification 
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Forfait.class, new Long(3));
		assertNull(f);
		tx.commit();
		em.close();
	}

}
