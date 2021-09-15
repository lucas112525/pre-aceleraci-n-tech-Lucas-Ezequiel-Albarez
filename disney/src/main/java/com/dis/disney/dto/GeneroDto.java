package com.dis.disney.dto;





public class GeneroDto {
	private Long id;
	private String nombre;
	private String imagen;
	private Integer idPeliculaSerie;
	
	
	public Integer getPeliculasSeries() {
		return idPeliculaSerie;
	}


	public Integer getIdPeliculaSerie() {
		return idPeliculaSerie;
	}


	public void setIdPeliculaSerie(Integer idPeliculaSerie) {
		this.idPeliculaSerie = idPeliculaSerie;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GeneroDto() {};
	
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
