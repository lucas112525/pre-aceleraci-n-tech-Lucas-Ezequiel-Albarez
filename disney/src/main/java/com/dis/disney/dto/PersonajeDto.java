package com.dis.disney.dto;





public class PersonajeDto {
	private Long id;
	private String nombre;
	private String imagen;
	private String historia;
	private int edad;
	private Long peso;
	private Integer idPeliculaSerie;


		
	
	public PersonajeDto get() {
		return this;
	}
	public int getEdad() {
		return edad;
	}

	public Long getPeso() {
		return peso;
	}


	public Integer getIdPeliculaSerie() {
		return idPeliculaSerie;
	}
	
	public PersonajeDto() {
		
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
	public void setIdPeliculaSerie(Integer idPeliculaSerie) {
		this.idPeliculaSerie = idPeliculaSerie;
	}

	
	public Long getId() {
		return this.id;
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

	
	
}
