package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profesori {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idProfesora;
	private String imeProfesora;
	private String prezimeProfesora;
	private String usernameProfesora;
	private String passwordProfesora;
	
	
	public int getIdProfesora() {
		return idProfesora;
	}
	public void setIdProfesora(int idProfesora) {
		this.idProfesora = idProfesora;
	}
	public String getImeProfesora() {
		return imeProfesora;
	}
	public void setImeProfesora(String imeProfesora) {
		this.imeProfesora = imeProfesora;
	}
	public String getPrezimeProfesora() {
		return prezimeProfesora;
	}
	public void setPrezimeProfesora(String prezimeProfesora) {
		this.prezimeProfesora = prezimeProfesora;
	}
	public String getUsernameProfesora() {
		return usernameProfesora;
	}
	public void setUsernameProfesora(String usernameProfesora) {
		this.usernameProfesora = usernameProfesora;
	}
	public String getPasswordProfesora() {
		return passwordProfesora;
	}
	public void setPasswordProfesora(String passwordProfesora) {
		this.passwordProfesora = passwordProfesora;
	}
	
	
}
