package formation.hib.tp9.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="tdpt")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,region="Departement")
@NamedQuery(name = "grandDepartement",
query = "SELECT d FROM Departement d where d.employes.size > 1",
hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true"), @QueryHint(name="org.hibernate.cacheMode", value="NORMAL")
, @QueryHint(name="org.hibernate.cacheRegion",value="Queries")})
public class Departement {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String code;

	@OneToMany
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
