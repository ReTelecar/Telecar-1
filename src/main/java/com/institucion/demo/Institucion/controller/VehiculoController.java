package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.*;
import com.institucion.demo.Institucion.repository.*;
import com.institucion.demo.Institucion.services.Vehiculo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private Vehiculo_Service vehiculoService;

    @Autowired
    private Vehiculo_Repositorio vehiculoRepositorio;

    @Autowired
    private Propietario_Repositorio propietarioRepositorio;

    @Autowired
    private Persona_Repositorio personaRepositorio;

    @Autowired
    private Vehiculo_Propietario_Repositorio vehiculoPropietarioRepositorio;

    @Autowired
    private Chofer_Repositorio choferRepositorio;

    @Autowired
    private Chofer_Vehiculo_Repositorio choferVehiculoRepositorio;

    @Autowired
    private VH_Cedula_Vehiculo_Repositorio vhCedulaVehiculoRepositorio;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("cedula", new VH_Cedula_Vehiculo());


        List<Propietario> propietarios = propietarioRepositorio.findAll();
        model.addAttribute("propietarios", propietarios);

        List<Chofer> choferes = choferRepositorio.findAll();
        model.addAttribute("choferes", choferes);

        model.addAttribute("propietarioCarga", null);
        model.addAttribute("choferCarga", null);

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        return "Movil/crearVehiculo.html";
    }


    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarP", method = RequestMethod.POST)
    public String asignarPersona(@ModelAttribute("vehiculo") Vehiculo v, @RequestParam(name = "propietarioID", required = false)
    Long idpropietario, @RequestParam(name = "choferID", required = false)
                                 Long idchofer, ModelMap model) {
        model.addAttribute("vehiculo", v);
        model.addAttribute("cedula", new VH_Cedula_Vehiculo());

        model.addAttribute("propietario", propietarioRepositorio.findById(idpropietario).get());

        if (idchofer != null) {
            model.addAttribute("chofer", choferRepositorio.findById(idchofer).get());
            model.addAttribute("choferCarga", true);
        } else {
            List<Chofer> choferes = choferRepositorio.findAll();
            model.addAttribute("choferes", choferes);
            model.addAttribute("choferCarga", null);
        }

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);
        model.addAttribute("propietarioCarga", true);


        return "Movil/crearVehiculo.html";
    }

    // Carga PPpersona Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarC", method = RequestMethod.POST)
    public String asignarVehiculo(@ModelAttribute("vehiculo") Vehiculo v,
                                  @RequestParam(name = "propietarioID", required = false) Long idpropietario,
                                  @RequestParam(name = "choferID", required = false)
                                  Long idchofer,
                                  ModelMap model) {

        model.addAttribute("vehiculo", v);
        model.addAttribute("cedula", new VH_Cedula_Vehiculo());


        if (idpropietario != null) {
            model.addAttribute("propietario", propietarioRepositorio.findById(idpropietario).get());
            model.addAttribute("propietarioCarga", true);
        } else {
            List<Propietario> propietarios = propietarioRepositorio.findAll();
            model.addAttribute("propietarios", propietarios);
            model.addAttribute("propietarioCarga", null);
        }

        model.addAttribute("chofer", choferRepositorio.findById(idchofer).get());

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        model.addAttribute("choferCarga", true);

        return "Movil/crearVehiculo.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("vehiculo") Vehiculo v, ModelMap model,
                               @RequestParam(name = "propietarioID", required = false)
                               Long idpropietario, @RequestParam(name = "choferID", required = false)
                               Long idchofer,
                               @RequestParam(value = "foto1", required = false) MultipartFile foto1,
                               @RequestParam(value = "foto2", required = false) MultipartFile foto2,
                               @RequestParam(value = "foto3", required = false) MultipartFile foto3,
                               @RequestParam(value = "foto4", required = false) MultipartFile foto4) throws MiException, IOException {

        if(foto1 != null && !foto1.isEmpty()  ){
            byte[] fileBytes1 = foto1.getBytes();
            v.setFoto1(fileBytes1);
        }
        if(foto2 != null &&  !foto2.isEmpty()){
            byte[] fileBytes2 = foto2.getBytes();
            v.setFoto2(fileBytes2);
        }
        if(foto3 != null && !foto3.isEmpty()){
            byte[] fileBytes3 = foto3.getBytes();
            v.setFoto3(fileBytes3);
        }
        if(foto4 != null && !foto4.isEmpty()){
            byte[] fileBytes4 = foto4.getBytes();
            v.setFoto4(fileBytes4);
        }

        vehiculoService.crearVehiculo(v);


        model.addAttribute("vehiculo", v);

        model.addAttribute("cedula", new VH_Cedula_Vehiculo());

        //crear propietario_vehiculo
        Propietario_Vehiculo propietarioVehiculo = new Propietario_Vehiculo();

        //asignar propietario_vehiculo
        propietarioVehiculo.setVehiculo(v);
        propietarioVehiculo.setPropietario(propietarioRepositorio.findById(idpropietario).get());
        propietarioVehiculo.setActivo(true);
        propietarioVehiculo.setFecha_activacion(new Date());

        //crear chofer_vehiculo
        Chofer_Vehiculo choferVehiculo = new Chofer_Vehiculo();


        //asignar chofer_vehiculo
        choferVehiculo.setChofer(choferRepositorio.findById(idchofer).get());
        choferVehiculo.setActivo(true);
        choferVehiculo.setFecha_activacion(new Date());
        choferVehiculo.setVehiculo(v);

        //guardar chofer_vehiculo
        choferVehiculoRepositorio.save(choferVehiculo);


        //guardar propietario_vehiculo
        vehiculoPropietarioRepositorio.save(propietarioVehiculo);

        model.addAttribute("propietario", propietarioRepositorio.findById(idpropietario).get());
        model.addAttribute("chofer", choferRepositorio.findById(idchofer).get());

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        model.addAttribute("propietarioCarga", true);
        model.addAttribute("choferCarga", true);
        model.addAttribute("vehiCarga", true);


        return "Movil/crearVehiculo.html";
    }

    // Carga PPseguro Post
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/asignarCedula", method = RequestMethod.POST)
    public String asignarVehiculoCedula(@ModelAttribute("cedula") VH_Cedula_Vehiculo c,
                                        @RequestParam(name = "vehiculoID", required = false) Long vehiculoID,
                                        @RequestParam(name = "propietarioID", required = false)
                                            Long idpropietario, @RequestParam(name = "choferID", required = false)
                                            Long idchofer, @RequestParam("fotoDF") MultipartFile fotoDF,
                                        @RequestParam("fotoDD") MultipartFile fotoDD,
                                        ModelMap model) throws IOException {

        byte[] fileBytesDF = fotoDF.getBytes();
        byte[] fileBytesDD = fotoDD.getBytes();

        c.setVehiculo(vehiculoRepositorio.findById(vehiculoID).get());
        c.setPropietario(propietarioRepositorio.findById(idpropietario).get());
        c.setPersona(propietarioRepositorio.findById(idpropietario).get().getPersona());
        c.setDorso(fileBytesDF);
        c.setFrente(fileBytesDD);

        vhCedulaVehiculoRepositorio.save(c);

        model.addAttribute("cedula", c);
        model.addAttribute("vehiculo", vehiculoRepositorio.findById(vehiculoID).get());

        model.addAttribute("propietario", propietarioRepositorio.findById(idpropietario).get());
        model.addAttribute("chofer", choferRepositorio.findById(idchofer).get());

        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas", personas);

        model.addAttribute("propietarioCarga", true);
        model.addAttribute("choferCarga", true);
        model.addAttribute("vehiCarga", true);


        return "Movil/crearVehiculo.html";
    }
}
