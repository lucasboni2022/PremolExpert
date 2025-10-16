package com.premolexpert.api.services;

import com.premolexpert.api.models.ProdutoModel;
import com.premolexpert.api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> getAllProdutos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> getProdutoById(Integer id) {
        return repository.findById(id);
    }

    public ProdutoModel saveProduto(ProdutoModel produto) {
        return repository.save(produto);
    }

    public ProdutoModel updateProduto(Integer id, ProdutoModel updatedProduto) {
        return repository.findById(id).map(existingProduto -> {
            updatedProduto.setProdId(id); // Mantém o ID original
            return repository.save(updatedProduto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public void deleteProduto(Integer id) {
        repository.deleteById(id);
    }
}
