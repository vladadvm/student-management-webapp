package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Student;


public class ProfesorStudentDAO {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public List<Student> vratiSveStudenteIzBaze() {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			List<Student> studenti = new ArrayList<>();
			String upit = "from Student";
			Query query = session.createQuery(upit);
			studenti= query.getResultList();		
			if(studenti.size() == 0) {  
				System.out.println("ne postoje studenti");
				session.getTransaction().commit();
				return null;
			}else {
				System.out.println("Evo studenta iz baze");
				session.getTransaction().commit();
				return studenti;
			}
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
}
