package com.premolexpert.api.repository;

import com.premolexpert.api.entity.OrcamentoPedidoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoPedidoHistoricoRepository extends JpaRepository<OrcamentoPedidoHistorico, Integer> {
}
