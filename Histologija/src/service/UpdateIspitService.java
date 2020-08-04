package service;

import dao.UpdateIspitDAO;
import model.Ispit;
import razno.Common;


public class UpdateIspitService {
	
	UpdateIspitDAO dao = new UpdateIspitDAO();
	Common common = new Common();

	public Ispit vratiIspitSaOvimID(String idIspit) {
		return dao.vratiIspitSaOvimID(idIspit);
	}

	public boolean updateIspit(Ispit ispit) {
		return dao.updateIspit(ispit);
	}

	public boolean promeniPodatkeOIspitu(Ispit ispit, String checkIzasao, String checkPolozioPrakticni,
			String checkPolozioUsmeni, String rok, String datum, String poeniNaPrakticnom, String poeniNaUsmenom,
			String profesor) {
		return common.promeniPodatkeOIspitu(ispit, checkIzasao, checkPolozioPrakticni,
				checkPolozioUsmeni, rok, datum, poeniNaPrakticnom, poeniNaUsmenom, profesor);
	}

}
