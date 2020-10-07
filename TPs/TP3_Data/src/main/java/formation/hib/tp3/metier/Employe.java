package formation.hib.tp3.metier;

import java.util.Date;



public class Employe {
	private Long id;
	private String nom;
	private String email;
	private String telephone;
	private Date entree;
	private Genre genre;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
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

