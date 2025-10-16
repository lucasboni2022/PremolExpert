package com.premolexpert.api.controllers;

import com.premolexpert.api.models.ProdutoModel;
import com.premolexpert.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProdutoModel> getAll() {
        return service.getAllProdutos();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> getById(@PathVariable Integer id) {
        return service.getProdutoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ProdutoModel create(@RequestBody ProdutoModel produto) {
        return service.saveProduto(produto);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> update(@PathVariable Integer id, @RequestBody ProdutoModel updatedProduto) {
        return service.getProdutoById(id).map(existingProduto -> {
            updatedProduto.setProdId(id); // Garante que o ID não seja alterado
            ProdutoModel savedProduto = service.saveProduto(updatedProduto);
            return ResponseEntity.ok(savedProduto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}