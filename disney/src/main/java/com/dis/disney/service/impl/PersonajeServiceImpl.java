package com.dis.disney.service.impl;

import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dis.disney.dto.PersonajeDto;
import com.dis.disney.dto.PersonajeDtoInfo;
import com.dis.disney.dto.PersonajeDtoInfoBasic;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.model.Personaje;
import com.dis.disney.repository.PeliculaSerieRepository;
import com.dis.disney.repository.PersonajeRepository;
import com.dis.disney.service.PersonajeService;


@Service
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Autowired
	private PeliculaSerieRepository peliculaRepository;
	
	
	@Override
	public List<PersonajeDtoInfo> get() {
		return personajeRepository.findAll().stream().map(personaje -> new PersonajeDtoInfo(personaje)).collect(Collectors.toList());
			
	}
	@Override
	public List<PersonajeDtoInfoBasic> getBasic() {
		return personajeRepository.findAll().stream().map(personaje -> new PersonajeDtoInfoBasic(personaje)).collect(Collectors.toList());
	}

	@Override
	public List<PersonajeDtoInfo> findByName(String name) {
		
	 return personajeRepository.findByNombre(name).stream().map(personaje -> new PersonajeDtoInfo(personaje)).collect(Collectors.toList());
	}


	@Override
	public List<PersonajeDtoInfo> findByAge(int edad) {

		List<Personaje> personajes=	personajeRepository.findByEdad(edad);
		List<PersonajeDtoInfo> personajeInfo= new ArrayList<>();
		for (int i=0; i<personajes.size();i++) {
			
			personajeInfo.add(new PersonajeDtoInfo(personajes.get(i)));
			
		}
		if (personajeInfo.size()>0)
		return personajeInfo;
		else
			return null;
	}
	
	@Override
	public List<PersonajeDtoInfo> findByPelicula(int idPelicula) {
		List<Personaje> personajes= personajeRepository.findAll();
		List <PersonajeDtoInfo> personajeInfo= new ArrayList<>();

		for(int i=0;i<personajes.size();i++) {
			
			for(PeliculaSerie pelicula:personajes.get(i).getPeliculasSeries()) {
				if(pelicula.getId() == (long) idPelicula)
					personajeInfo.add(new PersonajeDtoInfo(personajes.get(i)));
			}
			
		}
		
		return personajeInfo;
	}
	
	
	
	@Override
	public PersonajeDtoInfo savePersonaje(PersonajeDto p) {
		Personaje nuevoPersonaje = new Personaje();
		nuevoPersonaje.setNombre(p.getNombre());
		nuevoPersonaje.setHistoria(p.getHistoria());
		nuevoPersonaje.setImagen(p.getImagen());
		if(p.getIdPeliculaSerie() != null)
		nuevoPersonaje.addPeliculaSerie(peliculaRepository.getById((long)p.getIdPeliculaSerie()).get());
		nuevoPersonaje.setPeso(p.getPeso());
		nuevoPersonaje.setEdad(p.getEdad());
		personajeRepository.save(nuevoPersonaje);
		
		return new PersonajeDtoInfo(nuevoPersonaje).get();
	} 


	@Override
	public void deletPersonae(int id) {
		
		for(PeliculaSerie p:personajeRepository.getById((long)id).getPeliculasSeries()) {
			p.deletPersonaje(personajeRepository.getById((long)id));
		}
		
		
		personajeRepository.deleteById((long)id);
		
	}


	@Override
	public PersonajeDtoInfo updatePersonaje(int id,PersonajeDto p) {
		Personaje personajeUpdate = personajeRepository.getById((long)id).get();
		
		if (p.getEdad() != 0 )
		  personajeUpdate.setEdad(p.getEdad());
		if (p.getHistoria() != null)
		  personajeUpdate.setHistoria(p.getHistoria());
		if(p.getImagen() != null)
		  personajeUpdate.setImagen(p.getImagen());
		if(p.getNombre() != null)
		  personajeUpdate.setNombre(p.getNombre());
		if(p.getPeso() != null)
		  personajeUpdate.setPeso(p.getPeso());
		if(p.getIdPeliculaSerie() != null) 
			personajeUpdate.addPeliculaSerie(peliculaRepository.getById((long)p.getIdPeliculaSerie()).get());
		
		personajeRepository.save(personajeUpdate);
		
		return new PersonajeDtoInfo(personajeUpdate).get();
	}
	



	

}
