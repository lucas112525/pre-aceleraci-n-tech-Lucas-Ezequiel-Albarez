package com.dis.disney.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name = "genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String nombre;
	
	@Column()
	private String imagen;
	
	
	@ManyToMany(mappedBy = "generos")
	private Set<PeliculaSerie> peliculasSeries = new HashSet<>();
	
	
	public Genero() {}
	
	public Genero get() {
		return this;
	}
	

	public Set<PeliculaSerie> getPeliculasSeries() {
		return peliculasSeries;
	}

	public void addPeliculaSerie(PeliculaSerie pelicula) {
		this.peliculasSeries.add(pelicula);
	}
	public void deletPeliculaSerie(PeliculaSerie pelicula) {
		this.peliculasSeries.remove(pelicula);
	}
	
	public void setPeliculasSeries(Set<PeliculaSerie> peliculasSeries) {
		this.peliculasSeries = peliculasSeries;
	}



	public Genero(Long id,String nombre, String imagen) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.imagen = imagen;
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
	
	
}
