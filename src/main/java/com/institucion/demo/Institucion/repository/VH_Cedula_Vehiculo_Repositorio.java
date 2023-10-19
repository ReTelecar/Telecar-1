package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.VH_Cedula_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VH_Cedula_Vehiculo_Repositorio extends JpaRepository<VH_Cedula_Vehiculo, Long> {
}
