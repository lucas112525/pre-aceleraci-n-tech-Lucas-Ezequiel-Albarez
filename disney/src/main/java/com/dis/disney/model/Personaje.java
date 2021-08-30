package com.dis.disney.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "personaje")

public class Personaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column()
	private String imagen;
	@Column()
	private String nombre;
	@Column()
	private int edad;
	@Column()
	private int peso;
	@Column()
	private String historia;
	
	@ManyToMany
	@JoinTable(
			name="pelicula_serie_personaje",
			joinColumns = @JoinColumn(name = "id_personaje"),
			inverseJoinColumns = @JoinColumn(name = "id_pelicula_serie")
			)
	Set<PeliculaSerie> peliculas;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personaje() {}
	
	public Long getId() {
		return id;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen=imagen;
	}
    
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso=peso;
	}
	
	public String getHistoria() {
		return historia;
	}
	
	public void setHistoria(String historia) {
		this.historia=historia;
		
	}
	
	
}
