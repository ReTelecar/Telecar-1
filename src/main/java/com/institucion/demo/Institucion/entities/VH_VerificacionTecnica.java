package com.institucion.demo.Institucion.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VH_VerificacionTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Vehiculo vehiculo;

    @OneToOne
    private Propietario propietario;

    @Temporal(TemporalType.DATE)
    private Date fecha_Otorg;

    @Temporal(TemporalType.DATE)
    private Date fecha_vencimiento;

    @Lob
    private byte[] foto;

    public VH_VerificacionTecnica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Date getFecha_Otorg() {
        return fecha_Otorg;
    }

    public void setFecha_Otorg(Date fecha_Otorg) {
        this.fecha_Otorg = fecha_Otorg;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
