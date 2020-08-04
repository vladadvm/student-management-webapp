package service;

import dao.DodajPoeneDAO;
import model.Poeni;
import model.Student;
import razno.Common;
import validacija.Validacija;

public class DodajPoeneService {

	DodajPoeneDAO dao = new DodajPoeneDAO();
	Validacija validacija = new Validacija();
	Common common = new Common();
	

	public Student vratiStudentaSaOvimID(String idStudent) {
		return dao.vratiStudentaSaOvimID(idStudent);
	}

	public boolean updatePromenjenogStudenta(Student student) {
		return dao.updatePromenjenogStudenta(student);
	}

	public boolean dodajPoeneStudentu(String poeniNaIKol, String poeniNaIIKol, String poeniNaIIIKol,
			String poeniSaVezbi, String poeniSaPredavanja, Student student) {
		return common.dodajPoeneStudentu(poeniNaIKol, poeniNaIIKol, poeniNaIIIKol, poeniSaVezbi, poeniSaPredavanja, student);
	}

	

	
}
