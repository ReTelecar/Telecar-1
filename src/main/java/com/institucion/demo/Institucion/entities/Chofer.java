package com.institucion.demo.Institucion.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Chofer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Persona persona;
    private String tel_cont_1;
    private String desc_cont_1;
    private String tel_cont_2;
    private String desc_cont_2;

    @OneToMany(mappedBy = "chofer")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Chofer_Vehiculo> chofer_vehiculos;

    public Chofer() {
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTel_cont_1() {
        return tel_cont_1;
    }

    public void setTel_cont_1(String tel_cont_1) {
        this.tel_cont_1 = tel_cont_1;
    }

    public String getDesc_cont_1() {
        return desc_cont_1;
    }

    public void setDesc_cont_1(String desc_cont_1) {
        this.desc_cont_1 = desc_cont_1;
    }

    public String getTel_cont_2() {
        return tel_cont_2;
    }

    public void setTel_cont_2(String tel_cont_2) {
        this.tel_cont_2 = tel_cont_2;
    }

    public String getDesc_cont_2() {
        return desc_cont_2;
    }

    public void setDesc_cont_2(String desc_cont_2) {
        this.desc_cont_2 = desc_cont_2;
    }
}
