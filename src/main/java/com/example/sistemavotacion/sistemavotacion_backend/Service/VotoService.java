package com.example.sistemavotacion.sistemavotacion_backend.Service;

import com.example.sistemavotacion.sistemavotacion_backend.model.Voto;
import com.example.sistemavotacion.sistemavotacion_backend.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public List<Voto> listarVotos() {
        return votoRepository.findAll();
    }

    public Optional<Voto> obtenerVoto(Integer id) {
        return votoRepository.findById(id);
    }

    public Voto crearVoto(Voto voto) {
        // Aquí podrías agregar validaciones adicionales, por ejemplo:
        // - Verificar que la elección esté activa.
        // - Comprobar que el votante no haya votado ya en la elección.
        return votoRepository.save(voto);
    }

    public Voto actualizarVoto(Integer id, Voto votoActualizado) {
        return votoRepository.findById(id).map(voto -> {
            voto.setEleccion(votoActualizado.getEleccion());
            voto.setVotante(votoActualizado.getVotante());
            voto.setCandidato(votoActualizado.getCandidato());
            return votoRepository.save(voto);
        }).orElse(null);
    }

    public void eliminarVoto(Integer id) {
        votoRepository.deleteById(id);
    }
}
