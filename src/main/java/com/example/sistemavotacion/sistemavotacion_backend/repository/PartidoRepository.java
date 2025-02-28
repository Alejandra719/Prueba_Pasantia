package com.example.sistemavotacion.sistemavotacion_backend.repository;

import com.example.sistemavotacion.sistemavotacion_backend.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer>{
    // Métodos personalizados (si son necesarios)
}
