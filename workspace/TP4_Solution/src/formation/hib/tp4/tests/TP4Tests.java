package formation.hib.tp4.tests;

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
		for (Mission m : lMission) {
			System.out.println(m.getId() + ") " + m.getLibelle());
		}
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
			System.out.println(current.getId() + ") " + current.getLibelle() + " "
					+ current.getDebut() + "  " + 
					current.getFin() + " de taux : " + current.getTaux());
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
		Regie r = new Regie();
		r.setLibelle("Conseil Banquaire");
		r.setTaux(10);
		r.setDebut(computeDate(14,8,2004));
		r.setFin(computeDate(15,3,2005));
		MissionDAO dao = new MissionDAO();
		dao.creerMission(r);
		List<Mission> lMission = dao.getAllMissions();
		for (Mission m : lMission) {
			System.out.println(m.getId() + ") " + m.getLibelle());
		}
		// si on part de la base initiale et que l'on effectue les tests dans l'ordre
		// il y a 4 missions en base à ce moment la si on a fait la classe Forfait.
		assertEquals(lMission.size(), 4);
	}
	
	private Date computeDate(int day, int month,int year){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,day);
		c.set(Calendar.MONTH,month - 1);
		c.set(Calendar.YEAR,year);
		return c.getTime();
	}
	
}
