package formation.hib.tp8.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="temploye")
public class Employe {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	@Embedded
	@AttributeOverride(name="adresse",
	column=@Column(name="email"))
	private Email email;
	@Column(name="tel")
	private String telephone;
	@OneToMany(mappedBy="emp")
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
	
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
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

	
	
}

