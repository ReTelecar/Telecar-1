package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.VH_Habil_Municipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VH_Habilitacion_Municipal_Repositorio extends JpaRepository<VH_Habil_Municipal, Long> {
}
