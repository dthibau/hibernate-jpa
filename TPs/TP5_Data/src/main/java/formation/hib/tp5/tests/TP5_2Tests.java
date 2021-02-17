package formation.hib.tp5.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;
import formation.hib.tp5.dao.DBHelper;
import formation.hib.tp5.metier.Employe;
import formation.hib.tp5.metier.Mission;

public class TP5_2Tests extends TestCase {
	public void testConsulterPostes() throws Exception {
		System.out.println("\nCU : Consulter la liste des postes");
		System.out
				.println("1 - L'utilisateur demande à voir la liste de tous les postes");
		System.out.println("2 - Le systéme affiche les postes");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query hqlQuery = em.createQuery("from Poste");
		@SuppressWarnings("unchecked")
		List<Poste> lPos = (List<Poste>) hqlQuery.getResultList();
		for (Poste p : lPos) {
			System.out.println(p.getId() + ") " + p.getLibelle() + " emp -> "
					+ p.getEmploye().getNom() + " mission -> " + p.getMission().getLibelle());

		}
		assertNotNull(lPos);
		tx.commit();
		em.close();
	}
	
	
	public void testConsulterEmploye() throws Exception {
		System.out.println("\nCU : Consulter un employé et ses missions");
		System.out
				.println("1 - L'utilisateur demande é voir l'employé d'Id [1]");
		System.out.println("2 - Le systéme affiche l'employé et ses postes");
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employe e = (Employe)em.find(Employe.class,new Long(1));
		List<Poste> postes = e.getPostes();
		for ( Poste courant : postes ) {
			System.out.println("Poste :" + courant.getLibelle() + " mission :" + courant.getMission().getLibelle());
		}
		tx.commit();
		em.close();
	}
	
	public void testCreerUnPoste() throws Exception {
		EntityManager em = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.out.println("\nCU : Créer un nouveau poste");
		System.out
				.println("1 - L'utilisateur sélectionne l'employé d'Id [2]");
		System.out.println("2 - Le systéme affiche l'employé");
		Employe e = (Employe)em.find(Employe.class,new Long(2));
		System.out.println("Employe :" + e.getNom());
		System.out.println("3 - L'utilisateur sélectionne une mission d'id [3]");
		System.out.println("4 - Le systéme affiche les infos de la mission");
		Mission m = (Mission)em.find(Mission.class,new Long(3));
		System.out.println("Mission :" + m.getLibelle());
		System.out.println("5 - L'utilisateur fournit les infos du poste ['Développeur', '4,5j/s']");
		System.out.println("6 - Le systéme crée le poste et les associations");

		// A COMPLETER
		
		tx.commit();
		em.close();
	}

}
