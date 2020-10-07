package formation.hib.tp6.dao;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4208078317049867975L;

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
