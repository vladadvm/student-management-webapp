package razno;

import model.Ispit;
import model.Poeni;
import model.Profesori;
import model.Student;

public class Common {

	public Profesori kreirajProfesora(String ime, String prezime, String username, String password) {
		
		Profesori profesor = new Profesori();
		profesor.setImeProfesora(ime);
		profesor.setPrezimeProfesora(prezime);
		profesor.setUsernameProfesora(username);
		profesor.setPasswordProfesora(password);
		
		return profesor;
	}

	public Student napraviStudent(String ime, String prezime, String brojIndeksa, String grupa, String pol, Poeni poeni) {
		
		Student student = new Student();
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setBrojIndeksa(brojIndeksa);
		student.setGrupa(Integer.parseInt(grupa));
		student.setPol(pol);
		student.setPoeni(poeni);
		
		return student;
		
	}

	public Ispit napraviIspit(String daLiJeStudentIzasao, String daLiJeStudentPolozioPrakticniIspit,
			String daLiJeStudentPolozioUsmeniIspit, String ispitniRok, String datum, String poeniSaPrakticnogIspita,
			String poeniSaUsmenogIspita, String dodeljenProfesor) {
		
		Ispit ispit = new Ispit();
		
		if(daLiJeStudentIzasao != null) {
			ispit.setDaLiJeStudentIzasaoNaIspit(Boolean.parseBoolean(daLiJeStudentIzasao));
		}
		if(daLiJeStudentPolozioPrakticniIspit != null) {
			ispit.setDaLiJeStudentPolozioPrakticniIspit(Boolean.parseBoolean(daLiJeStudentPolozioPrakticniIspit));
		}
		if(daLiJeStudentPolozioUsmeniIspit != null) {
			ispit.setDaLiJeStudentPolozioUsmeniIspit(Boolean.parseBoolean(daLiJeStudentPolozioUsmeniIspit));
		}	
		if(ispitniRok != null) {
			ispit.setIspitniRok(ispitniRok);
		}
		if(datum != null) {
			ispit.setDatumOdrzavanjaIspita(datum);
		}
		if(!poeniSaPrakticnogIspita.isEmpty()) {
			ispit.setOsvojeniPoeniNaPrakticnom(Double.parseDouble(poeniSaPrakticnogIspita));
		}
		if(!poeniSaUsmenogIspita.isEmpty()) {
			ispit.setOsvojeniPoeniNaUsmenom(Double.parseDouble(poeniSaUsmenogIspita));
		}
		if(dodeljenProfesor != null) {
			ispit.setDodeljenProfesor(dodeljenProfesor);	
		}
	
		return ispit;	
	}

	public int napraviOcenu(double ukupniPoeni) {
		int ocena = 0;
		if(ukupniPoeni <= 50) {
			ocena = 5;
		}else if(ukupniPoeni <= 60) {
			ocena = 6;
		}else if(ukupniPoeni <= 70) {
			ocena = 7;
		}else if(ukupniPoeni <= 80) {
			ocena = 8;
		}else if(ukupniPoeni <= 90) {
			ocena = 9;
		}else if(ukupniPoeni <= 100) {
			ocena = 10;
		}
		return ocena;
	}

	
	

	

	

}
