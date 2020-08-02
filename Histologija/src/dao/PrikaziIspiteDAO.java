package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Student;

public class PrikaziIspiteDAO {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public Student vratiStudentaSaOvimID(String idStudent) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Student student = session.get(Student.class, Integer.parseInt(idStudent));
			session.getTransaction().commit();
			System.out.println("Nasao sam studenta");
			return student;
		} catch (Exception e) {
			System.out.println("Nisam nasao studenta");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}
	
}
