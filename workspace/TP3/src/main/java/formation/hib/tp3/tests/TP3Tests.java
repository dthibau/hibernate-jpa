package formation.hib.tp3.tests;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import junit.framework.TestCase;
import formation.hib.tp3.dao.DBHelper;
import formation.hib.tp3.dao.DptDAO;
import formation.hib.tp3.metier.Departement;
import formation.hib.tp3.metier.Employe;
import formation.hib.tp3.metier.Genre;

public class TP3Tests extends TestCase {
	 
	public void testCUConsulterListeEmployesDpt() throws Exception {
		System.out
				.println("\nCU : Consulter liste des employés d'un département");
		System.out
				.println("1 - L'utilisateur fournit le nom du département [E-Technologies] ");
		System.out.println("2 - Le systéme affiche la liste des employés");
		DptDAO dao = new DptDAO();
		Set<Employe> lEmp = dao.getEmployesDe("E-Technologies");
		for (Employe e : lEmp) {
			System.out.println(e.getId() + ") " + e.getNom() + "["
					+ e.getEmail() + "]");
		}
		assertEquals(lEmp.isEmpty(), false);
	}
	
	public void testCUCreerUnEmploye() throws Exception {
		System.out.println("\nCU : Créer un nouvel employé");
		System.out.println("1 - L'utilisateur fournit le nom , l'email, et le téléphone de l'employé ['martin pecheur','mpec@plb.fr','01.64.23.58.96'] ");
		System.out.println("2 - Le systéme crée l'employe et affiche son ID");
		DptDAO dao = new DptDAO(); 
		Employe ne = dao.createEmploye("marin pecheur", "mpec@plb.fr","01.64.23.58.96" , new Date(), Genre.HOMME);
		System.out.println("Employé créé : " + ne.getId());
		// si on part de la base intiale, ça doit être le 3éme employé
		assertTrue(ne.getId() != 0);
	}
	
	public void testCUIntegrerEmployeDpt() throws Exception {
		System.out.println("\nCU : Intégrer un employé dans un département");
		System.out.println("1 - L'utilisateur fournit sélectionne l'employé et le département ['marin pecheur', 'Administration'] ");
		System.out.println("2 - Le systéme crée intégre l'employé dans le département");
		DptDAO dao = new DptDAO(); 
		EntityManager em = DBHelper.getFactory().createEntityManager();
		Employe marin = (Employe)em.find(Employe.class,new Long(3));
		Departement adm = (Departement)em.find(Departement.class, new Long(3));
		dao.integrateEmploye(marin, adm );
		
		Set<Employe> lemp = dao.getEmployesDe("Administration");
		// si on part de la base intiale, ça doit être le 1er employé de ce département
		assertEquals(lemp.size(),1);
	}
}
