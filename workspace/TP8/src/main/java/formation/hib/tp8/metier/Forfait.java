package formation.hib.tp8.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tforfait")
@PrimaryKeyJoinColumn(name = "IDFORFAIT", referencedColumnName = "ID")
public class Forfait extends Mission {
	private int prix;

	private String projet;

	@OneToMany(cascade=CascadeType.ALL ,orphanRemoval=true)
	@JoinColumn(name="IDForfait")
	private List<Tache> taches = new ArrayList<Tache>();

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


	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	
	public void addTache(Tache t) {
		taches.add(t);
//		t.setForfait(this);
	}
	
}
