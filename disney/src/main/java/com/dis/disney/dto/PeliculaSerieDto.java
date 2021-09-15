package com.dis.disney.dto;




public class PeliculaSerieDto {
	
	private String imagen;
	private String titulo;
	private Long calificacion;
	private int idPersonaje;
	private String fechaCreacion;
	private int idGeneros;
	
	
	
	
	public int getIdPersonaje() {
		return idPersonaje;
	}


	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}


	public int getIdGeneros() {
		return idGeneros;
	}


	public void setIdGeneros(int idGeneros) {
		this.idGeneros = idGeneros;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setCalificacion(Long calificacion) {
		this.calificacion = calificacion;
	}


	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public int getGeneros() {
		return idGeneros;
	}


	public Long getCalificacion() {
		return calificacion;
	}



	public int getPersonajes() {
		return idPersonaje;
	}


	public String getFechaCreacion() {
		return fechaCreacion;
	}



	public PeliculaSerieDto() {}

	public String getImagen() {
		return imagen;
	}



	public String getTitulo() {
		return titulo;
	}

	

	
}
