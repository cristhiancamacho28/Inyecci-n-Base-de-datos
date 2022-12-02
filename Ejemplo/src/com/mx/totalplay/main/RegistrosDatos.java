package com.mx.totalplay.main;

public class RegistrosDatos {
	
	private String Firstname;
	private String Lastname;
	private String Phonenumber1;
	private String Phonenumber2;
	private String Email;
	private Estatus Estatus;
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getPhonenumber1() {
		return Phonenumber1;
	}
	public void setPhonenumber1(String phonenumber1) {
		Phonenumber1 = phonenumber1;
	}
	public String getPhonenumber2() {
		return Phonenumber2;
	}
	public void setPhonenumber2(String phonenumber2) {
		Phonenumber2 = phonenumber2;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Estatus getEstatus() {
		return Estatus;
	}
	public void setEstatus(Estatus estatus) {
		Estatus = estatus;
	}
}
