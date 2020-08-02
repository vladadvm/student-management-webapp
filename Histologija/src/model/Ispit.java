package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ispit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspit;
	private String ispitniRok;
	private String datumOdrzavanjaIspita;
	private double osvojeniPoeniNaPrakticnom;
	private double osvojeniPoeniNaUsmenom;
	private boolean daLiJeStudentPolozioPrakticniIspit;
	private boolean daLiJeStudentPolozioUsmeniIspit;
	private boolean daLiJeStudentIzasaoNaIspit;
	private String dodeljenProfesor;
	
	
	public int getIdIspit() {
		return idIspit;
	}
	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}
	public String getIspitniRok() {
		return ispitniRok;
	}
	public void setIspitniRok(String ispitniRok) {
		this.ispitniRok = ispitniRok;
	}
	public String getDatumOdrzavanjaIspita() {
		return datumOdrzavanjaIspita;
	}
	public void setDatumOdrzavanjaIspita(String datumOdrzavanjaIspita) {
		this.datumOdrzavanjaIspita = datumOdrzavanjaIspita;
	}
	public double getOsvojeniPoeniNaPrakticnom() {
		return osvojeniPoeniNaPrakticnom;
	}
	public void setOsvojeniPoeniNaPrakticnom(double osvojeniPoeniNaPrakticnom) {
		this.osvojeniPoeniNaPrakticnom = osvojeniPoeniNaPrakticnom;
	}
	public double getOsvojeniPoeniNaUsmenom() {
		return osvojeniPoeniNaUsmenom;
	}
	public void setOsvojeniPoeniNaUsmenom(double osvojeniPoeniNaUsmenom) {
		this.osvojeniPoeniNaUsmenom = osvojeniPoeniNaUsmenom;
	}
	public boolean isDaLiJeStudentPolozioPrakticniIspit() {
		return daLiJeStudentPolozioPrakticniIspit;
	}
	public void setDaLiJeStudentPolozioPrakticniIspit(boolean daLiJeStudentPolozioPrakticniIspit) {
		this.daLiJeStudentPolozioPrakticniIspit = daLiJeStudentPolozioPrakticniIspit;
	}
	public boolean isDaLiJeStudentPolozioUsmeniIspit() {
		return daLiJeStudentPolozioUsmeniIspit;
	}
	public void setDaLiJeStudentPolozioUsmeniIspit(boolean daLiJeStudentPolozioUsmeniIspit) {
		this.daLiJeStudentPolozioUsmeniIspit = daLiJeStudentPolozioUsmeniIspit;
	}
	public boolean isDaLiJeStudentIzasaoNaIspit() {
		return daLiJeStudentIzasaoNaIspit;
	}
	public void setDaLiJeStudentIzasaoNaIspit(boolean daLiJeStudentIzasaoNaIspit) {
		this.daLiJeStudentIzasaoNaIspit = daLiJeStudentIzasaoNaIspit;
	}
	public String getDodeljenProfesor() {
		return dodeljenProfesor;
	}
	public void setDodeljenProfesor(String dodeljenProfesor) {
		this.dodeljenProfesor = dodeljenProfesor;
	}
	
	
	

}
