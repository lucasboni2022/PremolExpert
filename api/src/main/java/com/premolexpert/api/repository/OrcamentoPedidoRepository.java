package com.premolexpert.api.repository;

import com.premolexpert.api.entity.OrcamentoPedido;
import com.premolexpert.api.enumeration.OrcPedEtapEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface OrcamentoPedidoRepository extends JpaRepository<OrcamentoPedido, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE OrcamentoPedido o SET o.orcPedEtapa = :etapa, o.orcPedAltPor = :altPor, o.orcPedAltEm = :altEm WHERE o.orcPedId = :id")
    int updateEtapa(@Param("id") Integer id, @Param("etapa") OrcPedEtapEnum etapa, @Param("altPor") Integer altPor, @Param("altEm") LocalDateTime altEm);
}
