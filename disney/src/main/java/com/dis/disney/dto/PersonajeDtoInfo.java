package com.dis.disney.dto;


import java.util.HashSet;
import java.util.Set;

import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.model.Personaje;

public class PersonajeDtoInfo {

	private Long id;
	private String nombre;
	private String imagen;
	private String historia;
	private Integer edad;
	private Long peso;
	private Set<PeliculaSerieDtoInfo> peliculas = new HashSet<>();
	
	
	public PersonajeDtoInfo(Personaje p) {
		super();
		this.id=p.getId();
		this.nombre=p.getNombre();
		this.imagen=p.getImagen();
		this.historia=p.getHistoria();
		this.edad=p.getEdad();
		this.peso=p.getPeso();
		
		for(PeliculaSerie pelicula:p.getPeliculasSeries()) {
			PeliculaSerieDtoInfo peli=new PeliculaSerieDtoInfo();
			peli.setId(pelicula.getId());
			peli.setCalificacion(pelicula.getCalificacion());
			peli.setFechaCreacion(pelicula.getFechaCreacion());
			peli.setImagen(pelicula.getImagen());
			peli.setTitulo(pelicula.getTitulo());
			
			peliculas.add(peli);
			
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public void setPeliculas(Set<PeliculaSerieDtoInfo> peliculas) {
		this.peliculas = peliculas;
	}

	public PersonajeDtoInfo() {}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public String getHistoria() {
		return historia;
	}

	public Integer getEdad() {
		return edad;
	}

	public Long getPeso() {
		return peso;
	}

	public Set<PeliculaSerieDtoInfo> getPeliculas() {
		return peliculas;
	}
	
	public PersonajeDtoInfo get() {
		return this;
	}
	
	
}
