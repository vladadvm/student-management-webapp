package service;

import dao.LoginDAO;
import model.Profesori;
import validacija.Validacija;

public class LoginService {

	LoginDAO dao = new LoginDAO();
	Validacija validacija = new Validacija();

	public Profesori vratiProfesoraSaOvimUsernameom(String username) {
		
		return dao.vratiProfesoraSaOvimUsernameom(username);
		
	}

	public boolean uporediPassworde(String password, String passwordProfesora) {
		
		return validacija.daliSuPasswordIRepeatedPasswordIsti(password, passwordProfesora);
	}
}
