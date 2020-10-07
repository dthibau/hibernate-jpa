package formation.hib.tp4.metier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tregie")
public class Regie extends Mission {
		
	private int taux;


	public int getTaux() {
		return taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}

}
