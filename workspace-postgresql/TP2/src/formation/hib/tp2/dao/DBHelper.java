package formation.hib.tp2.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {
	private static Configuration cfg = null;

	private static SessionFactory factory = null;

	static {
		//TODO créer la factory
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
