package formation.hib.tp5.metier;

import java.util.Date;
import java.util.List;

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
	private long id;
	private String nom;
	private String email;
	@Column(name="tel")
	private String telephone;
	@Temporal(TemporalType.DATE)
	private Date entree;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@OneToMany(mappedBy = "employe")
	private List<Poste> postes;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public List<Poste> getPostes() {
		return postes;
	}
	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}
	
}

