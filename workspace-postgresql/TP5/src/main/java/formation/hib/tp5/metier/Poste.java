package formation.hib.tp5.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tposte")
public class Poste {

	public Poste() {}
	
	public Poste(Employe employe, Mission mission) {
		this.employe = employe;
		this.mission = mission;
		
		mission.getPostes().add(this);
		employe.getPostes().add(this);
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private float charge;
	
	private String libelle;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idemp")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name = "idmission")
	private Mission mission;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	
}
