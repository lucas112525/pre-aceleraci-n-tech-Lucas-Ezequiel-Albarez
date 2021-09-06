package com.dis.disney.service;

import java.util.List;

import com.dis.disney.dto.GeneroDto;
import com.dis.disney.model.Genero;

public interface GeneroService {
	public List<Genero> get();
	public Genero saveGenero(GeneroDto g);
	public void deletGenero(Long id);
	public Genero updateGenero(Long id, GeneroDto g);
	
	

}
