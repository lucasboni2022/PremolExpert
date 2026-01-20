package com.premolexpert.api.controller;

import com.premolexpert.api.dto.AcaoDTO;
import com.premolexpert.api.service.AcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acao")
@CrossOrigin(origins = "*")
public class AcaoController {

    @Autowired
    private AcaoService acaoService;

    @GetMapping
    public ResponseEntity<Page<AcaoDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(acaoService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcaoDTO> getById(@PathVariable Integer id) {
        AcaoDTO dto = acaoService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AcaoDTO> create(@RequestBody AcaoDTO dto) {
        return ResponseEntity.ok(acaoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcaoDTO> update(@PathVariable Integer id, @RequestBody AcaoDTO dto) {
        dto.setAcaId(id);
        AcaoDTO updated = acaoService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        acaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
