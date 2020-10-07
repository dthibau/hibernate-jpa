package formation.hib.tp6.metier;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tregie")
@PrimaryKeyJoinColumn(name = "IDRegie", referencedColumnName = "ID")
public class Regie extends Mission {
	private int taux;

	public int getTaux() {
		return taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}

}
