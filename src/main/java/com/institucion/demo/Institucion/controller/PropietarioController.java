package com.institucion.demo.Institucion.controller;


import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.repository.Persona_Repositorio;
import com.institucion.demo.Institucion.services.Propietario_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    private Propietario_Service propietarioService;

    @Autowired
    private Persona_Repositorio persona_repositorio;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("propietario", new Propietario());

        List<Persona> personas = persona_repositorio.findAll();
        model.addAttribute("personas", personas);

        return "Propietario/crearPropietario.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("propietario") Propietario p, ModelMap model) throws MiException {
        try {
            propietarioService.crearPropietario(p);
        } catch (MiException e) {

            model.addAttribute("persona", new Persona());
            model.put("error", e.getMessage());
            return "Propietario/crearPropietario.html";
        }
        return "Propietario/crearPropietario.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarP", method = RequestMethod.POST)
    public String asignarPersona(@ModelAttribute("propietario") Propietario p, ModelMap model) {

            model.addAttribute("propietario", p);

            List<Persona> personas = persona_repositorio.findAll();
            model.addAttribute("personas", personas);


        return "Propietario/crearPropietario.html";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        propietarioService.eliminarPersonaAsignada(id);
        return "redirect:../crear";
    }
}
