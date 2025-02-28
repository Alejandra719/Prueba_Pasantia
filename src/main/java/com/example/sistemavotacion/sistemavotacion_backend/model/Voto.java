package com.example.sistemavotacion.sistemavotacion_backend.model;

import jakarta.persistence.*;;

@Entity
@Table(name = "voto", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_eleccion", "cedula_votante"})})
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVoto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_eleccion", nullable = false)
    private Eleccion eleccion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cedula_votante", nullable = false)
    private Votante votante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cedula_candidato", nullable = false)
    private Candidato candidato;

    // Getters y setters

    public Integer getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Eleccion getEleccion() {
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    public Votante getVotante() {
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
