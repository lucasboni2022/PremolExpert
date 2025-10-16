package com.premolexpert.api.controllers;

import com.premolexpert.api.models.ClienteModel;
import com.premolexpert.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    @Autowired
    private ClienteService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ClienteModel> getAll() {
        return service.getAllClientes();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getById(@PathVariable Integer id) {
        return service.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ClienteModel create(@RequestBody ClienteModel Cliente) {
        return service.saveCliente(Cliente);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> update(@PathVariable Integer id, @RequestBody ClienteModel updatedCliente) {
        return service.getClienteById(id).map(existingCliente -> {
            updatedCliente.setCliId(id); // Garante que o ID não seja alterado
            ClienteModel savedCliente = service.saveCliente(updatedCliente);
            return ResponseEntity.ok(savedCliente);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
