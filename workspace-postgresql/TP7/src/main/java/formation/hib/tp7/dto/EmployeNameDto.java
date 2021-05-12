package formation.hib.tp7.dto;

public class EmployeNameDto {

	private String name, depatementName;
	
	public EmployeNameDto(String name, String depatementName) {
		this.name = name;
		this.depatementName = depatementName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepatementName() {
		return depatementName;
	}

	public void setDepatementName(String depatementName) {
		this.depatementName = depatementName;
	}
	
	
}
