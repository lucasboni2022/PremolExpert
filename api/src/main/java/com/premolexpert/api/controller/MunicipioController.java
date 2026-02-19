package com.premolexpert.api.controller;

import com.premolexpert.api.dto.MunicipioDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/municipio")
@CrossOrigin(origins = "*")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping
    @RequiresPermission(telaNom = "Municípios", acaoNom = "Consultar")
    public ResponseEntity<Page<MunicipioDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<MunicipioDTO> result = municipioService.getAll(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Municípios", acaoNom = "Consultar")
    public ResponseEntity<MunicipioDTO> buscar(@PathVariable Integer id) {
        MunicipioDTO dto = municipioService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @RequiresPermission(telaNom = "Municípios", acaoNom = "Criar")
    public ResponseEntity<MunicipioDTO> criar(@RequestBody MunicipioDTO dto) {
        MunicipioDTO saved = municipioService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Municípios", acaoNom = "Editar")
    public ResponseEntity<MunicipioDTO> atualizar(@PathVariable Integer id, @RequestBody MunicipioDTO dto) {
        dto.setMunId(id);
        MunicipioDTO saved = municipioService.update(dto);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Municípios", acaoNom = "Deletar")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        municipioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
