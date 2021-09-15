package com.dis.disney.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dis.disney.dto.PeliculaSerieDto;
import com.dis.disney.model.Genero;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.repository.GeneroRepository;
import com.dis.disney.repository.PeliculaSerieRepository;
import com.dis.disney.repository.PersonajeRepository;
import com.dis.disney.service.PeliculaSerieService;

import com.dis.disney.dto.PeliculaSerieDtoInfo;
import com.dis.disney.dto.PeliculaSerieDtoInfoBasic;
@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService{
	
	@Autowired
	private PeliculaSerieRepository peliculaSerieRepository;
	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private PersonajeRepository personajeRepository;

	@Override
	public List<PeliculaSerieDtoInfo> get() {
	 return peliculaSerieRepository.findAll().stream().map(peliculaSerie -> new PeliculaSerieDtoInfo(peliculaSerie)).collect(Collectors.toList());
	 
	}

	@Override
	public List<PeliculaSerieDtoInfo> findByName(String name) {
		
		return peliculaSerieRepository.findByTitulo(name).stream().map(peliculaSerie -> new PeliculaSerieDtoInfo(peliculaSerie)).collect(Collectors.toList());
	}

	@Override
	public List<PeliculaSerieDtoInfoBasic> getInfoBasic() {
		return peliculaSerieRepository.findAll().stream().map(peliculaSerie -> new PeliculaSerieDtoInfoBasic(peliculaSerie)).collect(Collectors.toList());
	}

	@Override
	public PeliculaSerieDtoInfo savePeliculaSerie(PeliculaSerieDto p) {
		PeliculaSerie nuevaPeliculaSerie= new PeliculaSerie();
		nuevaPeliculaSerie.setCalificacion(p.getCalificacion());
		
		Date fecha=null;
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(p.getFechaCreacion());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nuevaPeliculaSerie.setFechaCreacion(fecha);
		if(p.getGeneros() != 0)
		nuevaPeliculaSerie.addGenero(generoRepository.getById((long)p.getGeneros()).get());
		nuevaPeliculaSerie.setTitulo(p.getTitulo());
		if(p.getPersonajes() !=0)
		nuevaPeliculaSerie.addPersonaje(personajeRepository.getById((long)p.getPersonajes()).get());
		nuevaPeliculaSerie.setImagen(p.getImagen());
		peliculaSerieRepository.save(nuevaPeliculaSerie);
		return new PeliculaSerieDtoInfo(nuevaPeliculaSerie);
	}

	@Override
	public void deletPeliculaSerie(int id) {
		peliculaSerieRepository.deleteById((long)id);
		
	}

	@Override
	public PeliculaSerieDtoInfo updatePeliculaSerie(int id, PeliculaSerieDto p) {
		PeliculaSerie peliculaSerieUpdate = peliculaSerieRepository.getById((long)id);
		if(p.getCalificacion() != null)
			peliculaSerieUpdate.setCalificacion(p.getCalificacion());
		if(p.getFechaCreacion() != null) {
			Date fecha=null;
			try {
				fecha = new SimpleDateFormat("dd/MM/yyyy").parse(p.getFechaCreacion());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			peliculaSerieUpdate.setFechaCreacion(fecha);
		}
		if(p.getGeneros() != 0)
			peliculaSerieUpdate.addGenero(generoRepository.getById((long)p.getGeneros()).get());
		if(p.getImagen() != null)
			peliculaSerieUpdate.setImagen(p.getImagen());
		if(p.getPersonajes() != 0)
			peliculaSerieUpdate.addPersonaje(personajeRepository.getById((long)p.getPersonajes()).get());
		if(p.getTitulo() != null)
			peliculaSerieUpdate.setTitulo(p.getTitulo());
		peliculaSerieRepository.save(peliculaSerieUpdate);
		return new PeliculaSerieDtoInfo(peliculaSerieUpdate);
		
		
	}

	
	
	@Override
	public List<PeliculaSerieDtoInfo> findByGenero(int idPelicula) {
		List<PeliculaSerie> peliculaSerie= peliculaSerieRepository.findAll();
		List<PeliculaSerieDtoInfo> peliculasDtoInfo=new ArrayList<>();
		
		for(int i=0; i<peliculaSerie.size();i++) {
			
			for(Genero genero:peliculaSerie.get(i).getGeneros()) {
				if(genero.getId() == (long) idPelicula)
					peliculasDtoInfo.add(new PeliculaSerieDtoInfo(peliculaSerie.get(i)));
			}
		}
		
		return peliculasDtoInfo;
	}

	@Override
	public List<PeliculaSerieDtoInfoBasic> ordenar(String orden) {
		List<PeliculaSerieDtoInfoBasic> peliculas= peliculaSerieRepository.findAll().stream().map(peliculaSerie -> new PeliculaSerieDtoInfoBasic(peliculaSerie)).collect(Collectors.toList());
		//Collections.sort(peliculas,new CompararPeliculas());
		
		if(orden.compareTo("DESC")==0) {
		Collections.sort(peliculas, new Comparator<PeliculaSerieDtoInfoBasic>() {

			@Override
			public int compare(PeliculaSerieDtoInfoBasic p1, PeliculaSerieDtoInfoBasic p2) {
			// TODO Auto-generated method stub
				return p1.getFechaCreacion().compareTo(p2.getFechaCreacion());
		}
		});
		}else if(orden.compareTo("ASC")==0) {
			Collections.sort(peliculas, new Comparator<PeliculaSerieDtoInfoBasic>() {

				@Override
				public int compare(PeliculaSerieDtoInfoBasic p1, PeliculaSerieDtoInfoBasic p2) {
				// TODO Auto-generated method stub
					return p2.getFechaCreacion().compareTo(p1.getFechaCreacion());
			}
			});
			
			
		}
		
		
		return peliculas;
	}




	
	
}
