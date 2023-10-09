package com.institucion.demo.Institucion.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Licencia_Conducir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    @OneToOne
    private Persona Persona;

    private Boolean donador;

    private String factor_sanguineo;

    @Temporal(TemporalType.DATE)
    private Date fecha_otorgamiento;

    @Temporal(TemporalType.DATE)
    private Date fecha_Vencimiento;

    @Lob
    private byte[] frente;

    @Lob
    private byte[] dorso;

    public Licencia_Conducir() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public byte[] getFrente() {
        return frente;
    }

    public void setFrente(byte[] frente) {
        this.frente = frente;
    }

    public byte[] getDorso() {
        return dorso;
    }

    public void setDorso(byte[] dorso) {
        this.dorso = dorso;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public com.institucion.demo.Institucion.entities.Persona getPersona() {
        return Persona;
    }

    public void setPersona(com.institucion.demo.Institucion.entities.Persona persona) {
        Persona = persona;
    }

    public Boolean getDonador() {
        return donador;
    }

    public void setDonador(Boolean donador) {
        this.donador = donador;
    }

    public String getFactor_sanguineo() {
        return factor_sanguineo;
    }

    public void setFactor_sanguineo(String factor_sanguineo) {
        this.factor_sanguineo = factor_sanguineo;
    }

    public Date getFecha_otorgamiento() {
        return fecha_otorgamiento;
    }

    public void setFecha_otorgamiento(Date fecha_otorgamiento) {
        this.fecha_otorgamiento = fecha_otorgamiento;
    }

    public Date getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(Date fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }
}
