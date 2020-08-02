package service;

import model.Poeni;
import model.Student;
import razno.Common;
import dao.FormirajOcenuDAO;

public class FormirajOcenuService {
	FormirajOcenuDAO dao = new FormirajOcenuDAO();
	Common common = new Common();

	public Student vratiStudentaSaOvimID(String idStudent) {
		return dao.vratiStudentaSaOvimID(idStudent);
	}

	public int napraviOcenu(double ukupniPoeni) {
		return common.napraviOcenu(ukupniPoeni);
	}

	public boolean snimiPromenjenoPoene(Poeni poeni) {
		return dao.snimiPromenjenoPoene(poeni);
	}

	public boolean snimiOcenu(int ocena, Student student) {
		return dao.snimiOcenu(ocena, student);
	}
}
