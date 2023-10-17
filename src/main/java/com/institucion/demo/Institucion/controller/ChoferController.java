package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.*;
import com.institucion.demo.Institucion.repository.Persona_Repositorio;
import com.institucion.demo.Institucion.repository.Vehiculo_Propietario_Repositorio;
import com.institucion.demo.Institucion.repository.Vehiculo_Repositorio;
import com.institucion.demo.Institucion.services.Chofer_Service;
import com.institucion.demo.Institucion.services.Persona_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/chofer")
public class ChoferController {

    @Autowired
    private Chofer_Service choferService;

    @Autowired
    private Persona_Repositorio personaRepositorio;

    @Autowired
    private Vehiculo_Repositorio vehiculoRepositorio;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("chofer", new Chofer());

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        List<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
        model.addAttribute("vehiculos", vehiculos);

        model.addAttribute("propietarioCarga", null);

        return "Chofer/crearChofer.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("chofer") Chofer chofer, ModelMap model) throws MiException {

        choferService.crearChofer(chofer);

        return "Chofer/crearChofer.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarV", method = RequestMethod.POST)
    public String asignarVehiculo(@ModelAttribute("chofer") Chofer c, @RequestParam(name = "vehiculoID", required = false)
    Long id, ModelMap model) {
            choferService.crearChofer(c);

            Chofer_Vehiculo choferVehiculo = new Chofer_Vehiculo();

            choferVehiculo.setVehiculo(vehiculoRepositorio.findById(id).get());
            choferVehiculo.setChofer(c);
            choferVehiculo.setActivo(true);
            choferVehiculo.setFecha_activacion(new Date());

            model.addAttribute("chofer", c);

            model.addAttribute("vehiculo", vehiculoRepositorio.findById(id).get());

            List<Persona> personas = personaRepositorio.findAll();
            model.addAttribute("personas", personas);

            model.addAttribute("cargado", true);



        return "Chofer/crearChofer.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarP", method = RequestMethod.POST)
    public String asignarPersona(@ModelAttribute("chofer") Chofer c, ModelMap model) {

            choferService.crearChofer(c);
            model.addAttribute("chofer", c);

            model.addAttribute("personaCargado", true);

            List<Persona> personas = personaRepositorio.findAll();
            model.addAttribute("personas", personas);



        return "Chofer/crearChofer.html";
    }


}
