package com.institucion.demo.Institucion.config;

import Util.BaseAutoFlot;
import Util.BaseDestino;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Vehiculo {

    @Bean
    public Datos.Vehiculo Vehiculo() {
        Datos.Vehiculo Vehiculo = new Datos.Vehiculo(new BaseDestino());
        return Vehiculo;
    }
}
