package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Ispit;
import model.Student;

public class DodajIspitDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	

	public boolean dodajOvajIspitUListuIspitaStudentaSaOvimID(String idStudent, Ispit ispit) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Student student = session.get(Student.class, Integer.parseInt(idStudent));
			student.getIspiti().add(ispit);
			session.update(student);
			session.getTransaction().commit();
			System.out.println("Uspeo sam da spojim studenta i ispita");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nisam uspeo da dodam...");
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
