package com.dis.disney.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.dto.PersonajeDto;
import com.dis.disney.model.Personaje;
import com.dis.disney.repository.PersonajeRepository;
import com.dis.disney.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;
	
	
	@Override
	public List<Personaje> get() {
		return personajeRepository.findAll();
			
	}


	@Override
	public Personaje savePersonaje(PersonajeDto p) {
		Personaje nuevoPersonaje = new Personaje();
		nuevoPersonaje.setNombre(p.getNombre());
		nuevoPersonaje.setHistoria(p.getHistoria());
		nuevoPersonaje.setImagen(p.getImagen());
		nuevoPersonaje.setPeliculasSeries(p.getPeliculaSeries());
		nuevoPersonaje.setPeso(p.getPeso());
		nuevoPersonaje.setEdad(p.getEdad());
		
		return personajeRepository.saveAndFlush(nuevoPersonaje);
	}


	@Override
	public void deletPersonae(Long id) {
		personajeRepository.deleteById(id);
		
	}


	@Override
	public Personaje updatePersonaje(Long id,PersonajeDto p) {
		Personaje personajeUpdate = personajeRepository.getById(id);
		if (p.getEdad() != null )
		  personajeUpdate.setEdad(p.getEdad());
		if (p.getHistoria() != null)
		  personajeUpdate.setHistoria(p.getHistoria());
		if(p.getImagen() != null)
		  personajeUpdate.setImagen(p.getImagen());
		if(p.getNombre() != null)
		  personajeUpdate.setNombre(p.getNombre());
		if(p.getPeso() != null)
		  personajeUpdate.setPeso(p.getPeso());
		if(p.getPeliculaSeries() != null)
		  personajeUpdate.setPeliculasSeries(p.getPeliculaSeries());
	
		return personajeRepository.saveAndFlush(personajeUpdate);
	}


	

}
