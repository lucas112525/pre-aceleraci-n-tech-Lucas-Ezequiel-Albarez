package com.dis.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dis.disney.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
