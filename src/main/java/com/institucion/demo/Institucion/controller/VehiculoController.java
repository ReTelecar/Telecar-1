package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.entities.Propietario_Vehiculo;
import com.institucion.demo.Institucion.entities.Vehiculo;
import com.institucion.demo.Institucion.repository.Persona_Repositorio;
import com.institucion.demo.Institucion.repository.Propietario_Repositorio;
import com.institucion.demo.Institucion.repository.Vehiculo_Propietario_Repositorio;
import com.institucion.demo.Institucion.services.Vehiculo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private Vehiculo_Service vehiculoService;

    @Autowired
    private Propietario_Repositorio propietarioRepositorio;

    @Autowired
    private Persona_Repositorio personaRepositorio;

    @Autowired
    private Vehiculo_Propietario_Repositorio vehiculoPropietarioRepositorio;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());

        List<Propietario> propietarios = propietarioRepositorio.findAll();
        model.addAttribute("propietarios", propietarios);

        model.addAttribute("propietarioCarga", null);

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        return "Movil/crearVehiculo.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("vehiculo") Vehiculo v, ModelMap model,
                               @RequestParam(name = "propietarioID", required = false)
                               Long id) throws MiException {
        try {
            vehiculoService.crearVehiculo(v);

            Propietario_Vehiculo propietarioVehiculo = new Propietario_Vehiculo();

            propietarioVehiculo.setVehiculo(v);
            propietarioVehiculo.setPropietario(propietarioRepositorio.findById(id).get());
            propietarioVehiculo.setActivo(true);
            propietarioVehiculo.setFecha_activacion(new Date());

            vehiculoPropietarioRepositorio.save(propietarioVehiculo);

            List<Propietario> propietarios = propietarioRepositorio.findAll();
            model.addAttribute("propietarios", propietarios);

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
            model.addAttribute("vehiculo", v);

            model.addAttribute("propietario", propietarioRepositorio.findById(id).get());

            List<Persona> personas = personaRepositorio.findAll();
            model.addAttribute("personas", personas);

            model.addAttribute("propietarioCarga", true);


        return "Movil/crearVehiculo.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarV", method = RequestMethod.POST)
    public String asignarVehiculo(@ModelAttribute("vehiculo") Vehiculo v, ModelMap model) {
        try {
            vehiculoService.crearVehiculo(v);

            model.addAttribute("vehiculo", v);

            List<Propietario> propietarios = propietarioRepositorio.findAll();
            model.addAttribute("propietarios", propietarios);

            List<Persona> personas = personaRepositorio.findAll();
            model.addAttribute("personas", personas);

        }catch (MiException ex){
            model.put("error", ex.getMessage());

            return "Movil/crearVehiculo.html";
        }


        return "Movil/crearVehiculo.html";
    }
}
