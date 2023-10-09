package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Persona;
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

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private Persona_Service personaService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("persona", new Persona());

        return "persona/crearPersona.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("persona") Persona persona, ModelMap model,
                               @RequestParam("fotoDF") MultipartFile fotoDF,
                               @RequestParam("fotoDD") MultipartFile fotoDD) throws MiException {
        try {
            personaService.crearPersona(persona, fotoDF, fotoDD);
        } catch (MiException e) {

            model.addAttribute("persona", new Persona());
            model.put("error", e.getMessage());
            return "persona/crearPersona.html";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "persona/crearPersona.html";
    }
}
