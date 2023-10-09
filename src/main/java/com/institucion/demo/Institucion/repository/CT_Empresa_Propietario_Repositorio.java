package com.institucion.demo.Institucion.repository;

import com.institucion.demo.Institucion.entities.CT_Empresa_Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CT_Empresa_Propietario_Repositorio extends JpaRepository<CT_Empresa_Propietario, Long> {

}
