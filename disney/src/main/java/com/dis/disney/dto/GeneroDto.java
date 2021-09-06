package com.dis.disney.dto;

import java.util.Set;

import com.dis.disney.model.PeliculaSerie;

public class GeneroDto {
	
	private String nombre;
	private String imagen;
	private Set<PeliculaSerie> peliculasSeries;
	
	
	public Set<PeliculaSerie> getPeliculasSeries() {
		return peliculasSeries;
	}



	public void setPeliculasSeries(Set<PeliculaSerie> peliculasSeries) {
		this.peliculasSeries = peliculasSeries;
	}



	public GeneroDto() {};
	
	
	
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
	
	
	
	
	
}
