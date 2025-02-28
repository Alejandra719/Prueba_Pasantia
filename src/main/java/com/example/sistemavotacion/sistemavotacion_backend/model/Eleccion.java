package com.example.sistemavotacion.sistemavotacion_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eleccion")
public class Eleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEleccion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_final", nullable = false)
    private LocalDate fechaFinal;

    // Getters y setters

    public Integer getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(Integer idEleccion) {
        this.idEleccion = idEleccion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
