package formation.hib.tp8.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tmission")
@Inheritance(strategy=InheritanceType.JOINED)
public class Mission {
	@Id @GeneratedValue
	private Long id;
	private String libelle;
	private Date debut;
	private Date fin;
	@ManyToOne @JoinColumn(name="IDClient")
	private Client client;
	@OneToMany @JoinColumn(name="idMission")
	private Set<Poste> postes = new HashSet<Poste>();
	
	public Set<Poste> getPostes() {
		return postes;
	}
	public void setPostes(Set<Poste> postes) {
		this.postes = postes;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
