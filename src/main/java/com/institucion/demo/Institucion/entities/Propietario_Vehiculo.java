package com.institucion.demo.Institucion.entities;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Propietario_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private Propietario propietario;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private Vehiculo vehiculo;

    private Boolean activo;

    @Temporal(TemporalType.DATE)
    private Date fecha_activacion;

    @Temporal(TemporalType.DATE)
    private Date fecha_baja;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFecha_activacion() {
        return fecha_activacion;
    }

    public void setFecha_activacion(Date fecha_activacion) {
        this.fecha_activacion = fecha_activacion;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public Propietario_Vehiculo() {
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
