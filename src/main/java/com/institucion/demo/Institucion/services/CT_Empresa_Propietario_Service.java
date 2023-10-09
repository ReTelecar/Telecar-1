package com.institucion.demo.Institucion.services;


import com.institucion.demo.Institucion.entities.CT_Empresa_Propietario;
import com.institucion.demo.Institucion.repository.CT_Empresa_Propietario_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CT_Empresa_Propietario_Service {

    @Autowired
    private CT_Empresa_Propietario_Repositorio ctEmpresaPropietarioRepositorio;


    public void crearCT_Empresa_Propietario(CT_Empresa_Propietario contrato){

        ctEmpresaPropietarioRepositorio.save(contrato);

    }
}
