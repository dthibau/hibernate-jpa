package formation.hib.tp6.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="temploye")
public class Employe {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date entree;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Column(name="tel")
	private String telephone;
	@OneToMany(mappedBy="employe")
	private Set<Poste> postes = new HashSet<Poste>();
	
	public Set<Poste> getPostes() {
		return postes;
	}

	public void setPostes(Set<Poste> postes) {
		this.postes = postes;
	}

	public void addPoste(Poste p){
		postes.add(p);
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getEntree() {
		return entree;
	}

	public void setEntree(Date entree) {
		this.entree = entree;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}

