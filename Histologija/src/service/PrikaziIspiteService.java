package service;

import dao.PrikaziIspiteDAO;
import model.Student;

public class PrikaziIspiteService {

	PrikaziIspiteDAO dao = new PrikaziIspiteDAO();

	public Student vratiStudentaSaOvimID(String idStudent) {
		return dao.vratiStudentaSaOvimID(idStudent);
	}
	
}
