package com.dis.disney.dto;


public class PersonajeDto {
	
	private String nombre;
	private String imagen;
	private String historia;
	private Long edad;
	private Long peso;
	private Integer idPeliculaSerie;

	public Long getEdad() {
		return edad;
	}

	public Long getPeso() {
		return peso;
	}


	public Integer getIdPeliculaSerie() {
		return idPeliculaSerie;
	}


	public PersonajeDto() {};
	
	public String getNombre() {

		return nombre;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	
	public String getHistoria() {
		return historia;
	}
	
	
}
