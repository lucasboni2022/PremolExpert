package com.premolexpert.api.repository;

import com.premolexpert.api.entity.PermissaoAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoAcessoRepository extends JpaRepository<PermissaoAcesso, Integer> {
}
