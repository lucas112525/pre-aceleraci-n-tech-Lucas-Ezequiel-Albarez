package com.dis.disney.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id //referencia a que es un id
	@GeneratedValue(strategy = GenerationType.IDENTITY )    //creacion y tipo de id
	private Long id;
	
	@Column()
	private String mail;
	
	@Column()
	private String contraseña;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getmail() {
		return mail;
	}


	public void setmail(String mail) {
		this.mail = mail;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public Usuario(String mail, String contraseña) {
		super();
		this.mail = mail;
		this.contraseña = contraseña;
	}

	
}
