package com.premolexpert.api.controller;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraEngDTO;
import com.premolexpert.api.security.RequiresPermission;
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
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Consultar")
    public ResponseEntity<Page<OrcamentoPedidoCustoObraEngDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraEngService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Consultar")
    public ResponseEntity<OrcamentoPedidoCustoObraEngDTO> getById(@PathVariable Integer id) {
        OrcamentoPedidoCustoObraEngDTO dto = orcamentoPedidoCustoObraEngService.getById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Criar")
    public ResponseEntity<OrcamentoPedidoCustoObraEngDTO> create(@RequestBody OrcamentoPedidoCustoObraEngDTO dto) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraEngService.create(dto));
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Editar")
    public ResponseEntity<OrcamentoPedidoCustoObraEngDTO> update(@PathVariable Integer id, @RequestBody OrcamentoPedidoCustoObraEngDTO dto) {
        dto.setOrcPedCustoObrEngId(id);
        OrcamentoPedidoCustoObraEngDTO updated = orcamentoPedidoCustoObraEngService.update(dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Deletar")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orcamentoPedidoCustoObraEngService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
