package formation.hib.tp7.metier;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Email {
	private String adresse;
	
	public Email() {
		super();
	}
	public Email(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Transient
	public String getDomainName(){
		if ( adresse != null && adresse.length() > 0 ) {
		 return adresse.split("@")[1];
		}
		return null;
	}
	
	public String toString(){
		return adresse;
	}

}
