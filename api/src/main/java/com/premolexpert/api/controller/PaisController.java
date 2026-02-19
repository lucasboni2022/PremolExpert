package com.premolexpert.api.controller;

import com.premolexpert.api.dto.PaisDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "*")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    @RequiresPermission(telaNom = "Países", acaoNom = "Consultar")
    public ResponseEntity<Page<PaisDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PaisDTO> result = paisService.getAll(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Países", acaoNom = "Consultar")
    public ResponseEntity<PaisDTO> buscar(@PathVariable Integer id) {
        PaisDTO dto = paisService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @RequiresPermission(telaNom = "Países", acaoNom = "Criar")
    public ResponseEntity<PaisDTO> criar(@RequestBody PaisDTO dto) {
        System.out.println("PaisDTO recebido:");
        System.out.println("ID: " + dto.getPaisId());
        System.out.println("Nome: " + dto.getPaisNom());
        
        PaisDTO saved = paisService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Países", acaoNom = "Editar")
    public ResponseEntity<PaisDTO> atualizar(@PathVariable Integer id, @RequestBody PaisDTO dto) {
        dto.setPaisId(id);
        PaisDTO saved = paisService.update(dto);
        if (saved == null) {
             return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Países", acaoNom = "Deletar")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        paisService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
