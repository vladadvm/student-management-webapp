package service;

import model.Poeni;
import model.Student;
import razno.Common;
import validacija.Validacija;
import dao.DodajStudentDAO;

public class DodajStudentService {
	
	DodajStudentDAO dao = new DodajStudentDAO();
	Common common = new Common();
	Validacija validacija = new Validacija();

	public Student napraviStudent(String ime, String prezime, String brojIndeksa, String grupa, String pol, Poeni poeni) {
		
		return common.napraviStudent(ime, prezime, brojIndeksa, grupa, pol, poeni);
		
	}

	public boolean sacuvajStudent(Student student) {
		
		return dao.sacuvajStudent(student);
		
	}

	public boolean proveriDaLiJeBroj(String grupa) {
		return validacija.daLiJeBroj(grupa);
	}

}
