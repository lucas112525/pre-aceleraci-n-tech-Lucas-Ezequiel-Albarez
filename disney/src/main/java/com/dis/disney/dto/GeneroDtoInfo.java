package com.dis.disney.dto;

import java.util.HashSet;
import java.util.Set;

import com.dis.disney.model.Genero;
import com.dis.disney.model.PeliculaSerie;

public class GeneroDtoInfo {
	private Long id;
	private String nombre;
	private String imagen;
	private Set<PeliculaSerieDtoInfo> peliculas=new HashSet<>();
	
	
	public GeneroDtoInfo(Genero g) {
		super();
		this.id=g.getId();
		this.nombre=g.getNombre();
		this.imagen=g.getImagen();
		
		for(PeliculaSerie pelicula:g.getPeliculasSeries()) {
			PeliculaSerieDtoInfo peli=new PeliculaSerieDtoInfo();
			peli.setId(pelicula.getId());
			peli.setCalificacion(pelicula.getCalificacion());
			peli.setFechaCreacion(pelicula.getFechaCreacion());
			peli.setImagen(pelicula.getImagen());
			peli.setTitulo(pelicula.getTitulo());
			
			peliculas.add(peli);
			
		}
	}
	
	public GeneroDtoInfo get() {
		return this;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<PeliculaSerieDtoInfo> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<PeliculaSerieDtoInfo> peliculas) {
		this.peliculas = peliculas;
	}

	public GeneroDtoInfo() {
		// TODO Auto-generated constructor stub
	}

}
