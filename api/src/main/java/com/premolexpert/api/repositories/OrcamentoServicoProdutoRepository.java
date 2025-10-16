package com.premolexpert.api.repositories;

import com.premolexpert.api.models.OrcamentoServicoProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface OrcamentoServicoProdutoRepository extends JpaRepository<OrcamentoServicoProdutoModel, Integer> {
    //JpaRepository tem outros metodos, o que não tem será acrescentado abaixo, como esse metodo:

    // Busca todos os produtos de um orçamento específico usando SQL nativo
    @Query(value = "SELECT * FROM TBorcamentoproduto WHERE orcId = :orcId", nativeQuery = true)
    List<OrcamentoServicoProdutoModel> buscaPorOrcId(@Param("orcId") Integer orcId);

    // Busca o total dos produtos enviado para fabricação de um orçamento
    @Query(value = "SELECT count(*) FROM public.tborcamentoproduto where orcprodgruporcprodid = :orcProdId", nativeQuery = true)
    Integer totalPorProdutoEngenharia(@Param("orcProdId") Integer orcProdId);

}

