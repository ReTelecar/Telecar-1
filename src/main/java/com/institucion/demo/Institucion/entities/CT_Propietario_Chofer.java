package com.institucion.demo.Institucion.entities;

import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.serializer.AnchorGenerator;

import javax.persistence.*;

public class CT_Propietario_Chofer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Chofer chofer;

    @OneToOne
    private Propietario propietario;

    private String contrato;

    @Lob
    private byte[] fotoCont;

    public CT_Propietario_Chofer() {
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

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public byte[] getFotoCont() {
        return fotoCont;
    }

    public void setFotoCont(byte[] fotoCont) {
        this.fotoCont = fotoCont;
    }
}
