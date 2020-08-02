package service;

import dao.UpdateIspitDAO;
import model.Ispit;
import validacija.Validacija;

public class UpdateIspitService {
	
	UpdateIspitDAO dao = new UpdateIspitDAO();
	Validacija validacija = new Validacija();

	public Ispit vratiIspitSaOvimID(String idIspit) {
		return dao.vratiIspitSaOvimID(idIspit);
	}

	public boolean updateIspit(Ispit ispit) {
		return dao.updateIspit(ispit);
	}

	public boolean proveriDaLiJeBroj(String poeni) {
		return validacija.daLiJeBroj(poeni);
	}

}
