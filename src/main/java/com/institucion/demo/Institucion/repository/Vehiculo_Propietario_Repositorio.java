package com.institucion.demo.Institucion.repository;


import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.entities.Propietario_Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Vehiculo_Propietario_Repositorio extends JpaRepository<Propietario_Vehiculo, Long> {

    @Query("SELECT u.vehiculo.id FROM Propietario_Vehiculo u WHERE u.propietario.id = :id_propietario")
    public List<Long> findByPropietario(@Param("id_propietario") Long id_propietario);
}
