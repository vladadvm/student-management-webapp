package service;

import dao.UpdateStudentDAO;
import model.Student;
import razno.Common;
import validacija.Validacija;

public class UpdateStudentService {

	UpdateStudentDAO dao = new UpdateStudentDAO();
	Common common = new Common();
	Validacija validacija = new Validacija();
	
	public Student vratiStudentaSaOvimID(String idStudent) {
		return dao.vratiStudentaSaOvimID(idStudent);
	}

	public boolean updatePromenjenogStudenta(Student student) {
		return dao.updatePromenjenogStudenta(student);
	}

	public boolean proveriDaLiJeBroj(String grupa) {
		return validacija.daLiJeBroj(grupa);
	}

	public boolean promeniPodatkeOStudentu(Student student, String ime, String prezime, String brojIndeksa,
			String grupa, String pol, String zabeleske, String ocena) {
		return common.promeniPodatkeOStudentu(student, ime, prezime, brojIndeksa, grupa, pol, zabeleske, ocena);
	}

	

}
