package formation.hib.tp1.metier;

import java.util.ArrayList;
import java.util.List;

public class Departement {
	private int id;
	private String nom;
	private String code;
	private List<Employe> employes = new ArrayList<Employe>();
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	
}
