package com.premolexpert.api.controller;

import com.premolexpert.api.dto.ServicoDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    @RequiresPermission(telaNom = "Serviço", acaoNom = "Consultar")
    public ResponseEntity<Page<ServicoDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ServicoDTO> result = servicoService.getAll(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Serviço", acaoNom = "Consultar")
    public ResponseEntity<ServicoDTO> getById(@PathVariable Integer id) {
        ServicoDTO dto = servicoService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @RequiresPermission(telaNom = "Serviço", acaoNom = "Inserir")
    public ResponseEntity<ServicoDTO> create(@RequestBody ServicoDTO dto) {
        ServicoDTO saved = servicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Serviço", acaoNom = "Alterar")
    public ResponseEntity<ServicoDTO> update(@PathVariable Integer id, @RequestBody ServicoDTO dto) {
        dto.setSerId(id);
        ServicoDTO saved = servicoService.update(dto);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Serviço", acaoNom = "Excluir")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
