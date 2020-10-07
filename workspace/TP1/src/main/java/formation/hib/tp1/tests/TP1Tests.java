package formation.hib.tp1.tests;

import java.util.List;

import formation.hib.tp1.dao.DptDAO;
import formation.hib.tp1.metier.Employe;

import junit.framework.TestCase;

public class TP1Tests extends TestCase {
	public void testCUConsulterListeEmployesDpt() throws Exception {
		System.out.println("\nCU : Consulter liste des employés d'un département");
		System.out.println("1 - L'utilisateur fournit le nom du département [E-Technologies] ");
		System.out.println("2 - Le système affiche la liste des employés");
		DptDAO dao = new DptDAO(); 
		List<Employe> lEmp = dao.getEmployesDe("E-Technologies");
		for(Employe e : lEmp){
			System.out.println(e.getId() + ") " + e.getNom() + "[" + e.getEmail() +"]");
		}
		assertEquals(lEmp.isEmpty(),false);
	}
	
	public void testCUCreerUnEmploye() throws Exception {
		System.out.println("\nCU : Créer un nouvel employé");
		System.out.println("1 - L'utilisateur fournit le nom , l'email, et le téléphone de l'employé ['martin pecheur','mpec@tsystems.fr','01.64.23.58.96'] ");
		System.out.println("2 - Le systéme crée l'employe et affiche son ID");
		DptDAO dao = new DptDAO(); 
		int id = dao.createEmploye("marin pecheur", "mpec@tsystems.fr","01.64.23.58.96" );
		System.out.println("Employé créé : " + id);
		// si on part de la base intiale, éa doit étre le 3éme employé
		assertEquals(id,3);
	}
	
	public void testCUIntegrerEmployeDpt() throws Exception {
		System.out.println("\nCU : Intégrer un employé dans un département");
		System.out.println("1 - L'utilisateur fournit l'id de l'employé et le nom du département [3, 'Administration'] ");
		System.out.println("2 - Le systéme crée intégre l'employé dans le département");
		DptDAO dao = new DptDAO(); 
		dao.integrateEmploye(3,"Administration" );
		
		List<Employe> lemp = dao.getEmployesDe("Administration");
		// si on part de la base intiale, éa doit étre le 1er employé de ce département
		assertEquals(lemp.size(),1);
	}
}
