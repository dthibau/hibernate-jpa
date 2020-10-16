package formation.hib.tp7.metier;

import javax.persistence.Embeddable;

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

	public String getDomainName(){
		String[] parts = adresse.split("@");
		return parts[1];
	}
	
	public String toString(){
		return adresse;
	}

}
