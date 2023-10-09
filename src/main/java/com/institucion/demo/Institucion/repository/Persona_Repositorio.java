package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Persona_Repositorio extends JpaRepository<Persona, Long> {
}
