package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Poeni;
import model.Student;

public class FormirajOcenuDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public Student vratiStudentaSaOvimID(String idStudent) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Student student = session.get(Student.class, Integer.parseInt(idStudent));
			session.getTransaction().commit();
			return student;
		} catch (Exception e) {
			System.out.println("Nema student sa takvim id...");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	public boolean snimiPromenjenoPoene(Poeni poeni) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.update(poeni);
			session.getTransaction().commit();
			System.out.println("Promenio sam podatke");
			return true;
		} catch (Exception e) {
			System.out.println("Nisam promenio podatke..");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}

	public boolean snimiOcenu(int ocena, Student student) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			student.setOcena(ocena);
			session.update(student);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Nisam snimio ocenu...");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
}
