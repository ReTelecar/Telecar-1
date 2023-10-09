package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Chofer_Repositorio extends JpaRepository<Chofer, Long> {
}
