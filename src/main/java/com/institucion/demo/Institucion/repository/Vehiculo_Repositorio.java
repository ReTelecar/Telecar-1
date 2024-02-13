package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Vehiculo_Repositorio extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT u.interno FROM Vehiculo u WHERE u.id = :vehiculoid")
    public Long findByVehiculo(@Param("vehiculoid")Long vehiculoid);
}
