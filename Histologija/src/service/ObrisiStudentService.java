package service;

import dao.ObrisiStudentDAO;

public class ObrisiStudentService {
	ObrisiStudentDAO dao = new ObrisiStudentDAO();

	public boolean obrisiIspitSaOvimID(String idStudent) {
		return dao.obrisiIspitSaOvimID(idStudent);
	}
}
