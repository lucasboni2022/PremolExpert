package com.premolexpert.api.controller;

import com.premolexpert.api.dto.OrcamentoPedidoDTO;
import com.premolexpert.api.dto.OrcamentoPedidoEtapaDTO;
import com.premolexpert.api.service.OrcamentoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcamentopedido")
@CrossOrigin(origins = "*")
public class OrcamentoPedidoController {

    @Autowired
    private OrcamentoPedidoService orcamentoPedidoService;

    @GetMapping
    public ResponseEntity<Page<OrcamentoPedidoDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orcamentoPedidoService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoPedidoDTO> getById(@PathVariable Integer id) {
        OrcamentoPedidoDTO dto = orcamentoPedidoService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrcamentoPedidoDTO> create(@RequestBody OrcamentoPedidoDTO dto) {
        return ResponseEntity.ok(orcamentoPedidoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoPedidoDTO> update(@PathVariable Integer id, @RequestBody OrcamentoPedidoDTO dto) {
        dto.setOrcPedId(id);
        OrcamentoPedidoDTO updated = orcamentoPedidoService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/etapa")
    public ResponseEntity<Void> updateEtapa(@PathVariable Integer id, @RequestBody OrcamentoPedidoEtapaDTO dto) {
        dto.setOrcPedId(id);
        orcamentoPedidoService.updateEtapa(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orcamentoPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
