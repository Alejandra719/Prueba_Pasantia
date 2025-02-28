package com.example.sistemavotacion.sistemavotacion_backend.Controller;

import com.example.sistemavotacion.sistemavotacion_backend.model.Eleccion;
import com.example.sistemavotacion.sistemavotacion_backend.Service.EleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elecciones")
public class EleccionController {

    @Autowired
    private EleccionService eleccionService;

    @GetMapping
    public List<Eleccion> listarElecciones() {
        return eleccionService.listarElecciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleccion> obtenerEleccion(@PathVariable Integer id) {
        return eleccionService.obtenerEleccion(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Eleccion crearEleccion(@RequestBody Eleccion eleccion) {
        return eleccionService.crearEleccion(eleccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eleccion> actualizarEleccion(@PathVariable Integer id,
                                                       @RequestBody Eleccion eleccionActualizado) {
        Eleccion eleccion = eleccionService.actualizarEleccion(id, eleccionActualizado);
        if (eleccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eleccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEleccion(@PathVariable Integer id) {
        eleccionService.eliminarEleccion(id);
        return ResponseEntity.noContent().build();
    }
}
