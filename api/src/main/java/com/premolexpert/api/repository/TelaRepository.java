package com.premolexpert.api.repository;

import com.premolexpert.api.entity.Tela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelaRepository extends JpaRepository<Tela, Integer> {
}
