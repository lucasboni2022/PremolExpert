package com.premolexpert.api.controller;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraEngDTO;
import com.premolexpert.api.service.OrcamentoPedidoCustoObraEngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcamentopedidocustoobraeng")
@CrossOrigin(origins = "*")
public class OrcamentoPedidoCustoObraEngController {

    @Autowired
    private OrcamentoPedidoCustoObraEngService orcamentoPedidoCustoObraEngService;

    @GetMapping
    public ResponseEntity<Page<OrcamentoPedidoCustoObraEngDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraEngService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoPedidoCustoObraEngDTO> getById(@PathVariable Integer id) {
        return orcamentoPedidoCustoObraEngService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrcamentoPedidoCustoObraEngDTO> create(@RequestBody OrcamentoPedidoCustoObraEngDTO dto) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraEngService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoPedidoCustoObraEngDTO> update(@PathVariable Integer id, @RequestBody OrcamentoPedidoCustoObraEngDTO dto) {
        return orcamentoPedidoCustoObraEngService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (orcamentoPedidoCustoObraEngService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
