package com.dis.disney.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name = "personaje") //nombre de la tabla
public class Personaje implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //referencia a que es un id
	@GeneratedValue(strategy = GenerationType.IDENTITY )    //creacion y tipo de id
	private Integer id;
	
	@Column()
	private String imagen;
	
	@Column()
	private String nombre;
	
	@Column()
	private Long edad;
	
	@Column()
	private Long peso;
	
	@Column()
	private String historia;
	
	
	@ManyToMany
	@JoinTable(
	  name = "pelicula_serie_personaje", 
	  joinColumns = @JoinColumn(name = "id_personaje"), 
	  inverseJoinColumns = @JoinColumn(name = "id_pelicula_serie"))
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	Set<PeliculaSerie> peliculasSeries = new HashSet<>();
	
	
	
	
	public Set<PeliculaSerie> getPeliculasSeries() {
		return peliculasSeries;
	}

	public void setPeliculasSeries(Set<PeliculaSerie> peliculasSeries) {
		this.peliculasSeries = peliculasSeries;
	}
	
	public void addPeliculaSerie(PeliculaSerie pelicula) {
		this.peliculasSeries.add(pelicula);
		pelicula.getPersonajes().add(this);
		}
	public Personaje() {}
	
	public Personaje(Integer id,String nombre, Long edad, Long peso, String historia, String imagen) {
		this.id=id;
		this.nombre=nombre;
		this.edad=edad;
		this.peso=peso;
		this.historia=historia;
		this.imagen=imagen;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	

}
