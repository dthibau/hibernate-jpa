package formation.hib.tp1.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import formation.hib.tp1.dao.DptDAO;
import formation.hib.tp1.metier.Employe;

public class TP1Tests {
	DptDAO dao;
	
	@Before
	public void setUp() {
		dao = new DptDAO();
	}
	@Test
	public void testCUConsulterListeEmployesDpt() throws Exception {
		System.out.println("\nCU : Consulter liste des employés d'un département");
		System.out.println("1 - L'utilisateur fournit le nom du département [E-Technologies] ");
		System.out.println("2 - Le système affiche la liste des employés");
 
		List<Employe> lEmp = dao.getEmployesDe("E-Technologies");
		for(Employe e : lEmp){
			System.out.println(e.getId() + ") " + e.getNom() + "[" + e.getEmail() +"]");
		}

		assertEquals(lEmp.isEmpty(),false);
	}
	
	@Test
	public void testCUCreerUnEmploye() throws Exception {
		System.out.println("\nCU : Créer un nouvel employé");
		System.out.println("1 - L'utilisateur fournit le nom , l'email, et le téléphone de l'employé ['martin pecheur','mpec@tsystems.fr','01.64.23.58.96'] ");
		System.out.println("2 - Le système crée l'employe et affiche son ID");

		int id = dao.createEmploye("marin pecheur", "mpec@tsystems.fr","01.64.23.58.96" );
		System.out.println("Employé créé : " + id);

		assertTrue(id > 0);
	}
	
	@Test
	public void testCUIntegrerEmployeDpt() throws Exception {
		System.out.println("\nCU : Intégrer un employé dans un département");
		System.out.println("1 - L'utilisateur fournit l'id de l'employé et le nom du département [3, 'Administration'] ");
		System.out.println("2 - Le système crée intègre l'employé dans le département");
		
		List<Employe> lemp = dao.getEmployesDe("Administration");
		dao.integrateEmploye(3,"Administration" );
		
		List<Employe> afterLemp = dao.getEmployesDe("Administration");

		assertEquals(afterLemp.size(),lemp.size()+1);
	}
}
