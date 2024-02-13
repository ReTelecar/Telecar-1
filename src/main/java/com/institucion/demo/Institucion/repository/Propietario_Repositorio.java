package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.entities.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Propietario_Repositorio extends JpaRepository<Propietario, Long> {

    @Query("SELECT u FROM Propietario u WHERE u.persona.id = :personaid")
    public Propietario findPropietariobyPersonaID(@Param("personaid")Long personaid);
}
