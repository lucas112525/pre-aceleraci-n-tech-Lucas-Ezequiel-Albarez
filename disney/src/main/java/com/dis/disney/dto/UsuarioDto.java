package com.dis.disney.dto;

public class UsuarioDto {

	private String mail;
	private String contraseña;
	
	public String getMail() {
		return mail;
	}
	public void setUsuario(String usuario) {
		this.mail = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public UsuarioDto(String usuario, String contraseña) {
		super();
		this.mail = usuario;
		this.contraseña = contraseña;
	}
	
	public UsuarioDto() {}
}
