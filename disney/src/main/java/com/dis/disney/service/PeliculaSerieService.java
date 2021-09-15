package com.dis.disney.service;



import java.util.List;


import com.dis.disney.dto.PeliculaSerieDto;
import com.dis.disney.dto.PeliculaSerieDtoInfo;
import com.dis.disney.dto.PeliculaSerieDtoInfoBasic;

public interface PeliculaSerieService {
	public List<PeliculaSerieDtoInfo> get();

	public PeliculaSerieDtoInfo savePeliculaSerie(PeliculaSerieDto p);
	
	public void deletPeliculaSerie(int id);
	
	public PeliculaSerieDtoInfo updatePeliculaSerie(int id,PeliculaSerieDto p);
	
	public List<PeliculaSerieDtoInfoBasic> getInfoBasic();

	public List<PeliculaSerieDtoInfo> findByName(String name);
	
	public List<PeliculaSerieDtoInfo> findByGenero(int idPelicula);
	
	public List<PeliculaSerieDtoInfoBasic> ordenar(String orden);
}
