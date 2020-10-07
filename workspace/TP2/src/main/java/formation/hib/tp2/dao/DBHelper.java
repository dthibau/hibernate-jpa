package formation.hib.tp2.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {
	private static Configuration cfg = null;

	private static SessionFactory factory = null;

	static {
		try {
			cfg = new Configuration();
			factory = cfg.configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
