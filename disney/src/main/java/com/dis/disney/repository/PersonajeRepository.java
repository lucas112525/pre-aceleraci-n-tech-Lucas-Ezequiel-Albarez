package com.dis.disney.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dis.disney.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{

	public List<Personaje> findByNombre(String nombre);
	
	public List<Personaje> findByEdad(Integer edad);
	
	
	
}
