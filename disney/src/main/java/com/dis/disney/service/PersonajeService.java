package com.dis.disney.service;

import java.util.List;


import com.dis.disney.dto.PersonajeDto;
import com.dis.disney.dto.PersonajeDtoInfo;
import com.dis.disney.dto.PersonajeDtoInfoBasic;




public interface PersonajeService {
	
	public List<PersonajeDtoInfo> get();
	
	public PersonajeDtoInfo savePersonaje(PersonajeDto p);
	
	public void deletPersonae(int id);
	
	public PersonajeDtoInfo updatePersonaje(int id,PersonajeDto p);
	
	public List<PersonajeDtoInfoBasic> getBasic();
	
	public List<PersonajeDtoInfo> findByName(String name);
	
	public List<PersonajeDtoInfo> findByAge(int edad);
	
	public List<PersonajeDtoInfo> findByPelicula(int idPelicula);
	
}
