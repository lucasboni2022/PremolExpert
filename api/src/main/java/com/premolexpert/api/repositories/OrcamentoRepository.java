package com.premolexpert.api.repositories;

import com.premolexpert.api.models.OrcamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrcamentoRepository extends JpaRepository<OrcamentoModel, Integer> {
    //JpaRepository tem outros metodos, o que não tem será acrescentado abaixo, como esse metodo:

    @Query(value = "SELECT max(orcnumproemp) FROM TBorcamento WHERE empid = :empId", nativeQuery = true)
    Integer getUltimoOrcNumProEmp(@Param("empId") Integer empId);

}

