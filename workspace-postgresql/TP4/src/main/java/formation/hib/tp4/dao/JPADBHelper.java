package formation.hib.tp4.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class JPADBHelper {

	private static EntityManagerFactory factory = null;

	static {
		try {
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
