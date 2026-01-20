package com.premolexpert.api.controller;

import com.premolexpert.api.dto.PerfilDTO;
import com.premolexpert.api.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<Page<PerfilDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(perfilService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> getById(@PathVariable Integer id) {
        PerfilDTO dto = perfilService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(perfilService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@PathVariable Integer id, @RequestBody PerfilDTO dto) {
        dto.setPerId(id);
        PerfilDTO updated = perfilService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
