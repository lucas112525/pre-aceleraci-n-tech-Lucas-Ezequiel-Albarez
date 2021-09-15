package com.dis.disney.dto;

import java.util.Date;

import com.dis.disney.model.PeliculaSerie;

public class PeliculaSerieDtoInfoBasic {

	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	
	public PeliculaSerieDtoInfoBasic(PeliculaSerie p) {
		this.imagen=p.getImagen();
		this.titulo=p.getTitulo();
		this.fechaCreacion=p.getFechaCreacion();
		
	}
	
	public PeliculaSerieDtoInfoBasic() {
		// TODO Auto-generated constructor stub
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



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
