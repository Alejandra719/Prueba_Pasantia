package com.example.sistemavotacion.sistemavotacion_backend.Controller;

import com.example.sistemavotacion.sistemavotacion_backend.model.Votante;
import com.example.sistemavotacion.sistemavotacion_backend.Service.VotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votantes")
public class VotanteController {

    @Autowired
    private VotanteService votanteService;

    // Obtener todos los votantes
    @GetMapping
    public List<Votante> obtenerVotantes() {
        return votanteService.listarVotantes();
    }

    // Obtener un votante por cédula
    @GetMapping("/{cedula}")
    public ResponseEntity<Votante> obtenerVotante(@PathVariable String cedula) {
        return votanteService.obtenerVotante(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo votante
    @PostMapping
    public Votante crearVotante(@RequestBody Votante votante) {
        return votanteService.crearVotante(votante);
    }

    // Actualizar un votante existente
    @PutMapping("/{cedula}")
    public ResponseEntity<Votante> actualizarVotante(@PathVariable String cedula,
                                                     @RequestBody Votante votanteActualizado) {
        Votante votante = votanteService.actualizarVotante(cedula, votanteActualizado);
        if (votante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(votante);
    }

    // Eliminar un votante
    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminarVotante(@PathVariable String cedula) {
        votanteService.eliminarVotante(cedula);
        return ResponseEntity.noContent().build();
    }
}
