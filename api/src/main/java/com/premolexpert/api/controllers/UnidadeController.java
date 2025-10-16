package com.premolexpert.api.controllers;

import com.premolexpert.api.models.UnidadeModel;
import com.premolexpert.api.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<UnidadeModel> getAllUnidades() {
        return service.getAllUnidades();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeModel> getUnidadeById(@PathVariable Integer id) {
        Optional<UnidadeModel> unidade = service.getUnidadeById(id);
        return unidade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public UnidadeModel createUnidade(@RequestBody UnidadeModel unidade) {
        return service.saveUnidade(unidade);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<UnidadeModel> updateUnidade(@PathVariable Integer id, @RequestBody UnidadeModel updatedUnidade) {
        try {
            UnidadeModel unidade = service.updateUnidade(id, updatedUnidade);
            return ResponseEntity.ok(unidade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidade(@PathVariable Integer id) {
        service.deleteUnidade(id);
        return ResponseEntity.noContent().build();
    }
}
