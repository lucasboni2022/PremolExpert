/*
package com.premolexpert.api.services;

import com.premolexpert.api.models.OrcamentoProdutoFabModel;
import com.premolexpert.api.models.ProdutoModel;
import com.premolexpert.api.repositories.OrcamentoProdutoFabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoProdutoFabService {

    @Autowired
    private OrcamentoProdutoFabRepository repository;

    public List<OrcamentoProdutoFabModel> getAllOrcamentoProdutoFabs(ProdutoModel orcId) {
            // Chamando o método nativo do Spring Data JPA
            //return repository.findBy(orcId);
            return 1;

    }

    public Optional<OrcamentoProdutoFabModel> getOrcamentoProdutoFabById(integer id) {
        return repository.findById(id);
    }

    public OrcamentoProdutoFabModel saveOrcamentoProdutoFab(OrcamentoProdutoFabModel produto) {
        return repository.save(produto);
    }

    public void deleteOrcamentoProdutoFab(Integer id) {
        repository.deleteById(id);
    }
}
*/