package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Poeni;
import model.Student;

public class DodajPoeneDAO {
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

	public boolean updatePromenjenogStudenta(Student student) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.update(student);
			session.getTransaction().commit();
			System.out.println("Promenio sam podatke o " + student.getIme());
			return true;
		} catch (Exception e) {
			System.out.println("Nisam promenio podatke o studentu...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}

	
	
}
