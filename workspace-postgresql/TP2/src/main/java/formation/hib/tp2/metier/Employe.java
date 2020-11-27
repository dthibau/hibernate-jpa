package formation.hib.tp2.metier;

import java.time.LocalDate;

public class Employe {
	// TODO d�clarer les attributs et les getter/setter n�cessaires
	long id;
	String nom, email, telephone;
	String genre;
	LocalDate entree;

	public Employe() {
	}

	public Employe(String nom, String email, String telephone) {
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getEntree() {
		return entree;
	}

	public void setEntree(LocalDate entree) {
		this.entree = entree;
	}

}
