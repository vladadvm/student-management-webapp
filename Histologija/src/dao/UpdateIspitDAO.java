package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Ispit;

public class UpdateIspitDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public Ispit vratiIspitSaOvimID(String idIspit) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Ispit ispit = session.get(Ispit.class, Integer.parseInt(idIspit));
			session.getTransaction().commit();
			System.out.println("Evo ispit");
			return ispit;
		} catch (Exception e) {
			System.out.println("Nema ispit sa takvim id...");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	public boolean updateIspit(Ispit ispit) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.update(ispit);
			session.getTransaction().commit();
			System.out.println("Promenio sam podatke o " + ispit.getIdIspit());
			return true;
		} catch (Exception e) {
			System.out.println("Nisam promenio podatke o ispitu...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
}
