package com.dis.disney.dto;

import java.util.Set;


import com.dis.disney.model.PeliculaSerie;

public class PersonajeDto {
	
	private String nombre;
	private String imagen;
	private String historia;
	private Long edad;
	private Long peso;
	private Set<PeliculaSerie> peliculaSeries;

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public Long getPeso() {
		return peso;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public Set<PeliculaSerie> getPeliculaSeries() {
		return peliculaSeries;
	}

	public void setPeliculaSeries(Set<PeliculaSerie> peliculaSeries) {
		this.peliculaSeries = peliculaSeries;
	}

	public PersonajeDto() {};
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	
}
