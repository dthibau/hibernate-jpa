package formation.hib.tp2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import formation.hib.tp2.dao.DBHelper;
import formation.hib.tp2.dao.DptDAO;
import formation.hib.tp2.metier.Departement;
import formation.hib.tp2.metier.Employe;

public class TP2Tests {
	
	DptDAO dao;
	
	@Before
	public void setUp() {
		dao = new DptDAO();
	}
	
	@Test
	public void testCUConsulterListeEmployesDpt() throws Exception {
		System.out
				.println("\nCU : Consulter liste des employés d'un département");
		System.out
				.println("1 - L'utilisateur fournit le nom du département [E-Technologies] ");
		System.out.println("2 - Le systéme affiche la liste des employés");
		
		Set<Employe> lEmp = dao.getEmployesDe("E-Technologies");

		lEmp.stream().forEach(System.out::println);

		assertEquals(lEmp.isEmpty(), false);
	}
	
	@Test
	public void testCUCreerUnEmploye() throws Exception {
		System.out.println("\nCU : Créer un nouvel employé");
		System.out.println("1 - L'utilisateur fournit le nom , l'email, et le téléphone de l'employé ['martin pecheur','mpec@plb.fr','01.64.23.58.96'] ");
		System.out.println("2 - Le systéme crée l'employe et affiche son ID");

		Employe ne = dao.createEmploye("marin pecheur", "mpec@plb.fr","01.64.23.58.96" );
		System.out.println("Employé créé : " + ne.getId());
		
		// si on part de la base intiale, ça doit étre le 3éme employé
		assertTrue(ne.getId() > 0);
	}
	
	@Test
	public void testCUIntegrerEmployeDpt() throws Exception {
		System.out.println("\nCU : Intégrer un employé dans un département");
		System.out.println("1 - L'utilisateur fournit sélectionne l'employé et le département ['marin pecheur', 'Administration'] ");
		System.out.println("2 - Le systéme crée intégre l'employé dans le département");
		
		Session s = DBHelper.getFactory().openSession();
		Employe marin = (Employe)s.get(Employe.class,3l);
		Departement adm = (Departement)s.get(Departement.class, 3l);
		Set<Employe> lemp = dao.getEmployesDe("Administration");
		
		dao.integrateEmploye(marin, adm );
		
		Set<Employe> afterlemp = dao.getEmployesDe("Administration");
		
		assertEquals(afterlemp .size(),lemp.size()+1);
	}
}
