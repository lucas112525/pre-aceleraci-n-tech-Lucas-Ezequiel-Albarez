package com.dis.disney.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.dto.GeneroDto;
import com.dis.disney.dto.GeneroDtoInfo;

import com.dis.disney.model.Genero;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.repository.GeneroRepository;
import com.dis.disney.repository.PeliculaSerieRepository;
import com.dis.disney.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private PeliculaSerieRepository peliculaRepository;
	
	
	@Override
	public List<GeneroDtoInfo> get() {
		return	generoRepository.findAll().stream().map(peliculaSerie -> new GeneroDtoInfo(peliculaSerie)).collect(Collectors.toList());
	
	}


	@Override
	public GeneroDtoInfo saveGenero(GeneroDto g) {
		Genero nuevoGenero= new Genero();
		nuevoGenero.setImagen(g.getImagen());
		nuevoGenero.setNombre(g.getNombre());
		if(g.getPeliculasSeries() != null)
		nuevoGenero.addPeliculaSerie(peliculaRepository.getById((long)g.getPeliculasSeries()));
		generoRepository.save(nuevoGenero);
		return new GeneroDtoInfo(nuevoGenero).get();
		
	}


	@Override
	public void deletGenero(int id) {
		
		for(PeliculaSerie p:generoRepository.getById((long)id).getPeliculasSeries()) {
			p.deletGenero(generoRepository.getById((long)id));
		}
		generoRepository.deleteById((long)id);
		
	}


	@Override
	public GeneroDtoInfo updateGenero(int id, GeneroDto g) {
		Genero updateGenero = generoRepository.getById((long)id).get();
		if(g.getImagen() != null)
			updateGenero.setImagen(g.getImagen());
		if(g.getNombre() != null)
			updateGenero.setNombre(g.getNombre());
		if(g.getPeliculasSeries() != null)
			updateGenero.addPeliculaSerie(peliculaRepository.getById((long)g.getPeliculasSeries()));
		generoRepository.save(updateGenero);
		return  new GeneroDtoInfo(updateGenero).get();
	}


	

}
