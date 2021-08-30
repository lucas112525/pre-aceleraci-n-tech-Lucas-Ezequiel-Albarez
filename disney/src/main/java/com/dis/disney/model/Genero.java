package com.dis.disney.model;

import javax.persistence.*;

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
	@Column(name = "id_pelicula_serie")
	private Long idPeliculaSerie;
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Genero() {}
	
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public Long getIdPeliculaSerie() {
		return idPeliculaSerie;
	}
	
	public void setIdPeliculaSerie(Long idPeliculaSerie) {
		this.idPeliculaSerie=idPeliculaSerie;
	}
	
	

}
