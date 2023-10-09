package com.institucion.demo.Institucion.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;


@Entity
public class CH_Habil_Municipal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Chofer chofer;
    private String descriptcion;

    @Temporal(TemporalType.DATE)
    private Date vencimiento;

    @Lob
    private byte[] frente;

    @Lob
    private byte[] dorso;

    public CH_Habil_Municipal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public String getDescriptcion() {
        return descriptcion;
    }

    public void setDescriptcion(String descriptcion) {
        this.descriptcion = descriptcion;
    }

    public Date getVencimiento() {
        return vencimiento;
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

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

}
