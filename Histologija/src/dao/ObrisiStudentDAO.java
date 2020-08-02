package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Student;

public class ObrisiStudentDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public boolean obrisiIspitSaOvimID(String idStudent) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Student student = session.get(Student.class, Integer.parseInt(idStudent));
			session.delete(student);
			System.out.println("Obrisao sam studenta " + student.getIme());
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam obrisao studenta...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
}
