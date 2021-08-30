package com.dis.disney.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dis.disney.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

}
