package com.dis.disney.model;

public class AutenticacionResq {
	private String mail;
	private String contraseña;
	
	public AutenticacionResq(String mail, String contraseña) {
		this.mail = mail;
		this.contraseña = contraseña;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
