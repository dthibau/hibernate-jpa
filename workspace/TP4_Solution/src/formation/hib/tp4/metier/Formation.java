package formation.hib.tp4.metier;

public class Formation extends Mission {
	private String cours;
	private int type;
	public String getCours() {
		return cours;
	}
	public void setCours(String cours) {
		this.cours = cours;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
