package formation.hib.tp9.metier;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="tforfait")
@PrimaryKeyJoinColumn(name = "IDFORFAIT", referencedColumnName = "ID")
public class Forfait extends Mission {
	private int prix;

	private String projet;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="IDFORFAIT")
	@MapKey(name="libelle")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	Map<String,Tache> taches = new HashMap<>();


	public void addTache(Tache tache) {
		taches.put(tache.getLibelle(), tache);
	}
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public Map<String, Tache> getTaches() {
		return taches;
	}

	public void setTaches(Map<String, Tache> taches) {
		this.taches = taches;
	}


	
}
