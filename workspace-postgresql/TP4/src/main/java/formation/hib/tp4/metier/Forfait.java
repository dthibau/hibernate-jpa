package formation.hib.tp4.metier;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tforfait")
@PrimaryKeyJoinColumn(name = "IDFORFAIT", referencedColumnName = "ID")
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
