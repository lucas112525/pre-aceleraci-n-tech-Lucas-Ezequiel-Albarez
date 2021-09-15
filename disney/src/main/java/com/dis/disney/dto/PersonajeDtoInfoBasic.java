package com.dis.disney.dto;

import com.dis.disney.model.Personaje;

public class PersonajeDtoInfoBasic {

	private String nombre;
	private String imagen;
	
	
	public PersonajeDtoInfoBasic(Personaje p) {
		this.nombre=p.getNombre();
		this.setImagen(p.getImagen());
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public PersonajeDtoInfoBasic() {
		// TODO Auto-generated constructor stub
	}



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
