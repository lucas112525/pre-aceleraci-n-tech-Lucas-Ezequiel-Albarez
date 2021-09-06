package com.dis.disney.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.dto.PeliculaSerieDto;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.repository.PeliculaSerieRepository;
import com.dis.disney.service.PeliculaSerieService;

@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService{
	
	@Autowired
	private PeliculaSerieRepository peliculaSerieRepository;

	@Override
	public List<PeliculaSerie> get() {
		return peliculaSerieRepository.findAll();
	}

	

	@Override
	public PeliculaSerie savePeliculaSerie(PeliculaSerieDto p) {
		PeliculaSerie nuevaPeliculaSerie= new PeliculaSerie();
		nuevaPeliculaSerie.setCalificacion(p.getCalificacion());
		nuevaPeliculaSerie.setFechaCreacion(p.getFechaCreacion());
		nuevaPeliculaSerie.setGeneros(p.getGeneros());
		nuevaPeliculaSerie.setTitulo(p.getTitulo());
		nuevaPeliculaSerie.setPersonajes(p.getPersonajes());
		nuevaPeliculaSerie.setImagen(p.getImagen());
		
		return peliculaSerieRepository.saveAndFlush(nuevaPeliculaSerie);
	}



	@Override
	public void deletPeliculaSerie(Long id) {
		peliculaSerieRepository.deleteById(id);
		
	}



	@Override
	public PeliculaSerie updatePeliculaSerie(Long id, PeliculaSerieDto p) {
		PeliculaSerie peliculaSerieUpdate = peliculaSerieRepository.getById(id);
		if(p.getCalificacion() != null)
			peliculaSerieUpdate.setCalificacion(p.getCalificacion());
		if(p.getFechaCreacion() != null)
			peliculaSerieUpdate.setFechaCreacion(p.getFechaCreacion());
		if(p.getGeneros() != null)
			peliculaSerieUpdate.setGeneros(p.getGeneros());
		if(p.getImagen() != null)
			peliculaSerieUpdate.setImagen(p.getImagen());
		if(p.getPersonajes() != null)
			peliculaSerieUpdate.setPersonajes(p.getPersonajes());
		if(p.getTitulo() != null)
			peliculaSerieUpdate.setTitulo(p.getTitulo());
		
		return peliculaSerieRepository.saveAndFlush(peliculaSerieUpdate);
		
		
	}
	
	
	
}
