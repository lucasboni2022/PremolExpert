package com.premolexpert.api.controller;

import com.premolexpert.api.dto.UnidadeDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidade")
@CrossOrigin(origins = "*")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    @RequiresPermission(telaNom = "Unidades", acaoNom = "Consultar")
    public ResponseEntity<Page<UnidadeDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(unidadeService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Unidades", acaoNom = "Consultar")
    public ResponseEntity<UnidadeDTO> getById(@PathVariable Integer id) {
        UnidadeDTO dto = unidadeService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @RequiresPermission(telaNom = "Unidades", acaoNom = "Criar")
    public ResponseEntity<UnidadeDTO> create(@RequestBody UnidadeDTO dto) {
        return ResponseEntity.ok(unidadeService.create(dto));
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Unidades", acaoNom = "Editar")
    public ResponseEntity<UnidadeDTO> update(@PathVariable Integer id, @RequestBody UnidadeDTO dto) {
        dto.setUniId(id);
        UnidadeDTO updated = unidadeService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Unidades", acaoNom = "Deletar")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        unidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
