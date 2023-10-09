package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.entities.Propietario_Vehiculo;
import com.institucion.demo.Institucion.entities.Vehiculo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/chofer")
public class ChoferController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("chofer", new Chofer());

        List<Propietario> propietarios = propietarioRepositorio.findAll();
        model.addAttribute("propietarios", propietarios);

        model.addAttribute("propietarioCarga", null);

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        return "Movil/crearVehiculo.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("vehiculo") Vehiculo coche, ModelMap model) throws MiException {
        try {
        } catch (MiException e) {

            model.addAttribute("vehiculo", new Vehiculo());

            model.put("error", e.getMessage());
            return "persona/crearPersona.html";

        }
        return "Movil/crearVehiculo.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarP", method = RequestMethod.POST)
    public String asignarPersona(@ModelAttribute("vehiculo") Vehiculo v, @RequestParam(name = "propietarioID", required = false)
    Long id, ModelMap model) {
        try {


        }catch (MiException ex){
            model.put("error", ex.getMessage());

            return "Movil/crearVehiculo.html";
        }


        return "Movil/crearVehiculo.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarV", method = RequestMethod.POST)
    public String asignarVehiculo(@ModelAttribute("vehiculo") Vehiculo v, ModelMap model) {
        try {


        }catch (MiException ex){
            model.put("error", ex.getMessage());

            return "Movil/crearVehiculo.html";
        }


        return "Movil/crearVehiculo.html";
    }
}
