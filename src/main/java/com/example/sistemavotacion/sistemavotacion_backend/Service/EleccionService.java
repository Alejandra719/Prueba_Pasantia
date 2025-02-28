package com.example.sistemavotacion.sistemavotacion_backend.Service;

import com.example.sistemavotacion.sistemavotacion_backend.model.Eleccion;
import com.example.sistemavotacion.sistemavotacion_backend.repository.EleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleccionService {

    @Autowired
    private EleccionRepository eleccionRepository;

    public List<Eleccion> listarElecciones() {
        return eleccionRepository.findAll();
    }

    public Optional<Eleccion> obtenerEleccion(Integer id) {
        return eleccionRepository.findById(id);
    }

    public Eleccion crearEleccion(Eleccion eleccion) {
        return eleccionRepository.save(eleccion);
    }

    public Eleccion actualizarEleccion(Integer id, Eleccion eleccionActualizado) {
        return eleccionRepository.findById(id).map(eleccion -> {
            eleccion.setFechaInicio(eleccionActualizado.getFechaInicio());
            eleccion.setFechaFinal(eleccionActualizado.getFechaFinal());
            return eleccionRepository.save(eleccion);
        }).orElse(null);
    }

    public void eliminarEleccion(Integer id) {
        eleccionRepository.deleteById(id);
    }
}
