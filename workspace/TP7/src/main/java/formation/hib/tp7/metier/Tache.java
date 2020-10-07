package formation.hib.tp7.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ttache")
public class Tache {

	@Id @GeneratedValue
	private long id;
	private String libelle;
	private int charge;
//	@ManyToOne
//	@JoinColumn(name="IDForfait")
//	private Forfait forfait;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
//	public Forfait getForfait() {
//		return forfait;
//	}
//	public void setForfait(Forfait forfait) {
//		this.forfait = forfait;
//	}
	
	
}
