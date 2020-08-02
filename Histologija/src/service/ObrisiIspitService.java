package service;

import dao.ObrisiIspitDAO;

public class ObrisiIspitService {

	ObrisiIspitDAO dao = new ObrisiIspitDAO();

	public boolean obrisiIspitSaOvimID(String idIspit) {
		return dao.obrisiIspitSaOvimID(idIspit);
	}
}
