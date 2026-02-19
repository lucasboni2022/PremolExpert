package com.premolexpert.api.controller;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.OrcamentoPedidoCustoObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcamentopedidocustoobra")
@CrossOrigin(origins = "*")
public class OrcamentoPedidoCustoObraController {

    @Autowired
    private OrcamentoPedidoCustoObraService orcamentoPedidoCustoObraService;

    @GetMapping
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Consultar")
    public ResponseEntity<Page<OrcamentoPedidoCustoObraDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Consultar")
    public ResponseEntity<OrcamentoPedidoCustoObraDTO> getById(@PathVariable Integer id) {
        OrcamentoPedidoCustoObraDTO dto = orcamentoPedidoCustoObraService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Criar")
    public ResponseEntity<OrcamentoPedidoCustoObraDTO> create(@RequestBody OrcamentoPedidoCustoObraDTO dto) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraService.create(dto));
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Editar")
    public ResponseEntity<OrcamentoPedidoCustoObraDTO> update(@PathVariable Integer id, @RequestBody OrcamentoPedidoCustoObraDTO dto) {
        dto.setOrcPedCustoObrId(id);
        OrcamentoPedidoCustoObraDTO updated = orcamentoPedidoCustoObraService.update(dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Deletar")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orcamentoPedidoCustoObraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
