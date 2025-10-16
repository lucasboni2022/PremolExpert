/*
package com.premolexpert.api.controllers;

import com.premolexpert.api.models.OrcamentoProdutoFabModel;
import com.premolexpert.api.models.ProdutoModel;
import com.premolexpert.api.services.OrcamentoProdutoFabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento-produto-fab")
public class OrcamentoProdutoFabController {

    @Autowired
    private OrcamentoProdutoFabService service;

    // Endpoint para listar OrcamentoProdutoFab por orcamento ID
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/lista-por-orcamento/{orcId}")
    public List<OrcamentoProdutoFabModel> listarPorOrcamento(@PathVariable ProdutoModel orcId) {
        return service.getAllOrcamentoProdutoFabs(orcId);
    }

    // Endpoint para buscar OrcamentoProdutoFab por ID
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoProdutoFabModel> getById(@PathVariable Integer id) {
        return service.getOrcamentoProdutoFabById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para salvar OrcamentoProdutoFab
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<OrcamentoProdutoFabModel> salvar(@RequestBody OrcamentoProdutoFabModel orcamentoProdutoFab) {
        OrcamentoProdutoFabModel orcamentoProdutoFabSalvo = service.saveOrcamentoProdutoFab(orcamentoProdutoFab);
        return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoProdutoFabSalvo);
    }


    // Endpoint para deletar OrcamentoProdutoFab por ID
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteOrcamentoProdutoFab(id);
        return ResponseEntity.noContent().build();
    }
}
*/