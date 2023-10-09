package com.institucion.demo.Institucion.services;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.entities.Vehiculo;
import com.institucion.demo.Institucion.repository.Vehiculo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class Vehiculo_Service {

    @Autowired
    private Vehiculo_Repositorio vehiculoRepositorio;


    @Transactional
    public void crearVehiculo(Vehiculo coche) throws MiException {

        vehiculoRepositorio.save(coche);

    }


    public void validateVehiculo(Vehiculo coche) throws MiException {
        if(coche.getChasis().isEmpty() || coche.getChasis() == null){
            throw new MiException("Por favor, Ingrese un Chasis");
        }

        if(coche.getDominio().isEmpty() || coche.getDominio() == null){
            throw new MiException("Por favor, Ingrese un Dominio");
        }
        if(coche.getEstado().isEmpty() || coche.getEstado() == null){
            throw new MiException("Por favor, Ingrese un Estado");
        }
        if(coche.getMarca().isEmpty() || coche.getMarca() == null){
            throw new MiException("Por favor, Ingrese una Marca");
        }
        if(coche.getModelo().isEmpty() || coche.getModelo() == null){
            throw new MiException("Por favor, Ingrese un Modelo");
        }
        if(coche.getMotor().isEmpty() || coche.getMotor() == null){
            throw new MiException("Por favor, Ingrese un Motor");
        }
    }

}
