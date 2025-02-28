package com.example.sistemavotacion.sistemavotacion_backend.Controller;

import com.example.sistemavotacion.sistemavotacion_backend.model.Voto;
import com.example.sistemavotacion.sistemavotacion_backend.Service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping
    public List<Voto> listarVotos() {
        return votoService.listarVotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voto> obtenerVoto(@PathVariable Integer id) {
        return votoService.obtenerVoto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Voto crearVoto(@RequestBody Voto voto) {
        return votoService.crearVoto(voto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voto> actualizarVoto(@PathVariable Integer id,
                                               @RequestBody Voto votoActualizado) {
        Voto voto = votoService.actualizarVoto(id, votoActualizado);
        if (voto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVoto(@PathVariable Integer id) {
        votoService.eliminarVoto(id);
        return ResponseEntity.noContent().build();
    }
}
