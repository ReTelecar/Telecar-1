package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vehiculo_Repositorio extends JpaRepository<Vehiculo, Long> {
}
