package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Student;

public class DodajStudentDAO {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean sacuvajStudent(Student student) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.save(student);
			System.out.println("Sacuvao sam studenta: " + student.getIme());
			session.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Nisam sacuvao studenta...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	
}
