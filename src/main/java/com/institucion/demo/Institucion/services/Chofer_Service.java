package com.institucion.demo.Institucion.services;

import com.institucion.demo.Institucion.entities.Chofer;
import com.institucion.demo.Institucion.repository.Chofer_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class Chofer_Service {

    @Autowired
    private Chofer_Repositorio choferRepositorio;



    @Transactional
    public void crearChofer(Chofer c){



        choferRepositorio.save(c);


    }
}
