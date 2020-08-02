package service;

import dao.DodajPoeneDAO;
import model.Student;
import razno.Common;
import validacija.Validacija;

public class DodajPoeneService {

	DodajPoeneDAO dao = new DodajPoeneDAO();
	Validacija validacija = new Validacija();
	

	public Student vratiStudentaSaOvimID(String idStudent) {
		return dao.vratiStudentaSaOvimID(idStudent);
	}

	public boolean updatePromenjenogStudenta(Student student) {
		return dao.updatePromenjenogStudenta(student);
	}

	public boolean proveriDaLiJeBroj(String poeni) {
		return validacija.daLiJeBroj(poeni);
	}

	
}
