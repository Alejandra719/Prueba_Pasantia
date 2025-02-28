package com.example.sistemavotacion.sistemavotacion_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sistemavotacion.sistemavotacion_backend.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, String> {
    // Métodos personalizados (si son necesarios)
}
