package com.premolexpert.api.controller;

import com.premolexpert.api.dto.TelaDTO;
import com.premolexpert.api.service.TelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tela")
@CrossOrigin(origins = "*")
public class TelaController {

    @Autowired
    private TelaService telaService;

    @GetMapping
    public ResponseEntity<Page<TelaDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(telaService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelaDTO> getById(@PathVariable Integer id) {
        TelaDTO dto = telaService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TelaDTO> create(@RequestBody TelaDTO dto) {
        return ResponseEntity.ok(telaService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelaDTO> update(@PathVariable Integer id, @RequestBody TelaDTO dto) {
        dto.setTelId(id);
        TelaDTO updated = telaService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        telaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
