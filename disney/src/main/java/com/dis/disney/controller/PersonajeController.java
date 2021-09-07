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

import com.dis.disney.dto.PersonajeDto;
import com.dis.disney.model.Personaje;
import com.dis.disney.service.impl.PersonajeServiceImpl;

@RestController
@RequestMapping("/personaje")
@CrossOrigin("*")
public class PersonajeController {

	@Autowired
	private PersonajeServiceImpl personajeService;
	
	@PostMapping
	public ResponseEntity<?> savePersonaje(@RequestBody PersonajeDto personajeDto){
		Personaje nuevoPersonaje= personajeService.savePersonaje(personajeDto);
		return new ResponseEntity<>(nuevoPersonaje, HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllPersonajes(){
		return new ResponseEntity<>(personajeService.get(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePersonaje(@PathVariable(value = "id") Integer id, @RequestBody PersonajeDto personajeDto){
		return new ResponseEntity<>(personajeService.updatePersonaje(id, personajeDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletPersonaje(@PathVariable(value = "id") Integer id){
		personajeService.deletPersonae(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
