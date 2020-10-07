package formation.hib.tp9.util;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

public class Logging {

	@PostPersist
	public void insertion(Object entite) {
		System.out.println("\tINSERTION de "+entite.getClass().getName() + " : " + entite);
	}
	
	@PostLoad
	public void chargement(Object entite) {
		System.out.println("\tCHARGEMENT de "+entite.getClass().getName() + " : " + entite);
	}
	
	@PostRemove
	public void suppression(Object entite) {
		System.out.println("\tSUPPRESSION de "+entite.getClass().getName() + " : " + entite);
	}
	
	@PostUpdate
	public void maj(Object entite) {
		System.out.println("\tMAJ de "+entite.getClass().getName() + " : " + entite);
	}
}
