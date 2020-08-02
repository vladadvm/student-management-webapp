package service;

import dao.DodajIspitDAO;
import model.Ispit;
import razno.Common;
import validacija.Validacija;

public class DodajIspitService {
	DodajIspitDAO dao = new DodajIspitDAO();
	Common common = new Common();
	Validacija validacija = new Validacija();

	public Ispit napraviIspit(String daLiJeStudentIzasao, String daLiJeStudentPolozioPrakticniIspit, 
			String daLiJeStudentPolozioUsmeniIspit, String ispitniRok, String datum, String poeniSaPrakticnogIspita,
			String poeniSaUsmenogIspita, String dodeljenProfesor) {
		
		return common.napraviIspit(daLiJeStudentIzasao, daLiJeStudentPolozioPrakticniIspit, daLiJeStudentPolozioUsmeniIspit,  
				ispitniRok,  datum,  poeniSaPrakticnogIspita, poeniSaUsmenogIspita, dodeljenProfesor);
	}

	public boolean dodajOvajIspitUListuIspitaStudentaSaOvimID(String idStudent, Ispit ispit) {
		return dao.dodajOvajIspitUListuIspitaStudentaSaOvimID(idStudent, ispit);
	}

	public boolean proveriDaLiJeBroj(String poeni) {
		return validacija.daLiJeBroj(poeni);
	}

	
}
