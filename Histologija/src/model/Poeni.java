package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "poeni")
public class Poeni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPoeni;
	private double poeniSaPrvogKolokvijuma;
	private double poeniSaDrugogKolokvijuma;
	private double poeniSaTrecegKolokvijuma;
	private double ukupniPoeniSaKolokvijuma;
	private double ukupanBrojPoenaSaVezbi;
	private int ukupniPoeniSaPredavanja;
	private double predispitniPoeni;
	private double ukupniPoeni;
	
	
	
	public int getIdPoeni() {
		return idPoeni;
	}
	public void setIdPoeni(int idPoeni) {
		this.idPoeni = idPoeni;
	}
	public double getPoeniSaPrvogKolokvijuma() {
		return poeniSaPrvogKolokvijuma;
	}
	public void setPoeniSaPrvogKolokvijuma(double poeniSaPrvogKolokvijuma) {
		this.poeniSaPrvogKolokvijuma = poeniSaPrvogKolokvijuma;
	}
	public double getPoeniSaDrugogKolokvijuma() {
		return poeniSaDrugogKolokvijuma;
	}
	public void setPoeniSaDrugogKolokvijuma(double poeniSaDrugogKolokvijuma) {
		this.poeniSaDrugogKolokvijuma = poeniSaDrugogKolokvijuma;
	}
	public double getPoeniSaTrecegKolokvijuma() {
		return poeniSaTrecegKolokvijuma;
	}
	public void setPoeniSaTrecegKolokvijuma(double poeniSaTrecegKolokvijuma) {
		this.poeniSaTrecegKolokvijuma = poeniSaTrecegKolokvijuma;
	}
	public double getUkupanBrojPoenaSaVezbi() {
		return ukupanBrojPoenaSaVezbi;
	}
	public void setUkupanBrojPoenaSaVezbi(double ukupanBrojPoenaSaVezbi) {
		this.ukupanBrojPoenaSaVezbi = ukupanBrojPoenaSaVezbi;
	}
	public double getUkupniPoeniSaKolokvijuma() {
		return ukupniPoeniSaKolokvijuma;
	}
	public void setUkupniPoeniSaKolokvijuma(double ukupniPoeniSaKolokvijuma) {
		this.ukupniPoeniSaKolokvijuma = ukupniPoeniSaKolokvijuma;
	}
	public int getUkupniPoeniSaPredavanja() {
		return ukupniPoeniSaPredavanja;
	}
	public void setUkupniPoeniSaPredavanja(int ukupniPoeniSaPredavanja) {
		this.ukupniPoeniSaPredavanja = ukupniPoeniSaPredavanja;
	}
	public double getPredispitniPoeni() {
		return predispitniPoeni;
	}
	public void setPredispitniPoeni(double predispitniPoeni) {
		this.predispitniPoeni = predispitniPoeni;
	}
	public double getUkupniPoeni() {
		return ukupniPoeni;
	}
	public void setUkupniPoeni(double ukupniPoeni) {
		this.ukupniPoeni = ukupniPoeni;
	}
	
	
	
	
	
	
	
}
