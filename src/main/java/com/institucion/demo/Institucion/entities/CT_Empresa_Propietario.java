package com.institucion.demo.Institucion.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CT_Empresa_Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Empresa empresa;

    @OneToOne
    private Propietario propietario;

    private String contrato;

    @Temporal(TemporalType.DATE)
    private Date fecha_vencimiento;

    @Lob
    private byte[] fotoCont;

    public CT_Empresa_Propietario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
