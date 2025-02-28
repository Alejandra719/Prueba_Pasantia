package com.example.sistemavotacion.sistemavotacion_backend.Service;

import com.example.sistemavotacion.sistemavotacion_backend.model.Partido;
import com.example.sistemavotacion.sistemavotacion_backend.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> listarPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> obtenerPartido(Integer id) {
        return partidoRepository.findById(id);
    }

    public Partido crearPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido actualizarPartido(Integer id, Partido partidoActualizado) {
        return partidoRepository.findById(id).map(partido -> {
            partido.setNombre(partidoActualizado.getNombre());
            return partidoRepository.save(partido);
        }).orElse(null);
    }

    public void eliminarPartido(Integer id) {
        partidoRepository.deleteById(id);
    }
}
