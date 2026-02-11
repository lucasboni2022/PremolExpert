package com.premolexpert.api.repository;

import com.premolexpert.api.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Page<Pessoa> findByPesNomContainingIgnoreCase(String pesNom, Pageable pageable);
}
