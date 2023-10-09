package com.institucion.demo.Institucion.services;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.repository.Persona_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class Persona_Service {
    @Autowired
    private Persona_Repositorio personaRepositorio;


    @Transactional
    public void crearPersona(Persona p, MultipartFile fotoDF, MultipartFile fotoDD) throws MiException, IOException {
        validatePersona(p);

        byte[] fileBytesDF = fotoDF.getBytes();
        byte[] fileBytesDD = fotoDD.getBytes();

        p.setDorsoDNI(fileBytesDD);
        p.setFrenteDNI(fileBytesDF);

        personaRepositorio.save(p);
    }



    public void validatePersona(Persona p) throws MiException {
        if(p.getApellido().isEmpty() || p.getApellido() == null){
            throw new MiException("Por favor, Ingrese un Apellido");
        }
        if(p.getNombre().isEmpty() || p.getNombre() == null){
            throw new MiException("Por favor, Ingrese un Nombre");
        }
        if(p.getCuil().isEmpty() || p.getCuil() == null || p.getCuil().length() < 11){
            throw new MiException("Por favor, Ingrese un Cuil valido");
        }
        if(p.getCiudad() == null || p.getCiudad().isEmpty()){
            throw new MiException("Por favor, Ingrese una Ciudad");
        }
        if(p.getLocalidad() == null || p.getLocalidad().isEmpty()){
            throw new MiException("Por favor, Ingrese un Domicilio");
        }
        if(p.getProvincia() == null || p.getProvincia().isEmpty()){
            throw new MiException("Por favor, Ingrese un Domicilio");
        }
        if(p.getEdad() == null){
            throw new MiException("Por favor, Ingrese una Edad");
        }
        if(p.getFechaNacimiento() == null || p.getFechaNacimiento().isEmpty()){
            throw new MiException("Por favor, Ingrese una Fecha de Nacimiento");
        }
        if(p.getDni() == null || p.getDni().isEmpty()){
            throw new MiException("Por favor, Ingrese un DNI");
        }
    }
}
