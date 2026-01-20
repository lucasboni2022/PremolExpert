package com.premolexpert.api.controller;

import com.premolexpert.api.dto.OrcamentoPedidoHistoricoDTO;
import com.premolexpert.api.service.OrcamentoPedidoHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcamentopedidohistorico")
@CrossOrigin(origins = "*")
public class OrcamentoPedidoHistoricoController {

    @Autowired
    private OrcamentoPedidoHistoricoService orcamentoPedidoHistoricoService;

    @GetMapping
    public ResponseEntity<Page<OrcamentoPedidoHistoricoDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orcamentoPedidoHistoricoService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoPedidoHistoricoDTO> getById(@PathVariable Integer id) {
        OrcamentoPedidoHistoricoDTO dto = orcamentoPedidoHistoricoService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrcamentoPedidoHistoricoDTO> create(@RequestBody OrcamentoPedidoHistoricoDTO dto) {
        return ResponseEntity.ok(orcamentoPedidoHistoricoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoPedidoHistoricoDTO> update(@PathVariable Integer id, @RequestBody OrcamentoPedidoHistoricoDTO dto) {
        dto.setOrcPedHistId(id);
        OrcamentoPedidoHistoricoDTO updated = orcamentoPedidoHistoricoService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orcamentoPedidoHistoricoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
