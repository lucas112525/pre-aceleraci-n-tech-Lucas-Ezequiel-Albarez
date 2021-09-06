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

import com.dis.disney.dto.GeneroDto;
import com.dis.disney.model.Genero;
import com.dis.disney.service.impl.GeneroServiceImpl;

@RestController
@RequestMapping("/genero")
@CrossOrigin("*")
public class GeneroController {

	@Autowired
	private GeneroServiceImpl generoService;
	

	@PostMapping
	public ResponseEntity<?> saveGenero(@RequestBody GeneroDto generoDto){
		Genero nuevoGenero=generoService.saveGenero(generoDto);
		return new ResponseEntity<>(nuevoGenero, HttpStatus.ACCEPTED); 
	}
	
	@GetMapping
	public ResponseEntity<?> findAllGenero(){
		return new ResponseEntity<>(generoService.get(), HttpStatus.OK);
	}
	

	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePeliculaSerie(@PathVariable(value = "id") Long id,@RequestBody GeneroDto generoDto){
		return new ResponseEntity<>(generoService.updateGenero(id, generoDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletPersonaje(@PathVariable(value = "id") Long id){
	generoService.deletGenero(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
}
