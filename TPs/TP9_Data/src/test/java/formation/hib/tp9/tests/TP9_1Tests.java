package formation.hib.tp9.tests;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import org.junit.Test;

import formation.hib.tp9.dao.DBHelper;
import formation.hib.tp9.metier.Employe;

public class TP9_1Tests {
	
	@Test
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
//			e.printStackTrace();
		}

	}

}
