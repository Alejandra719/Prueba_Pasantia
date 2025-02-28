package com.example.sistemavotacion.sistemavotacion_backend.Service;

import com.example.sistemavotacion.sistemavotacion_backend.model.Votante;
import com.example.sistemavotacion.sistemavotacion_backend.repository.VotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VotanteService {

    @Autowired
    private VotanteRepository votanteRepository;

    public List<Votante> listarVotantes() {
        return votanteRepository.findAll();
    }

    public Optional<Votante> obtenerVotante(String cedula) {
        return votanteRepository.findById(cedula);
    }

    public Votante crearVotante(Votante votante) {
        // agregar validaciones: edad, nacionalidad, etc.
        return votanteRepository.save(votante);
    }

    public Votante actualizarVotante(String cedula, Votante votanteActualizado) {
        return votanteRepository.findById(cedula).map(votante -> {
            votante.setNombre(votanteActualizado.getNombre());
            votante.setApellido(votanteActualizado.getApellido());
            votante.setFechaNacimiento(votanteActualizado.getFechaNacimiento());
            // Otros campos...
            return votanteRepository.save(votante);
        }).orElseGet(() -> {
            // Opcional: manejar el caso de no encontrar el votante
            return null;
        });
    }

    public void eliminarVotante(String cedula) {
        votanteRepository.deleteById(cedula);
    }
}
