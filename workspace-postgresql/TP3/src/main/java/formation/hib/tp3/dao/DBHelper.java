package formation.hib.tp3.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {

	private static EntityManagerFactory factory = null;

	static {
			// A compléter
			factory = Persistence.createEntityManagerFactory("ssii");
		
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
}
