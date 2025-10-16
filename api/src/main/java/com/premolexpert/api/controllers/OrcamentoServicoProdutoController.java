package com.premolexpert.api.controllers;

import com.premolexpert.api.models.OrcamentoServicoProdutoModel;
import com.premolexpert.api.services.OrcamentoServicoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento-produto")

public class OrcamentoServicoProdutoController {

    @Autowired
    private OrcamentoServicoProdutoService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/lista-por-orcamento/{orcId}")
    public List<OrcamentoServicoProdutoModel> listarPorOrcamento(@PathVariable Integer orcId) {
        return service.getAllOrcamentoServicoProdutos(orcId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoServicoProdutoModel> getById(@PathVariable Integer id) {
        return service.getOrcamentoServicoProdutoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<OrcamentoServicoProdutoModel> salvar(@RequestBody OrcamentoServicoProdutoModel orcamentoProduto) {
        OrcamentoServicoProdutoModel orcamentoProdutoSalvo = service.saveOrcamentoServicoProduto(orcamentoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoProdutoSalvo);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoServicoProdutoModel> atualizar(@PathVariable Integer id, @RequestBody OrcamentoServicoProdutoModel orcamentoProduto) {
        OrcamentoServicoProdutoModel orcamentoProdutoSalvo = service.updateOrcamentoServicoProduto(id, orcamentoProduto);
        return ResponseEntity.status(HttpStatus.OK).body(orcamentoProdutoSalvo);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteOrcamentoServicoProduto(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/total-por-produto-engenharia/{orcProdId}")
    public Integer totalPorProdutoEngenharia(@PathVariable Integer orcProdId) {
        return service.totalPorProdutoEngenharia(orcProdId);
    }
}
