package com.dis.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dis.disney.model.PeliculaSerie;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {
	public List<PeliculaSerie> findByCalificacion(Long calificacion); 
}
