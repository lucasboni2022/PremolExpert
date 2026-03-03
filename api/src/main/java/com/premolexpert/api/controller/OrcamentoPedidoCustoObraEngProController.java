package com.premolexpert.api.controller;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraEngProDTO;
import com.premolexpert.api.security.RequiresPermission;
import com.premolexpert.api.service.OrcamentoPedidoCustoObraEngProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcamentopedidocustoobraengpro")
public class OrcamentoPedidoCustoObraEngProController {

    @Autowired
    private OrcamentoPedidoCustoObraEngProService orcamentoPedidoCustoObraEngProService;

    @GetMapping
    @RequiresPermission(telaNom = "Orçamento", acaoNom = "Consultar")
    public ResponseEntity<Page<OrcamentoPedidoCustoObraEngProDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraEngProService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamento", acaoNom = "Consultar")
    public ResponseEntity<OrcamentoPedidoCustoObraEngProDTO> getById(@PathVariable Integer id) {
        return orcamentoPedidoCustoObraEngProService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @RequiresPermission(telaNom = "Orçamento", acaoNom = "Inserir")
    public ResponseEntity<OrcamentoPedidoCustoObraEngProDTO> create(@RequestBody OrcamentoPedidoCustoObraEngProDTO dto) {
        return ResponseEntity.ok(orcamentoPedidoCustoObraEngProService.create(dto));
    }

    @PutMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamento", acaoNom = "Alterar")
    public ResponseEntity<OrcamentoPedidoCustoObraEngProDTO> update(@PathVariable Integer id, @RequestBody OrcamentoPedidoCustoObraEngProDTO dto) {
        return orcamentoPedidoCustoObraEngProService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @RequiresPermission(telaNom = "Orçamento", acaoNom = "Excluir")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (orcamentoPedidoCustoObraEngProService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
