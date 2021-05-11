package formation.hib.tp6.metier;

import javax.persistence.Column;
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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne @JoinColumn(name="IdEmp")
	private Employe employe;
	@ManyToOne @JoinColumn(name="IdMission")
	private Mission mission;
	private String libelle;
	//@Lob
        @Column(columnDefinition = "clob")
	private String description;
	private float charge; // nb jours / semaine
	
	protected Poste(){}
	
	public Poste(Employe e, Mission m){
		employe = e;
		employe.addPoste(this);
		mission = m;
	}
	
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
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
	public void setEmploye(Employe emp) {
		this.employe = emp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	

}
