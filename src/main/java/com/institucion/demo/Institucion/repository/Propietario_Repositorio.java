package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Propietario_Repositorio extends JpaRepository<Propietario, Long> {
}
