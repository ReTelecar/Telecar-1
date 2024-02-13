package com.institucion.demo.Institucion.entities;

import javax.persistence.*;

@Entity
@Table(name = "movil_con_ctacte")
public class movil_con_ctacte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_movil_con_ctacte;
    private Long id_ctacte_movil_dgi;
    private Long id_propietario;
    private Long id_vehiculo;
    private int interno;
    private int estado;

    public movil_con_ctacte() {
    }

    public movil_con_ctacte(Long id_movil_con_ctacte, Long id_ctacte_movil_dgi, Long id_propietario, Long id_vehiculo, int interno, int estado) {
        this.id_movil_con_ctacte = id_movil_con_ctacte;
        this.id_ctacte_movil_dgi = id_ctacte_movil_dgi;
        this.id_propietario = id_propietario;
        this.id_vehiculo = id_vehiculo;
        this.interno = interno;
        this.estado = estado;
    }

    public Long getId_movil_con_ctacte() {
        return id_movil_con_ctacte;
    }

    public void setId_movil_con_ctacte(Long id_movil_con_ctacte) {
        this.id_movil_con_ctacte = id_movil_con_ctacte;
    }

    public Long getId_ctacte_movil_dgi() {
        return id_ctacte_movil_dgi;
    }

    public void setId_ctacte_movil_dgi(Long id_ctacte_movil_dgi) {
        this.id_ctacte_movil_dgi = id_ctacte_movil_dgi;
    }

    public Long getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Long id_propietario) {
        this.id_propietario = id_propietario;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
