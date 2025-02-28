package com.example.sistemavotacion.sistemavotacion_backend.repository;

import com.example.sistemavotacion.sistemavotacion_backend.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
    // Puedes agregar métodos para consultas personalizadas si lo requieres.
}
