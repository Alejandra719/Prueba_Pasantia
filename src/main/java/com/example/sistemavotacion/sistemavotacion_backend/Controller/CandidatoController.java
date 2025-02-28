package com.example.sistemavotacion.sistemavotacion_backend.Controller;

import com.example.sistemavotacion.sistemavotacion_backend.model.Candidato;
import com.example.sistemavotacion.sistemavotacion_backend.Service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public List<Candidato> listarCandidatos() {
        return candidatoService.listarCandidatos();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Candidato> obtenerCandidato(@PathVariable String cedula) {
        return candidatoService.obtenerCandidato(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Candidato crearCandidato(@RequestBody Candidato candidato) {
        return candidatoService.crearCandidato(candidato);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Candidato> actualizarCandidato(@PathVariable String cedula,
                                                         @RequestBody Candidato candidatoActualizado) {
        Candidato candidato = candidatoService.actualizarCandidato(cedula, candidatoActualizado);
        if (candidato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidato);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminarCandidato(@PathVariable String cedula) {
        candidatoService.eliminarCandidato(cedula);
        return ResponseEntity.noContent().build();
    }
}
