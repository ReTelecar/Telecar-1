package com.institucion.demo.Institucion.config;

import Util.BaseAutoFlot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseAutofloat {

    @Bean
    public BaseAutoFlot baseAutoFlot() {
        BaseAutoFlot baseAutoFlot= new BaseAutoFlot();
        return baseAutoFlot;
    }
}
