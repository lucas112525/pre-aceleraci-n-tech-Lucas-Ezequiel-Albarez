package com.dis.disney.service;


import java.util.List;


import com.dis.disney.dto.PeliculaSerieDto;
import com.dis.disney.model.PeliculaSerie;

public interface PeliculaSerieService {
	public List<PeliculaSerie> get();

	public PeliculaSerie savePeliculaSerie(PeliculaSerieDto p);
	
	public void deletPeliculaSerie(Integer id);
	
	public PeliculaSerie updatePeliculaSerie(Integer id,PeliculaSerieDto p);

}
