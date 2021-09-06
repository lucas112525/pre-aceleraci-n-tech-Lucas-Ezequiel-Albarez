package com.dis.disney.dto;

import java.sql.Date;
import java.util.Set;

import com.dis.disney.model.Genero;
import com.dis.disney.model.Personaje;

public class PeliculaSerieDto {
	
	private String imagen;
	private String titulo;
	private Long calificacion;
	private Set<Personaje> personajes;
	private Date fechaCreacion;
	private Set<Genero> generos;
	
	
	
	
	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

	public Long getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Long calificacion) {
		this.calificacion = calificacion;
	}

	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes.addAll(personajes);
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public PeliculaSerieDto() {}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	
}
