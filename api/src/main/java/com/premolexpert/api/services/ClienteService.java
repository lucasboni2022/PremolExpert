package com.premolexpert.api.services;

import com.premolexpert.api.models.ClienteModel;
import com.premolexpert.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteModel> getAllClientes() {
        return repository.findAll();
    }

    public Optional<ClienteModel> getClienteById(Integer id) {
        return repository.findById(id);
    }

    public ClienteModel saveCliente(ClienteModel cliente) {
        return repository.save(cliente);
    }

    public ClienteModel updateCliente(Integer id, ClienteModel updatedCliente) {
        return repository.findById(id).map(existingCliente -> {
            updatedCliente.setCliId(id); // Mantém o ID original
            return repository.save(updatedCliente);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

    public void deleteCliente(Integer id) {
        repository.deleteById(id);
    }
}
