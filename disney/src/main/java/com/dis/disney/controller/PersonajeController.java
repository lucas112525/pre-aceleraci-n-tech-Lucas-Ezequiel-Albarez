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
import com.dis.disney.dto.PersonajeDtoInfo;

import com.dis.disney.service.impl.PersonajeServiceImpl;

@RestController
@RequestMapping("/personaje")
@CrossOrigin("*")
public class PersonajeController {

	@Autowired
	private PersonajeServiceImpl personajeService;
	
	@PostMapping
	public ResponseEntity<?> savePersonaje(@RequestBody PersonajeDto personajeDto){
		PersonajeDtoInfo nuevoPersonaje= personajeService.savePersonaje(personajeDto);
		return new ResponseEntity<>(nuevoPersonaje, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/detalles")
	public ResponseEntity<?> findAllPersonajes(){
		return new ResponseEntity<>(personajeService.get(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findInfoBasicPersonajes(){
		return new ResponseEntity<>(personajeService.getBasic(), HttpStatus.OK);
	}
	
	@GetMapping("/edad/{edad}")
	public ResponseEntity<?> findoByAge(@PathVariable(value = "edad") int edad){
		return new ResponseEntity<>(personajeService.findByAge(edad), HttpStatus.OK);
	}
	
	@GetMapping("/{nombre}")
	public ResponseEntity<?> findoByName(@PathVariable(value = "nombre") String nombre){
		return new ResponseEntity<>(personajeService.findByName(nombre), HttpStatus.OK);
	}
	
	@GetMapping("/pelicula/{idPeliculaSerie}")
	public ResponseEntity<?> findbyPelicula(@PathVariable(value = "idPeliculaSerie") int idPeliculaSerie){
		return new ResponseEntity<>(personajeService.findByPelicula(idPeliculaSerie), HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePersonaje(@PathVariable(value = "id") int id, @RequestBody PersonajeDto personajeDto){
		return new ResponseEntity<>(personajeService.updatePersonaje(id, personajeDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletPersonaje(@PathVariable(value = "id") int id){
		personajeService.deletPersonae(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
