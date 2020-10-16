package formation.hib.tp2.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {
	private static Configuration cfg = null;

	private static SessionFactory factory = null;

	static {
		//TODO créer la factory
		cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
