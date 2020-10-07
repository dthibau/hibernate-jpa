package formation.hib.tp1.dao;

public class DAOException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -504564776797861359L;

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
