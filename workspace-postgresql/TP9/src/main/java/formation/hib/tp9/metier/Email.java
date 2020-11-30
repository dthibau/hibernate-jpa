package formation.hib.tp9.metier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {

	@Column(name = "adresse")
	private String adresse;

	public Email() {}
	
	public Email(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDomainName() {
		if (adresse != null && adresse.length() > 0 && adresse.indexOf("@") != -1) {
			return adresse.split("@")[1];
		}
		return "";
	}

}
