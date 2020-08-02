package service;

import model.Profesori;
import razno.Common;
import dao.RegistrationDAO;
import validacija.Validacija;

public class RegistrationService {
	
	RegistrationDAO dao = new RegistrationDAO();
	Validacija validacija = new Validacija();
	Common common = new Common();

	public boolean daliSuPasswordIRepeatedPasswordIsti(String password, String repeatedPassword) {
		
		return validacija.daliSuPasswordIRepeatedPasswordIsti(password, repeatedPassword);
	}

	public boolean daLiPasswordImaMinOsamKaraktera(String password) {
		
		return validacija.daLiJePasswordValidan(password);
	}

	public Profesori kreirajProfesora(String ime, String prezime, String username, String password) {
		
		return common.kreirajProfesora(ime, prezime, username, password);
		
	}

	public boolean daLiJeSacuvanProfesor(Profesori profesor) {
		return dao.sacuvajProfesora(profesor);
	}

	



	

}
