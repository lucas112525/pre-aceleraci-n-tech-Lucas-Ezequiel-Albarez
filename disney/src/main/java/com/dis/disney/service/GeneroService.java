package com.dis.disney.service;

import java.util.List;

import com.dis.disney.dto.GeneroDto;
import com.dis.disney.dto.GeneroDtoInfo;

public interface GeneroService {
	public List<GeneroDtoInfo> get();
	public GeneroDtoInfo saveGenero(GeneroDto g);
	public void deletGenero(int id);
	public GeneroDtoInfo updateGenero(int id, GeneroDto g);
	
	

}
