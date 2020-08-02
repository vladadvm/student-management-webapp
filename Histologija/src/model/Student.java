package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "studenti")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudenta;
	private String ime;
	private String prezime;
	private String brojIndeksa;
	private int grupa;
	private String pol;
	private int ocena;
	private String zabeleske;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Poeni poeni;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Ispit> ispiti = new ArrayList<>();
	
	public int getIdStudenta() {
		return idStudenta;
	}
	public void setIdStudenta(int idStudenta) {
		this.idStudenta = idStudenta;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGrupa() {
		return grupa;
	}
	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public Poeni getPoeni() {
		return poeni;
	}
	public void setPoeni(Poeni poeni) {
		this.poeni = poeni;
	}
	public String getZabeleske() {
		return zabeleske;
	}
	public void setZabeleske(String zabeleske) {
		this.zabeleske = zabeleske;
	}
	public List<Ispit> getIspiti() {
		return ispiti;
	}
	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}
	
	
	

}
