package com.example.sistemavotacion.sistemavotacion_backend.repository;

import com.example.sistemavotacion.sistemavotacion_backend.model.Eleccion;
import com.example.sistemavotacion.sistemavotacion_backend.model.Votante;
import com.example.sistemavotacion.sistemavotacion_backend.model.Voto;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
    Optional<Voto> findByEleccionAndVotante(Eleccion eleccion, Votante votante);

    @Query("SELECT v.candidato.cedula AS cedulaCandidato, COUNT(v) AS totalVotos " +
        "FROM Voto v " +
        "GROUP BY v.candidato.cedula " +
        "ORDER BY COUNT(v) DESC")
    List<Object[]> contarVotosPorCandidato();

}

