package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Profesori;
import model.Student;

public class PromeniPasswordDAO {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public Profesori vratiProfesoraSaOvimID(String idProfesora) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			List<Profesori> profesor = new ArrayList<Profesori>();
			String upit = "from Profesori where idProfesora = :id";
			Query query = session.createQuery(upit);
			query.setParameter("id", Integer.parseInt(idProfesora));
			profesor =  query.getResultList();		
			if(profesor.size() == 0) {  
				System.out.println("ne postoji taj profesor");
				session.getTransaction().commit();
				return null;
			}else {
				System.out.println("Postoji profesor");
				session.getTransaction().commit();
				return profesor.get(0);
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
		
	}

	public boolean promeniPassword(String idProfesora, String noviPassword) {
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			Profesori profesor = session.get(Profesori.class, Integer.parseInt(idProfesora));
			profesor.setPasswordProfesora(noviPassword);
			session.update(profesor);
			session.getTransaction().commit();
			System.out.println("Promenio sam profesorov password " + profesor.getImeProfesora());
			return true;
		}catch(Exception e) {
			System.out.println("Nisam promenio nista...");
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		
		
		
	}
}
