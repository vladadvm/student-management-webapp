package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory createSessionFactory() {
		
		//ovde try catch ako ne nadje konfiguracioni fajl
		return new Configuration().configure().buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		
		if(factory == null) {
			factory = createSessionFactory();
		}
		
		return factory;
	}
	
	
}
