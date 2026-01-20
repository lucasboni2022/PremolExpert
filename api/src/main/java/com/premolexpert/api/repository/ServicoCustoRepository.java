package com.premolexpert.api.repository;

import com.premolexpert.api.entity.ServicoCusto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoCustoRepository extends JpaRepository<ServicoCusto, Integer> {
}
