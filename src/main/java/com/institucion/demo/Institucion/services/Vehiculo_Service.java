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

        }
    }

