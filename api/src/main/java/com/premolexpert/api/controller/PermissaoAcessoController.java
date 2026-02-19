package com.premolexpert.api.controller;

import com.premolexpert.api.dto.PermissaoAcessoDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.PermissaoAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/permissaoacesso")
@CrossOrigin(origins = "*")
public class PermissaoAcessoController {

    @Autowired
    private PermissaoAcessoService permissaoAcessoService;

    @GetMapping
    @RequiresPermission(telaNom = "Permissões", acaoNom = "Consultar")
    public ResponseEntity<Page<PermissaoAcessoDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(permissaoAcessoService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Permissões", acaoNom = "Consultar")
    public ResponseEntity<PermissaoAcessoDTO> getById(@PathVariable Integer id) {
        PermissaoAcessoDTO dto = permissaoAcessoService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/all")
    public ResponseEntity<List<PermissaoAcessoDTO>> createAll(@RequestBody List<PermissaoAcessoDTO> dtos) {
        return ResponseEntity.ok(permissaoAcessoService.createAll(dtos));
    }

    @PostMapping
    @RequiresPermission(telaNom = "Permissões", acaoNom = "Criar")
    public ResponseEntity<PermissaoAcessoDTO> create(@RequestBody PermissaoAcessoDTO dto) {
        return ResponseEntity.ok(permissaoAcessoService.create(dto));
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Permissões", acaoNom = "Editar")
    public ResponseEntity<PermissaoAcessoDTO> update(@PathVariable Integer id, @RequestBody PermissaoAcessoDTO dto) {
        dto.setPermAceId(id);
        PermissaoAcessoDTO updated = permissaoAcessoService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Permissões", acaoNom = "Deletar")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        permissaoAcessoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
