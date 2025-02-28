package com.example.sistemavotacion.sistemavotacion_backend.Controller;

import com.example.sistemavotacion.sistemavotacion_backend.model.Partido;
import com.example.sistemavotacion.sistemavotacion_backend.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> listarPartidos() {
        return partidoService.listarPartidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPartido(@PathVariable Integer id) {
        return partidoService.obtenerPartido(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido crearPartido(@RequestBody Partido partido) {
        return partidoService.crearPartido(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizarPartido(@PathVariable Integer id,
                                                     @RequestBody Partido partidoActualizado) {
        Partido partido = partidoService.actualizarPartido(id, partidoActualizado);
        if (partido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(partido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPartido(@PathVariable Integer id) {
        partidoService.eliminarPartido(id);
        return ResponseEntity.noContent().build();
    }
}
