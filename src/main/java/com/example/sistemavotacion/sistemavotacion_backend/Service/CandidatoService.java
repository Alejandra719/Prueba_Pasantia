package com.example.sistemavotacion.sistemavotacion_backend.Service;

import com.example.sistemavotacion.sistemavotacion_backend.model.Candidato;
import com.example.sistemavotacion.sistemavotacion_backend.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> listarCandidatos() {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> obtenerCandidato(String cedula) {
        return candidatoRepository.findById(cedula);
    }

    public Candidato crearCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public Candidato actualizarCandidato(String cedula, Candidato candidatoActualizado) {
        return candidatoRepository.findById(cedula).map(candidato -> {
            // Actualiza los datos relevantes. Por ejemplo, actualizamos el partido.
            candidato.setPartido(candidatoActualizado.getPartido());
            // Si hubiera otros atributos, se actualizarían aquí.
            return candidatoRepository.save(candidato);
        }).orElse(null);
    }

    public void eliminarCandidato(String cedula) {
        candidatoRepository.deleteById(cedula);
    }
}
