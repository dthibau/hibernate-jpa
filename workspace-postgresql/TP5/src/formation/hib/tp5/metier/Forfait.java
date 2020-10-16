package formation.hib.tp5.metier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tforfait")
public class Forfait extends Mission {
	private int prix;

	private String projet;

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
}
