package formation.hib.tp2.metier;

import java.util.HashSet;
import java.util.Set;

public class Departement {
	//TODO écrire les attributs et leur getter/setter nécessaires
	// employes est l'attribut contenant les employés.
	long id;
	String code,nom;
	
	Set<Employe> employes = new HashSet<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public void integreEmploye(Employe e){
		employes.add(e);
	}
	
	public void retireEmploye(Employe e){
		employes.remove(e);
	}
	
	
	
}
