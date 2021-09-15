package com.dis.disney.dto;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.dis.disney.model.Genero;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.model.Personaje;

public class PeliculaSerieDtoInfo {

	private Long id;
	private String imagen;
	private String titulo;
	private Long calificacion;
	private Date fechaCreacion;
	private Set<PersonajeDtoInfo> personajes=new HashSet<>();
	private Set<GeneroDtoInfo> generos=new HashSet<>();


	public PeliculaSerieDtoInfo(PeliculaSerie p) {
		super();
		this.imagen=p.getImagen();
		this.id=p.getId();
		this.titulo=p.getTitulo();
		this.calificacion=p.getCalificacion();
		this.fechaCreacion=p.getFechaCreacion();
		
		for(Personaje personaje: p.getPersonajes()) {
			PersonajeDtoInfo personajeInfo = new PersonajeDtoInfo();
			personajeInfo.setId(personaje.getId());
			personajeInfo.setEdad(personaje.getEdad());
			personajeInfo.setHistoria(personaje.getHistoria());
			personajeInfo.setNombre(personaje.getNombre());
			personajeInfo.setPeso(personaje.getPeso());
			personajeInfo.setImagen(personaje.getImagen());
			
			personajes.add(personajeInfo);
			
		}
		for(Genero genero: p.getGeneros()) {
			GeneroDtoInfo generoInfo = new GeneroDtoInfo();
			generoInfo.setId(genero.getId());
			generoInfo.setImagen(genero.getImagen());
			generoInfo.setNombre(genero.getNombre());
			
			generos.add(generoInfo);
			
		}
		
		
	}
	
	
	
	
	
	public Set<PersonajeDtoInfo> getPersonajes() {
		
		return personajes;
		
	}
	

	public void setPersonajes(Set<PersonajeDtoInfo> personajes) {
		this.personajes = personajes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCalificacion(Long calificacion) {
		this.calificacion = calificacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public PeliculaSerieDtoInfo() {}

	public Long getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getCalificacion() {
		return calificacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public Set<GeneroDtoInfo> getGeneros() {
		return generos;
	}


	public void setGeneros(Set<GeneroDtoInfo> generos) {
		this.generos = generos;
	}

}
