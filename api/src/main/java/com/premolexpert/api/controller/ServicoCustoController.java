package com.premolexpert.api.controller;

import com.premolexpert.api.dto.ServicoCustoDTO;
import com.premolexpert.api.service.ServicoCustoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicocusto")
@CrossOrigin(origins = "*")
public class ServicoCustoController {

    @Autowired
    private ServicoCustoService servicoCustoService;

    @GetMapping
    public ResponseEntity<Page<ServicoCustoDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ServicoCustoDTO> result = servicoCustoService.getAll(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoCustoDTO> buscar(@PathVariable Integer id) {
        ServicoCustoDTO dto = servicoCustoService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ServicoCustoDTO> criar(@RequestBody ServicoCustoDTO dto) {
        ServicoCustoDTO saved = servicoCustoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoCustoDTO> atualizar(@PathVariable Integer id, @RequestBody ServicoCustoDTO dto) {
        dto.setSerCustoId(id);
        ServicoCustoDTO saved = servicoCustoService.update(dto);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servicoCustoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
