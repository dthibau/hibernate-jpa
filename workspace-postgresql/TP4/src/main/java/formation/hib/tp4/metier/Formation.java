package formation.hib.tp4.metier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tformation")
public class Formation extends Mission {
	//TODO Compl�ter la classe Formation
	
	private String cours;
	
	public String getCours() {
		return cours;
	}
	public void setCours(String cours) {
		this.cours = cours;
	}

	
}
