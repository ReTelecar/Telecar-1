package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Chofer_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Chofer_Vehiculo_Repositorio extends JpaRepository<Chofer_Vehiculo, Long> {
}
