package formation.hib.tp3.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "tdpt")
public class Departement {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nom;
	@NotEmpty
	private String code;
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="IDDpt")
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
