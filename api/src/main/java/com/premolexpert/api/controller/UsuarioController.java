package com.premolexpert.api.controller;

import com.premolexpert.api.dto.UsuarioDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @RequiresPermission(telaNom = "Usuários", acaoNom = "Consultar")
    public ResponseEntity<Page<UsuarioDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(usuarioService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Usuários", acaoNom = "Consultar")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Integer id) {
        UsuarioDTO dto = usuarioService.getById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @RequiresPermission(telaNom = "Usuários", acaoNom = "Criar")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) {
        UsuarioDTO saved = usuarioService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getPesId())
                .toUri();
        return ResponseEntity.created(uri).body(saved);
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Usuários", acaoNom = "Editar")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO dto) {
        dto.setPesId(id);
        UsuarioDTO updated = usuarioService.update(dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Usuários", acaoNom = "Deletar")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
