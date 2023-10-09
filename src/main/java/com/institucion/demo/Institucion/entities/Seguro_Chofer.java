package com.institucion.demo.Institucion.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Seguro_Chofer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Chofer chofer;

    @Lob
    private byte[] frente;

    @Lob
    private byte[] dorso;

    public Seguro_Chofer() {
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
}
