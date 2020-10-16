package formation.hib.tp5.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;
import formation.hib.tp5.dao.DBHelper;
import formation.hib.tp5.metier.Client;
import formation.hib.tp5.metier.Mission;
import formation.hib.tp5.metier.Regie;

public class TP5_1Tests extends TestCase {
	public void testConsulterClients() throws Exception {
		System.out.println("\nCU : Consulter la liste des clients");
		System.out
				.println("1 - L'utilisateur demande de voir la liste de tous les clients avec leurs missions");
		System.out.println("2 - Le système affiche les clients");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("from Client");
		@SuppressWarnings("unchecked")
		List<Client> clients = (List<Client>) hqlQuery.getResultList();
		for (Client client : clients) {
			System.out.println(client.getId() + ") " + client.getNom());
			for ( Mission mission : client.getMissions() ) {
				System.out.println("\t" + mission.getId() + ") " + mission.getLibelle());
			}
		}
		assertNotNull(clients);
		tx.commit();
		em.close();
	
	}
	
	public void testConsulterMissions() throws Exception {
		System.out.println("\nCU : Consulter la liste des missions");
		System.out
				.println("1 - L'utilisateur demande à voir la liste de toutes les missions avec leur client");
		System.out.println("2 - Le systéme affiche les missions");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("from Mission");
		@SuppressWarnings("unchecked")
		List<Mission> lMis = (List<Mission>) hqlQuery.getResultList();
		for (Mission m : lMis) {
			System.out.println(m.getId() + ") " + m.getLibelle() + " client -> "
					+ m.getClient().getNom());

		}
		assertNotNull(lMis);
		tx.commit();
		em.close();

	}
	
	public void testCUCreerUneRegie() throws Exception {
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.out
				.println("\nCU : Créer une nouvelle régie");
		System.out
				.println("1 - L'utilisateur sélectionne un type [Regie] ");
		System.out.println("2 - L'utilisateur fournit les libelle, date de début, de fin et le taux\n"+
				 " ['Conseil Banquaire','2004-08-14','2005-03-15','10']");
		System.out.println("3 - Le systéme crée une nouvelle régie");
		
		Regie r = new Regie();
		r.setLibelle("Conseil Banquaire");
		r.setTaux(10);
		r.setDebut(computeDate(14,8,2004));
		r.setFin(computeDate(15,3,2005));
		em.persist(r);
		
		System.out.println("4 - L'utilisateur sélectionne le client d'Id : 2");
		System.out.println("5 - Le système charge et affiche le client et l'associe à la Régie ");
		
		Client client = em.find(Client.class, 2l);
		client.addMission(r);
		
		tx.commit();
		em.close();
	}
	
	public void testCUSupprimerUneMission() throws Exception {
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.out
				.println("\nCU : Supprimer une mission");
		System.out
				.println("1 - L'utilisateur sélectionne la mission d'ID [1] ");
		System.out.println("2 - Le système retrouve et affiche la mission");
		
		Mission m = em.find(Mission.class, 1l);
		
		System.out.println("Mission : " + m.getLibelle() + " pour " + m.getClient().getNom());
		System.out.println("3 - Le système supprime la mission");
		
		em.remove(m);
		
		tx.commit();
		em.close();
		
		// vérification
		em = DBHelper.getFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Mission removedMission = (Mission)em.find(Mission.class,new Long(1));
		assertNull(removedMission);
		tx.commit();
		em.close();
	}
	
	
	
	private Date computeDate(int day, int month,int year){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,day);
		c.set(Calendar.MONTH,month - 1);
		c.set(Calendar.YEAR,year);
		return c.getTime();
	}



}
