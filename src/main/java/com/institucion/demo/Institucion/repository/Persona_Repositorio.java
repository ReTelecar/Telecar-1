package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Permisos;
import com.institucion.demo.Institucion.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Persona_Repositorio extends JpaRepository<Persona, Long> {

    @Query("SELECT u FROM Persona u WHERE u.dni = :dni")
    public Persona findPersonabyDNI(@Param("dni")String dni);
}
