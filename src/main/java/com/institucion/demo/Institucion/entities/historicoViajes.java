package com.institucion.demo.Institucion.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "historico_viajes")
public class historicoViajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fecha_viaje;
    private Long id_propietario;
    private String apellido_propietario;
    private String nombre_propietario;
    private Long id_vehiculo;
    private int interno;
    private Long id_chofer;
    private String apellido_chofer;
    private String nombre_chofer;
    private String direccion_viaje;
    private Timestamp fh_ini;
    private Timestamp fh_fin;
    private int duracion_viaje;
    private int km_viaje;
    private String calle_operador;

    private int nro_viaje;

    private Float monto_viaje;

    public historicoViajes() {
    }

    public historicoViajes(Long id, Date fecha_viaje, Long id_propietario, String apellido_propietario, String nombre_propietario, Long id_vehiculo, int interno, Long id_chofer, String apellido_chofer, String nombre_chofer, String direccion_viaje, Timestamp fh_ini, Timestamp fh_fin, int duracion_viaje, int km_viaje, String calle_operador, int nro_viaje, Float monto_viaje) {
        this.id = id;
        this.fecha_viaje = fecha_viaje;
        this.id_propietario = id_propietario;
        this.apellido_propietario = apellido_propietario;
        this.nombre_propietario = nombre_propietario;
        this.id_vehiculo = id_vehiculo;
        this.interno = interno;
        this.id_chofer = id_chofer;
        this.apellido_chofer = apellido_chofer;
        this.nombre_chofer = nombre_chofer;
        this.direccion_viaje = direccion_viaje;
        this.fh_ini = fh_ini;
        this.fh_fin = fh_fin;
        this.duracion_viaje = duracion_viaje;
        this.km_viaje = km_viaje;
        this.calle_operador = calle_operador;
        this.nro_viaje = nro_viaje;
        this.monto_viaje = monto_viaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(Date fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public Long getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Long id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getApellido_propietario() {
        return apellido_propietario;
    }

    public void setApellido_propietario(String apellido_propietario) {
        this.apellido_propietario = apellido_propietario;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getInterno() {
        return interno;
    }

    public void setInterno(int interno) {
        this.interno = interno;
    }

    public Long getId_chofer() {
        return id_chofer;
    }

    public void setId_chofer(Long id_chofer) {
        this.id_chofer = id_chofer;
    }

    public String getApellido_chofer() {
        return apellido_chofer;
    }

    public void setApellido_chofer(String apellido_chofer) {
        this.apellido_chofer = apellido_chofer;
    }

    public String getNombre_chofer() {
        return nombre_chofer;
    }

    public void setNombre_chofer(String nombre_chofer) {
        this.nombre_chofer = nombre_chofer;
    }

    public String getDireccion_viaje() {
        return direccion_viaje;
    }

    public void setDireccion_viaje(String direccion_viaje) {
        this.direccion_viaje = direccion_viaje;
    }

    public Timestamp getFh_ini() {
        return fh_ini;
    }

    public void setFh_ini(Timestamp fh_ini) {
        this.fh_ini = fh_ini;
    }

    public Timestamp getFh_fin() {
        return fh_fin;
    }

    public void setFh_fin(Timestamp fh_fin) {
        this.fh_fin = fh_fin;
    }

    public int getDuracion_viaje() {
        return duracion_viaje;
    }

    public void setDuracion_viaje(int duracion_viaje) {
        this.duracion_viaje = duracion_viaje;
    }

    public int getKm_viaje() {
        return km_viaje;
    }

    public void setKm_viaje(int km_viaje) {
        this.km_viaje = km_viaje;
    }

    public String getCalle_operador() {
        return calle_operador;
    }

    public void setCalle_operador(String calle_operador) {
        this.calle_operador = calle_operador;
    }

    public int getNro_viaje() {
        return nro_viaje;
    }

    public void setNro_viaje(int nro_viaje) {
        this.nro_viaje = nro_viaje;
    }

    public Float getMonto_viaje() {
        return monto_viaje;
    }

    public void setMonto_viaje(Float monto_viaje) {
        this.monto_viaje = monto_viaje;
    }
}
