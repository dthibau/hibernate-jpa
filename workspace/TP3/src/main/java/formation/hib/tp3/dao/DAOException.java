package formation.hib.tp3.dao;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2872777813161441439L;

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
