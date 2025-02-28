package com.example.sistemavotacion.sistemavotacion_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @Column(length = 10)
    private String cedula; // Será la misma que la de Votante

    @OneToOne
    @MapsId
    @JoinColumn(name = "cedula")
    private Votante votante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_partido", nullable = false)
    private Partido partido;

    // Getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Votante getVotante() {
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}

