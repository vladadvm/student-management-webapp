package service;

import java.util.List;

import dao.ProfesorStudentDAO;
import model.Student;

public class ProfesorStudentService {

	ProfesorStudentDAO dao = new ProfesorStudentDAO();

	public List<Student> vratiSveStudenteIzBaze() {
		return dao.vratiSveStudenteIzBaze();
	}
	
}
