package com.premolexpert.api.controller;

import com.premolexpert.api.dto.EstadoDTO;
import com.premolexpert.api.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "*")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<Page<EstadoDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<EstadoDTO> result = estadoService.getAll(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscar(@PathVariable Integer id) {
        EstadoDTO dto = estadoService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> criar(@RequestBody EstadoDTO dto) {
        EstadoDTO saved = estadoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Integer id, @RequestBody EstadoDTO dto) {
        dto.setEstId(id);
        EstadoDTO saved = estadoService.update(dto);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        estadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
