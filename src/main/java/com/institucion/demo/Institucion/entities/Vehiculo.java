package com.institucion.demo.Institucion.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dominio;

    private int chip;

    @Temporal(TemporalType.DATE)
    private Date baja;

    @Temporal(TemporalType.DATE)
    private Date fecha_baja;

    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    private int estado;

    @Temporal(TemporalType.DATE)
    private Date Alta;

    private String remis;

    private String disco;

    private int interno;

    private String baja_cnc;

    private Integer alta_cnc;
    private String r_marca;
    private String r_modelo;
    private String tipo;
    private String chasis;
    private String motor;

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

    public Vehiculo() {
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

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public Date getBaja() {
        return baja;
    }

    public void setBaja(Date baja) {
        this.baja = baja;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getAlta() {
        return Alta;
    }

    public void setAlta(Date alta) {
        Alta = alta;
    }

    public String getRemis() {
        return remis;
    }

    public void setRemis(String remis) {
        this.remis = remis;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public int getInterno() {
        return interno;
    }

    public void setInterno(int interno) {
        this.interno = interno;
    }

    public String getBaja_cnc() {
        return baja_cnc;
    }

    public void setBaja_cnc(String baja_cnc) {
        this.baja_cnc = baja_cnc;
    }

    public Integer getAlta_cnc() {
        return alta_cnc;
    }

    public void setAlta_cnc(Integer alta_cnc) {
        this.alta_cnc = alta_cnc;
    }

    public String getR_marca() {
        return r_marca;
    }

    public void setR_marca(String r_marca) {
        this.r_marca = r_marca;
    }

    public String getR_modelo() {
        return r_modelo;
    }

    public void setR_modelo(String r_modelo) {
        this.r_modelo = r_modelo;
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

    public Set<Chofer_Vehiculo> getChofer_vehiculos() {
        return chofer_vehiculos;
    }

    public void setChofer_vehiculos(Set<Chofer_Vehiculo> chofer_vehiculos) {
        this.chofer_vehiculos = chofer_vehiculos;
    }

    public Set<Propietario_Vehiculo> getPropietario_vehiculos() {
        return propietario_vehiculos;
    }

    public void setPropietario_vehiculos(Set<Propietario_Vehiculo> propietario_vehiculos) {
        this.propietario_vehiculos = propietario_vehiculos;
    }

    public String getAire_acondicionado() {
        return aire_acondicionado;
    }

    public void setAire_acondicionado(String aire_acondicionado) {
        this.aire_acondicionado = aire_acondicionado;
    }

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
}
