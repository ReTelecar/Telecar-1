package com.institucion.demo.Institucion.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dominio;
    private String marca;
    private String modelo;
    private String tipo;
    private String chasis;
    private String motor;
    private String estado;

    @OneToMany(mappedBy = "vehiculo")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Chofer_Vehiculo> chofer_vehiculos;

    @OneToMany(mappedBy = "vehiculo")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Propietario_Vehiculo> propietario_vehiculos;


    private String aire_acondicionado;

    @Lob
    private byte[] foto1;

    @Lob
    private byte[] foto2;

    @Lob
    private byte[] foto3;

    @Lob
    private byte[] foto4;

    public byte[] getFoto1() {
        return foto1;
    }

    public void setFoto1(byte[] foto1) {
        this.foto1 = foto1;
    }

    public byte[] getFoto2() {
        return foto2;
    }

    public void setFoto2(byte[] foto2) {
        this.foto2 = foto2;
    }

    public byte[] getFoto3() {
        return foto3;
    }

    public void setFoto3(byte[] foto3) {
        this.foto3 = foto3;
    }

    public byte[] getFoto4() {
        return foto4;
    }

    public void setFoto4(byte[] foto4) {
        this.foto4 = foto4;
    }

    public Vehiculo() {
    }

    public Set<Propietario_Vehiculo> getPropietario_vehiculos() {
        return propietario_vehiculos;
    }

    public void setPropietario_vehiculos(Set<Propietario_Vehiculo> propietario_vehiculos) {
        this.propietario_vehiculos = propietario_vehiculos;
    }

    public Set<Chofer_Vehiculo> getChofer_vehiculos() {
        return chofer_vehiculos;
    }

    public void setChofer_vehiculos(Set<Chofer_Vehiculo> chofer_vehiculos) {
        this.chofer_vehiculos = chofer_vehiculos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAire_acondicionado() {
        return aire_acondicionado;
    }

    public void setAire_acondicionado(String aire_acondicionado) {
        this.aire_acondicionado = aire_acondicionado;
    }
}
