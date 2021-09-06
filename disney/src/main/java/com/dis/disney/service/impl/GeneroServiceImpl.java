package com.dis.disney.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.dto.GeneroDto;
import com.dis.disney.model.Genero;
import com.dis.disney.repository.GeneroRepository;
import com.dis.disney.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	
	@Override
	public List<Genero> get() {
		return	generoRepository.findAll();
	
	}


	@Override
	public Genero saveGenero(GeneroDto g) {
		Genero nuevoGenero= new Genero();
		nuevoGenero.setImagen(g.getImagen());
		nuevoGenero.setNombre(g.getNombre());
		nuevoGenero.setPeliculasSeries(g.getPeliculasSeries());
		
		return generoRepository.saveAndFlush(nuevoGenero);
		
	}


	@Override
	public void deletGenero(Long id) {
		generoRepository.deleteById(id);
		
	}


	@Override
	public Genero updateGenero(Long id, GeneroDto g) {
		Genero updateGenero = generoRepository.getById(id);
		if(g.getImagen() != null)
			updateGenero.setImagen(g.getImagen());
		if(g.getNombre() != null)
			updateGenero.setNombre(g.getNombre());
		if(g.getPeliculasSeries() != null)
			updateGenero.setPeliculasSeries(g.getPeliculasSeries());
		
		return  generoRepository.saveAndFlush(updateGenero);
	}


	

}
