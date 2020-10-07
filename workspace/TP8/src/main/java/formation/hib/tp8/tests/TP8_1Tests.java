package formation.hib.tp8.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.hibernate.StaleObjectStateException;

import junit.framework.TestCase;
import formation.hib.tp8.dao.DBHelper;
import formation.hib.tp8.metier.Departement;
import formation.hib.tp8.metier.Employe;
import formation.hib.tp8.metier.Poste;

public class TP8_1Tests extends TestCase {
	
	// Récupérer tous les noms des employés et des départements en une seule requéte
	public void testOptimiste() throws Exception{
		System.out.println("\nCU : Consulter la liste des noms des employés et départements");
		System.out
				.println("1 - L'utilisateur demande à voir la liste des noms de tous les employés et départements");
		System.out.println("2 - Le systéme affiche la liste");
		EntityManager em1 = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		tx1.begin();
		EntityManager em2 = DBHelper.getFactory().createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		tx2.begin();

		Employe e1 = (Employe)em1.find(Employe.class, new Long(1));
		Employe e2 = (Employe)em2.find(Employe.class, new Long(1));
		System.out.println("égalité en base ? :" +(e1.getId().equals(e2.getId())));
		e1.setTelephone("O6"+e1.getTelephone());
		e2.setTelephone("01"+e2.getTelephone());
		tx2.commit();
		em2.close();
		try {
			tx1.commit();
			em1.close();
			assertTrue(false);
		} catch ( RollbackException e) {
			System.out.println("Problème de concurrence" +e );
			e.printStackTrace();
		}

	}

}
