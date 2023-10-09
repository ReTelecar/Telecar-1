package com.institucion.demo.Institucion.repository;


import com.institucion.demo.Institucion.entities.Propietario_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vehiculo_Propietario_Repositorio extends JpaRepository<Propietario_Vehiculo, Long> {
}
