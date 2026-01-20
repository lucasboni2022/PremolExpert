package com.premolexpert.api.repository;

import com.premolexpert.api.entity.OrcamentoPedidoCustoObraEng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoPedidoCustoObraEngRepository extends JpaRepository<OrcamentoPedidoCustoObraEng, Integer> {
}
