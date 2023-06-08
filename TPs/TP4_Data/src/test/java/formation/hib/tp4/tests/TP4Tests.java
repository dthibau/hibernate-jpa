package formation.hib.tp4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import formation.hib.tp4.dao.MissionDAO;
import formation.hib.tp4.metier.Mission;
import formation.hib.tp4.metier.Regie;

public class TP4Tests  {
	MissionDAO dao;
	
	@Before
	public void setUp() {
		dao = new MissionDAO();
	}
	
	@Test
	public void testCUConsulterListeMissions() throws Exception {
		System.out
				.println("\nCU : Consulter liste des missions");
		System.out
				.println("1 - L'utilisateur demande la liste des missions ");
		System.out.println("2 - Le système affiche la liste des missions");

		List<Mission> lMission = dao.getAllMissions();
		lMission.stream().forEach(System.out::println);
		assertFalse(lMission.isEmpty());
	}
	
	@Test
	public void testCUConsulterListeMissionsDeType() throws Exception {
		System.out
				.println("\nCU : Consulter liste des missions d'un type donné");
		System.out
				.println("1 - L'utilisateur sélectionne un type [Regie] ");
		System.out.println("2 - Le système affiche la liste des régies");

		List<Mission> lMission = dao.getAllMissionsDeType(Regie.class);
		for (Mission m : lMission) {
			Regie current = (Regie)m;
			System.out.println(current);
		}
		assertEquals(lMission.isEmpty(), false);
	}
	
	@Test
	public void testCUCreerUneRegie() throws Exception {
		System.out
				.println("\nCU : Créer une nouvelle régie");
		System.out
				.println("1 - L'utilisateur sélectionne un type [Regie] ");
		System.out.println("2 - L'utilisateur fournit les libelle, date de début, de fin et le taux\n"+
				 " ['Conseil Banquaire','2004-08-14','2005-03-15','10']");
		System.out.println("3 - Le systéme crée une nouvelle régie");
		//TODO Créer une nouvelle régie et rendez la persistente
		
		//TODO Vérifier qu'une nouvelle mission a bien été insérée
		
	}
	
	private Date computeDate(int day, int month,int year){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,day);
		c.set(Calendar.MONTH,month - 1);
		c.set(Calendar.YEAR,year);
		return c.getTime();
	}
	
}
