package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Profesori;

public class LoginDAO {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public Profesori vratiProfesoraSaOvimUsernameom(String username) {
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			List<Profesori> profesor = new ArrayList<Profesori>();
			String upit = "from Profesori where usernameProfesora = :username";
			Query query = session.createQuery(upit);
			query.setParameter("username", username);
			profesor =  query.getResultList();		
			if(profesor.size() == 0) {  
				System.out.println("ne postoji username");
				session.getTransaction().commit();
				return null;
			}else {
				System.out.println("Postoji username");
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
	
}
