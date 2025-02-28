package com.example.sistemavotacion.sistemavotacion_backend.repository;

import com.example.sistemavotacion.sistemavotacion_backend.model.Votante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VotanteRepository extends JpaRepository<Votante, String>{
    // Aquí puedes agregar consultas personalizadas si es necesario.
}





