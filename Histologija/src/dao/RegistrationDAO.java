package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Profesori;


public class RegistrationDAO {

	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public boolean sacuvajProfesora(Profesori profesor) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.save(profesor);
			System.out.println("Sacuvao sam profesora: " + profesor.getUsernameProfesora());
			session.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Nisam sacuvao profesora...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}

	

}
