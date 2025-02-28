package com.example.sistemavotacion.sistemavotacion_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "votante")

public class Votante {

    @Id
    @Column(length = 10)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String nacionalidad = "Colombiano";

    @Column(name = "voto_emitido", nullable = false)
    private Boolean votoEmitido = false;

    // Constructores
    public Votante() {
    }

    public Votante(String cedula, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getVotoEmitido() {
        return votoEmitido;
    }

    public void setVotoEmitido(Boolean votoEmitido) {
        this.votoEmitido = votoEmitido;
    }
}
