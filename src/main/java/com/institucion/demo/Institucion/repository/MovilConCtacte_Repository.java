package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Permisos;
import com.institucion.demo.Institucion.entities.movil_con_ctacte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovilConCtacte_Repository extends JpaRepository<movil_con_ctacte, Long> {

    @Query("SELECT u.interno FROM movil_con_ctacte u WHERE u.id_propietario = :id_propietario")
    public List<Integer> findByPropietario(@Param("id_propietario")Long id_propietario);
}
