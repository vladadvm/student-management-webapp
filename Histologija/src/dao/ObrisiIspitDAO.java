package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Ispit;

public class ObrisiIspitDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean obrisiIspitSaOvimID(String idIspit) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Ispit ispit = session.get(Ispit.class, Integer.parseInt(idIspit));
			session.delete(ispit);
			System.out.println("Obrisao sam ispita sa id " + ispit.getIdIspit());
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam obrisao sam ispit...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
}
