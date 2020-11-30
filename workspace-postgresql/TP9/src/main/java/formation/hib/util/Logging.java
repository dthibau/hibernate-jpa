package formation.hib.util;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

public class Logging implements SaveOrUpdateEventListener, LoadEventListener {

	public void onSaveOrUpdate(SaveOrUpdateEvent arg0) throws HibernateException {
		System.out.println("SAVE EVENT "+ arg0);
		
	}

	public void onLoad(LoadEvent arg0, LoadType arg1) throws HibernateException {
		System.out.println("LOAD EVENT "+ arg0 + " type "+ arg1);
		
	}

	
}
