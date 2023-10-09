package com.institucion.demo.Institucion.services;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.repository.Propietario_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class Propietario_Service {

    @Autowired
    private Propietario_Repositorio propietarioRepositorio;


    @Transactional
    public void crearPropietario(Propietario p) throws MiException {
        validatePropietario(p);

        propietarioRepositorio.save(p);

    }

    @org.springframework.transaction.annotation.Transactional
    public void cargarPersona(Propietario p) throws MiException {
        propietarioRepositorio.save(p);
    }

    @org.springframework.transaction.annotation.Transactional
    public void eliminarPersonaAsignada(Long id) {

        propietarioRepositorio.deleteById(id);
    }


    public void validatePropietario(Propietario p) throws MiException {
        if(p.getDesc_cont_1().isEmpty() || p.getDesc_cont_1() == null){
            throw new MiException("Por favor, Ingrese una Descripcion");
        }
        if(p.getDesc_cont_2().isEmpty() || p.getDesc_cont_2() == null){
            throw new MiException("Por favor, Ingrese una Descripcion");
        }
        if(p.getTel_cont_1().isEmpty() || p.getTel_cont_1() == null){
            throw new MiException("Por favor, Ingrese un Celular");
        }
        if(p.getTel_cont_2().isEmpty() || p.getTel_cont_2() == null){
            throw new MiException("Por favor, Ingrese un Celular");
        }

    }
}
