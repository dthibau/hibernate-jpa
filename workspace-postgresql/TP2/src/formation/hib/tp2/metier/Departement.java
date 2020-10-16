package formation.hib.tp2.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Departement {
	//TODO écrire les attributs et leur getter/setter nécessaires
	// employes est l'attribut contenant les employés.
	
	public void integreEmploye(Employe e){
		employes.add(e);
	}
	
	public void retireEmploye(Employe e){
		employes.remove(e);
	}
	
	
	
}
