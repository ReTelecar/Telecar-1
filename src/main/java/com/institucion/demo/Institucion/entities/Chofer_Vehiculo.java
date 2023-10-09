package com.institucion.demo.Institucion.entities;

import net.bytebuddy.utility.nullability.MaybeNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Chofer_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private Chofer chofer;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private Vehiculo vehiculo;

    private Boolean activo;

    @Temporal(TemporalType.DATE)
    private Date fecha_activacion;

    @Temporal(TemporalType.DATE)
    private Date fecha_baja;

    public Chofer_Vehiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
