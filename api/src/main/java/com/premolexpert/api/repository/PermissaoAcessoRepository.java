package com.premolexpert.api.repository;

import com.premolexpert.api.entity.PermissaoAcesso;
import com.premolexpert.api.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoAcessoRepository extends JpaRepository<PermissaoAcesso, Integer> {

    @Query("SELECT CASE WHEN COUNT(pa) > 0 THEN true ELSE false END " +
           "FROM PermissaoAcesso pa " +
           "WHERE pa.perfil = :perfil " +
           "AND pa.tela.telNom = :telaNom " +
           "AND pa.acao.acaNom = :acaoNom " +
           "AND pa.permAceSta = 1")
    boolean existsByPerfilAndTelaAndAcao(
        @Param("perfil") Perfil perfil,
        @Param("telaNom") String telaNom,
        @Param("acaoNom") String acaoNom
    );
}
