package razno;

import model.Ispit;
import model.Poeni;
import model.Profesori;
import model.Student;
import validacija.Validacija;

public class Common {
	
	
	Validacija validacija = new Validacija();
	
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


	public boolean dodajPoeneStudentu(String poeniNaIKol, String poeniNaIIKol, String poeniNaIIIKol,
			String poeniSaVezbi, String poeniSaPredavanja, Student student) {
		
		boolean flag = false;
		boolean daLiJeBrojIKol = validacija.daLiJeBroj(poeniNaIKol);
        boolean daLiJeBrojIIKol = validacija.daLiJeBroj(poeniNaIIKol);
        boolean daLiJeBrojIIIKol = validacija.daLiJeBroj(poeniNaIIIKol);
        boolean daLiJeBrojVezbi = validacija.daLiJeBroj(poeniSaVezbi);
        boolean daLiJeBrojPredavanja = validacija.daLiJeBroj(poeniSaPredavanja);
        
		if(!poeniNaIKol.isEmpty() && daLiJeBrojIKol) {
        	student.getPoeni().setPoeniSaPrvogKolokvijuma(Double.parseDouble(poeniNaIKol));
        	flag = true;
        }
        if(!poeniNaIIKol.isEmpty() && daLiJeBrojIIKol) {
        	student.getPoeni().setPoeniSaDrugogKolokvijuma(Double.parseDouble(poeniNaIIKol));
        	flag = true;
        }
        if(!poeniNaIIIKol.isEmpty() && daLiJeBrojIIIKol) {
        	student.getPoeni().setPoeniSaTrecegKolokvijuma(Double.parseDouble(poeniNaIIIKol));
        	flag = true;
        }
        if(!poeniSaVezbi.isEmpty() && daLiJeBrojVezbi) {
        	student.getPoeni().setUkupanBrojPoenaSaVezbi(Double.parseDouble(poeniSaVezbi));
        	flag = true;
        }
        if(!poeniSaPredavanja.isEmpty() && daLiJeBrojPredavanja) {
        	student.getPoeni().setUkupniPoeniSaPredavanja(Integer.parseInt(poeniSaPredavanja));
        	flag = true;
        }
        
        return flag;
	}

	public boolean promeniPodatkeOIspitu(Ispit ispit, String checkIzasao, String checkPolozioPrakticni,
			String checkPolozioUsmeni, String rok, String datum, String poeniNaPrakticnom, String poeniNaUsmenom,
			String profesor) {
		 
		boolean flag = false;
		boolean daLiJeBrojPoeniSaPrakticnog = validacija.daLiJeBroj(poeniNaPrakticnom);
		boolean daLiJeBrojPoeniSaUsmenog = validacija.daLiJeBroj(poeniNaUsmenom);
        
		if(checkIzasao != null) {
			ispit.setDaLiJeStudentIzasaoNaIspit(Boolean.parseBoolean(checkIzasao));
			flag = true;
		}
		if(checkPolozioPrakticni != null) {
			ispit.setDaLiJeStudentPolozioPrakticniIspit(Boolean.parseBoolean(checkPolozioPrakticni));
			flag = true;
		}
		if(checkPolozioUsmeni != null) {
			ispit.setDaLiJeStudentPolozioUsmeniIspit(Boolean.parseBoolean(checkPolozioUsmeni));
			flag = true;
		}
		if(!rok.isEmpty()) {
			ispit.setIspitniRok(rok);
			flag = true;
		}
		if(!datum.isEmpty()) {
			ispit.setDatumOdrzavanjaIspita(datum);
			flag = true;
		}
		if(!poeniNaPrakticnom.isEmpty() && daLiJeBrojPoeniSaPrakticnog) {
			ispit.setOsvojeniPoeniNaPrakticnom(Double.parseDouble(poeniNaPrakticnom));
			flag = true;
		}
		if(!poeniNaUsmenom.isEmpty() && daLiJeBrojPoeniSaUsmenog) {
			ispit.setOsvojeniPoeniNaUsmenom(Double.parseDouble(poeniNaUsmenom));
			flag = true;
		}
		if(!profesor.isEmpty()) {
			ispit.setDodeljenProfesor(profesor);
			flag = true;
		}
        return flag;
	}

	public boolean promeniPodatkeOStudentu(Student student, String ime, String prezime, String brojIndeksa,
			String grupa, String pol, String zabeleske, String ocena) {
		boolean flag = false;
		boolean daLiJeBroj = validacija.daLiJeBroj(grupa);
		
		if(!ime.isEmpty()) {
			student.setIme(ime);
			flag = true;
		}
		if(!prezime.isEmpty()) {
			student.setPrezime(prezime);
			flag = true;
		}
		if(!brojIndeksa.isEmpty()) {
			student.setBrojIndeksa(brojIndeksa);
			flag = true;
		}
		if(!grupa.isEmpty()) {
			student.setGrupa(Integer.parseInt(grupa));
			flag = true;
		}
		if(pol != null) {
			student.setPol(pol);
			flag = true;
		}
		if(!zabeleske.isEmpty()) {
			student.setZabeleske(zabeleske);
			flag = true;
		}
		if(!ocena.isEmpty()) {
			student.setOcena(Integer.parseInt(ocena));
			flag = true;
		}
		
		return flag;
	}

	
	

	

	

}
