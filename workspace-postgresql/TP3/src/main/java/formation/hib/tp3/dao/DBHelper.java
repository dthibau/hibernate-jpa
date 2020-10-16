package formation.hib.tp3.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {

	private static EntityManagerFactory factory = null;

	static {
		try {
			// A compléter
			factory = Persistence.createEntityManagerFactory("ssii");
		} catch (HibernateException e) {
			System.err
					.println("problème d'obtention d'une entityManager factory Hibernate/JPA");
			throw e;
		}
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
}
