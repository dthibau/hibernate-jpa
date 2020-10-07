package formation.hib.tp1.tests;

import java.util.List;

import formation.hib.tp1.dao.DptDAO;
import formation.hib.tp1.metier.Employe;

import junit.framework.TestCase;

public class TP1Tests extends TestCase {
	public void testCUConsulterListeEmployesDpt() throws Exception {
		System.out.println("\nCU : Consulter liste des employ�s d'un d�partement");
		System.out.println("1 - L'utilisateur fournit le nom du d�partement [E-Technologies] ");
		System.out.println("2 - Le syst�me affiche la liste des employ�s");
		DptDAO dao = new DptDAO(); 
		List<Employe> lEmp = dao.getEmployesDe("E-Technologies");
		for(Employe e : lEmp){
			System.out.println(e.getId() + ") " + e.getNom() + "[" + e.getEmail() +"]");
		}
		assertEquals(lEmp.isEmpty(),false);
	}
	
	public void testCUCreerUnEmploye() throws Exception {
		System.out.println("\nCU : Cr�er un nouvel employ�");
		System.out.println("1 - L'utilisateur fournit le nom , l'email, et le t�l�phone de l'employ� ['martin pecheur','mpec@tsystems.fr','01.64.23.58.96'] ");
		System.out.println("2 - Le syst�me cr�e l'employe et affiche son ID");
		DptDAO dao = new DptDAO(); 
		int id = dao.createEmploye("marin pecheur", "mpec@tsystems.fr","01.64.23.58.96" );
		System.out.println("Employ� cr�� : " + id);
		// si on part de la base initiale, �a doit �tre le 3�me employ�
		assertEquals(id,3);
	}
	
	public void testCUIntegrerEmployeDpt() throws Exception {
		System.out.println("\nCU : Int�grer un employ� dans un d�partement");
		System.out.println("1 - L'utilisateur fournit l'id de l'employ� et le nom du d�partement [3, 'Administration'] ");
		System.out.println("2 - Le syst�me cr�e int�gre l'employ� dans le d�partement");
		DptDAO dao = new DptDAO(); 
		dao.integrateEmploye(3,"Administration" );
		
		List<Employe> lemp = dao.getEmployesDe("Administration");
		// si on part de la base intiale, �a doit �tre le 1er employ� de ce d�partement
		assertEquals(lemp.size(),1);
	}
}
