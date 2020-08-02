package service;

import dao.PromeniPasswordDAO;
import model.Profesori;
import validacija.Validacija;

public class PromeniPasswordService {

	PromeniPasswordDAO dao = new PromeniPasswordDAO();
	Validacija validacija = new Validacija();

	public Profesori vratiProfesoraSaOvimID(String idProfesora) {
		return dao.vratiProfesoraSaOvimID(idProfesora);
	}

	public boolean uporediPassworde(String sadasnjiPassword, String passwordProfesora) {
		return validacija.daliSuPasswordIRepeatedPasswordIsti(sadasnjiPassword, passwordProfesora);
	}

	public boolean promeniPassword(String idProfesora, String noviPassword) {
		return dao.promeniPassword(idProfesora, noviPassword);
	}

	public boolean daLiJePasswordValidan(String noviPassword) {
		
		return validacija.daLiJePasswordValidan(noviPassword);
	}
	
}
