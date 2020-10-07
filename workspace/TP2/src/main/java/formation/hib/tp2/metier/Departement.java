package formation.hib.tp2.metier;

import java.util.HashSet;
import java.util.Set;

public class Departement {
	private Long id;
	private String nom;
	private String code;
	private Set<Employe> employes = new HashSet<Employe>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	public void integreEmploye(Employe e){
		employes.add(e);
	}
	
	public void retireEmploye(Employe e){
		employes.remove(e);
	}
	public Set<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}
	
	
}
