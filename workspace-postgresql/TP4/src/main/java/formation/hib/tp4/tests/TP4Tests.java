package formation.hib.tp4.tests;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import formation.hib.tp4.dao.MissionDAO;
import formation.hib.tp4.metier.Mission;
import formation.hib.tp4.metier.Regie;
import junit.framework.TestCase;

public class TP4Tests extends TestCase {
	public void testCUConsulterListeMissions() throws Exception {
		System.out
				.println("\nCU : Consulter liste des missions");
		System.out
				.println("1 - L'utilisateur demande la liste des missions ");
		System.out.println("2 - Le système affiche la liste des missions");
		MissionDAO dao = new MissionDAO();
		List<Mission> lMission = dao.getAllMissions();
		lMission.stream().forEach(System.out::println);
		assertEquals(lMission.isEmpty(), false);
	}
	
	public void testCUConsulterListeMissionsDeType() throws Exception {
		System.out
				.println("\nCU : Consulter liste des missions d'un type donné");
		System.out
				.println("1 - L'utilisateur sélectionne un type [Regie] ");
		System.out.println("2 - Le système affiche la liste des régies");
		MissionDAO dao = new MissionDAO();
		List<Mission> lMission = dao.getAllMissionsDeType(Regie.class);
		for (Mission m : lMission) {
			Regie current = (Regie)m;
			System.out.println(current);
		}
		assertEquals(lMission.isEmpty(), false);
	}
	
	public void testCUCreerUneRegie() throws Exception {
		System.out
				.println("\nCU : Créer une nouvelle régie");
		System.out
				.println("1 - L'utilisateur sélectionne un type [Regie] ");
		System.out.println("2 - L'utilisateur fournit les libelle, date de début, de fin et le taux\n"+
				 " ['Conseil Banquaire','2004-08-14','2005-03-15','10']");
		System.out.println("3 - Le systéme crée une nouvelle régie");
		
		MissionDAO dao = new MissionDAO();
		
		int initialSize = dao.getAllMissionsDeType(Regie.class).size();
		
		Regie r = new Regie();
		r.setLibelle("Conseil Banquaire");
		r.setTaux(10);
		r.setDebut(LocalDate.of(2020, 8, 14));
		r.setFin(LocalDate.of(2021, 3, 15));
		
		dao.creerMission(r);
		
		List<Mission> lMission = dao.getAllMissions();
		
		lMission.stream().forEach(System.out::println);

		assertEquals(initialSize+1, dao.getAllMissionsDeType(Regie.class).size());
		
	}
	

	
}
