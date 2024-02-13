package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.entities.Usuario;
import com.institucion.demo.Institucion.entities.historicoViajes;
import com.institucion.demo.Institucion.repository.*;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/vh-CnVia")
public class HistoricoViajesController {

    @Autowired
    private HistoricoViajes_Repositorio historicoViajesRepositorio;
    @Autowired
    private MovilConCtacte_Repository movilConCtacteRepository;
    @Autowired
    private Persona_Repositorio personaRepositorio;

    @Autowired
    private Vehiculo_Repositorio vehiculoRepositorio;

    @Autowired
    private Vehiculo_Propietario_Repositorio vehiculoPropietarioRepositorio;

    @Autowired
    private Propietario_Repositorio propietarioRepositorio;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/Con-Hist.Viajes")
    public String consultarInternos(Model model, HttpSession session, @RequestParam(name = "internoSelec", required = true) int internoSelec) {
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        model.addAttribute("notificar", false);
        model.addAttribute("cargarNotas", false);

        if(internoSelec <= 0){
            model.addAttribute("internoC", false);
        } else {
            model.addAttribute("internoC", true);
        }

        Persona p = personaRepositorio.findPersonabyDNI(logueado.getEmail());
        Propietario propietario = propietarioRepositorio.findPropietariobyPersonaID(p.getId());

        Collection<Long> vehiculosID = vehiculoPropietarioRepositorio.findByPropietario(propietario.getId());

        List<Long> internos = new ArrayList<>();

        for (Long id: vehiculosID) {
           internos.add(vehiculoRepositorio.findByVehiculo(id));
        }

        model.addAttribute("internos", internos);


        //INTERNO SELECCIONADO

        Collection<historicoViajes> historicoViajes = historicoViajesRepositorio.findHVbyInterno(internoSelec);

        model.addAttribute("historicoviajes", historicoViajes);


        return "Movil/consultarMovil.html";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/Con-Interno-E")
    public String consultarInterno(Model model, HttpSession session, @RequestParam(name = "internoSelec",required = true) String internoSelec) {

        return "redirect:/vh-CnVia/Con-Hist.Viajes?internoSelec=" + internoSelec;
    }
}
