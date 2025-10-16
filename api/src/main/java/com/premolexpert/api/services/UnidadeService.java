package com.premolexpert.api.services;

import com.premolexpert.api.models.UnidadeModel;
import com.premolexpert.api.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository repository;

    public List<UnidadeModel> getAllUnidades() {
        return repository.findAll();
    }

    public Optional<UnidadeModel> getUnidadeById(Integer id) {
        return repository.findById(id);
    }

    public UnidadeModel saveUnidade(UnidadeModel unidade) {
        return repository.save(unidade);
    }

    public UnidadeModel updateUnidade(Integer id, UnidadeModel updatedUnidade) {
        return repository.findById(id).map(existingUnidade -> {
            updatedUnidade.setUniId(id); // Mantém o ID original
            return repository.save(updatedUnidade);
        }).orElseThrow(() -> new RuntimeException("Unidade não encontrada com ID: " + id));
    }

    public void deleteUnidade(Integer id) {
        repository.deleteById(id);
    }
}
