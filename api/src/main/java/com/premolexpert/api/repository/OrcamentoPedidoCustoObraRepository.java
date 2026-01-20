package com.premolexpert.api.repository;

import com.premolexpert.api.entity.OrcamentoPedidoCustoObra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoPedidoCustoObraRepository extends JpaRepository<OrcamentoPedidoCustoObra, Integer> {
}
