package formation.hib.tp9.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;

import formation.hib.util.Logging;

public class DBHelper {

	private static EntityManagerFactory factory = null;

	static {
		try {
			factory = Persistence.createEntityManagerFactory("ssii");
			Logging logging = new  Logging();
			SessionFactoryImplementor sessionFactory = factory.unwrap( SessionFactoryImplementor.class );
			sessionFactory
				.getServiceRegistry()
				.getService( EventListenerRegistry.class )
				.prependListeners( EventType.LOAD,logging  );
			sessionFactory
			.getServiceRegistry()
			.getService( EventListenerRegistry.class )
			.prependListeners( EventType.SAVE_UPDATE,logging  );				

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
