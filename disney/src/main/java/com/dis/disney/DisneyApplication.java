package com.dis.disney;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dis.disney.model.Personaje;
import com.dis.disney.repository.PersonajeRepository;

@SpringBootApplication
public class DisneyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DisneyApplication.class);
	

	public static void main(String[] args) {
	  SpringApplication.run(DisneyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonajeRepository repository) {
	  return (args) -> {
		  Personaje pj1= new Personaje();
		  pj1.setEdad(10);
		  pj1.setNombre("Lucas");
		  pj1.setHistoria("hola1234");
		  pj1.setPeso(50);
		  pj1.setImagen("url24");
		  Personaje pj2= new Personaje();
		  pj2.setEdad(12);
		  pj2.setNombre("Esteban");
		  pj2.setHistoria("hola1334");
		  pj2.setPeso(40);
		  pj2.setImagen("ur12324");
		  
		  //guardo algunos personajes
		  repository.save(pj1);
		  repository.save(pj2);
		  
		  //muestro los personajes
		  log.info("Lista de personajes");
		  log.info("-----------------------------");
		  for(Personaje personaje: repository.findAll()) {
			  log.info(personaje.getNombre());
			  log.info(String.valueOf(personaje.getEdad()));
		  }
		  
		
	  
	  
	  
	  };
		
	}

}
