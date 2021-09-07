package com.dis.disney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dis.disney.dto.PeliculaSerieDto;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.service.impl.PeliculaSerieServiceImpl;

@RestController
@RequestMapping("/pelicula-serie")
@CrossOrigin("*")
public class PeliculaSerieController {

	@Autowired
	private PeliculaSerieServiceImpl peliculaSerieService;
	
	@PostMapping
	public ResponseEntity<?> savePeliculaSerie(@RequestBody PeliculaSerieDto peliculaSerieDto){
		PeliculaSerie nuevaPeliculaSerie = peliculaSerieService.savePeliculaSerie(peliculaSerieDto);
		return new ResponseEntity<>(nuevaPeliculaSerie, HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllPeliculaSerie(){
		return new ResponseEntity<>(peliculaSerieService.get(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePeliculaSerie(@PathVariable(value = "id") Integer id,@RequestBody PeliculaSerieDto peliculaSerieDto){
		return new ResponseEntity<>(peliculaSerieService.updatePeliculaSerie(id, peliculaSerieDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletPersonaje(@PathVariable(value = "id") Integer id){
		peliculaSerieService.deletPeliculaSerie(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
