package formation.hib.tp4.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CoreDBHelper {
	private static Configuration cfg = null;

	private static SessionFactory factory = null;

	static {
		try {
			cfg = new Configuration();
			factory = cfg.configure().buildSessionFactory();
		} catch (HibernateException e) {
			System.err
					.println("probl�me d'obtention d'une session factory Hibernate");
			throw e;
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
