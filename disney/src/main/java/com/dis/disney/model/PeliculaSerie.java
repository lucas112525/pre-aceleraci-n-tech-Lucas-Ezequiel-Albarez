package com.dis.disney.model;

import javax.persistence.*;



import java.util.Date;
import java.util.Set;

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
	private  Date fechaCreacion;
	@Column()
	private int calificacion;
	
	@ManyToMany(mappedBy = "peliculas")
	Set<Personaje> personajes;
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PeliculaSerie() {}
	
	public Long getId() {
		return id;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen=imagen;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion=fechaCreacion;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(int calificacion) {
		this.calificacion=calificacion;
	}

}
