package com.premolexpert.api.services;

import com.premolexpert.api.models.OrcamentoServicoProdutoModel;
import com.premolexpert.api.repositories.OrcamentoServicoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoServicoProdutoService {

    @Autowired
    private OrcamentoServicoProdutoRepository repository;

    public List<OrcamentoServicoProdutoModel> getAllOrcamentoServicoProdutos(Integer orcId) {
        return repository.buscaPorOrcId(orcId);
    }

    public Optional<OrcamentoServicoProdutoModel> getOrcamentoServicoProdutoById(Integer id) {
        return repository.findById(id);
    }

    public OrcamentoServicoProdutoModel saveOrcamentoServicoProduto(OrcamentoServicoProdutoModel orcamentoServicoProduto) {
        return repository.save(orcamentoServicoProduto);
    }

    public OrcamentoServicoProdutoModel updateOrcamentoServicoProduto(Integer id, OrcamentoServicoProdutoModel orcamentoServicoProduto) {
        if (repository.existsById(id)) {
            orcamentoServicoProduto.setOrcServProdId(id);
            return repository.save(orcamentoServicoProduto);
        } else {
            throw new RuntimeException("Produto do Orçamento não encontrado com ID: " + id);
        }
    }

    public void deleteOrcamentoServicoProduto(Integer id) {
        repository.deleteById(id);
    }

    public Integer totalPorProdutoEngenharia(Integer orcProdId){
        return repository.totalPorProdutoEngenharia(orcProdId);
    }
}
