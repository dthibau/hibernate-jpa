package formation.hib.tp4.dao;

public class DAOException extends Exception {

	private Exception nestedException;

	private String code;

	public DAOException(Exception nested, String c) {
		code = c;
		nestedException = nested;
	}

	public String toString() {
		return code + " : " + nestedException;
	}
}
