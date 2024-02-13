package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.historicoViajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface HistoricoViajes_Repositorio extends JpaRepository<historicoViajes, Long> {

    @Query("SELECT u FROM historicoViajes u WHERE u.interno = :interno")
    public Collection<historicoViajes> findHVbyInterno(@Param("interno")int interno);


}
