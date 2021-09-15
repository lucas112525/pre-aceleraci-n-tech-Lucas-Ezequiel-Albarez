package com.dis.disney.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;









@Entity
@Table(name = "pelicula_serie")
public class PeliculaSerie {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String imagen;
	
	@Column()
	private String titulo;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column()
	private Long calificacion;
	

	@ManyToMany(mappedBy = "peliculasSeries")
	private Set<Personaje> personajes = new HashSet<>();
	
	@ManyToMany
	@JoinTable(
	  name = "pelicula_serie_genero", 
	  joinColumns = @JoinColumn(name = "id_pelicula_serie"), 
	  inverseJoinColumns = @JoinColumn(name = "id_genero"))
	private Set<Genero> generos = new HashSet<>();
	
	
	public PeliculaSerie get() {
		return this;
	}
	
	
	public Set<Personaje> getPersonajes() {
		return personajes;
	}
	
	public void addPersonaje(Personaje person) {
		this.personajes.add(person);
		
	}
	
	public void deletPersonaje(Personaje person) {
		this.personajes.remove(person);
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}


	public Set<Genero> getGeneros() {
		return generos;
	}

	public void addGenero(Genero gen){
		this.generos.add(gen);
	}
	
	public void deletGenero(Genero gen) {
		this.generos.remove(gen);
		
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}


	public PeliculaSerie() {}
	

	public PeliculaSerie(Long id,String imagen, String titulo, Date fechaCreacion, Long calificacion) {
		this.id=id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date date) {
		this.fechaCreacion = date;
	}

	public Long getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Long calificacion) {
		this.calificacion = calificacion;
	}

	
	
}
