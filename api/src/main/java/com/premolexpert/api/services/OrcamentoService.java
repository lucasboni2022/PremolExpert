package com.premolexpert.api.services;

import com.premolexpert.api.enums.OrcEtapEnum;
import com.premolexpert.api.models.OrcamentoModel;
import com.premolexpert.api.repositories.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

    public List<OrcamentoModel> getAllOrcamentos() {
        return repository.findAll(Sort.by(Sort.Order.desc("orcNumProEmp")));
    }



    public Optional<OrcamentoModel> getOrcamentoById(Integer id) {
        return repository.findById(id);
    }

    public OrcamentoModel saveOrcamento(OrcamentoModel Orcamento) {
        return repository.save(Orcamento);
    }

    public OrcamentoModel updateOrcamento(Integer id, OrcamentoModel Orcamento) {
        if (repository.existsById(id)) {
            Orcamento.setOrcId(id);
            return repository.save(Orcamento);
        } else {
            throw new RuntimeException("Orçamento não encontrado com ID: " + id);
        }
    }


    public void deleteOrcamento(Integer id) {
        repository.deleteById(id);
    }

    public Integer getProximoOrcNumProEmp(Integer empId) {
        Integer ultimoNumProEmp = repository.getUltimoOrcNumProEmp(empId);
        if(ultimoNumProEmp == null){
            ultimoNumProEmp =0;
        }
        ultimoNumProEmp += 1;
        return ultimoNumProEmp;
    }

    public Integer atualizarEtapaProcessoEmpresa(Integer id, Integer orcEtap) {
        // Verifica se o orçamento com o ID fornecido existe no banco de dados
        if (repository.existsById(id)) {
            // Recupera o orçamento existente com o ID fornecido
            OrcamentoModel existingOrcamento = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Orçamento não encontrado com ID: " + id));

            if (orcEtap==1) {//ORCAMENTO_APROVADO
                // Verifica se o orçamento já está aprovado
                if (existingOrcamento.getOrcEtap() == OrcEtapEnum.ORCAMENTO_APROVADO ) {
                    throw new RuntimeException("Orçamento já foi aprovado anteriormente" );
                }
                // Atualiza o campo orcEtap para ORCAMENTO_APROVADO
                existingOrcamento.setOrcEtap(OrcEtapEnum.ORCAMENTO_APROVADO);
            }

            if (orcEtap==2) {//ENGENHARIA
                if (existingOrcamento.getOrcEtap() == OrcEtapEnum.ENGENHARIA ) {
                    throw new RuntimeException("Processo já foi para Engenharia anteriormente" );
                }
                existingOrcamento.setOrcEtap(OrcEtapEnum.ENGENHARIA);
            }
            if (orcEtap==3) {//FABRICACAO
                if (existingOrcamento.getOrcEtap() != OrcEtapEnum.ENGENHARIA && existingOrcamento.getOrcEtap() != OrcEtapEnum.FABRICACAO) {
                    throw new RuntimeException("Processo precisa estar na etapa de Engenharia ou Fabricação" );
                }
                existingOrcamento.setOrcEtap(OrcEtapEnum.FABRICACAO);
            }
            if (orcEtap==4) {//TRANSPORTE
                if (existingOrcamento.getOrcEtap() == OrcEtapEnum.TRANSPORTE ) {
                    throw new RuntimeException("Processo já foi para Transporte anteriormente" );
                }
                existingOrcamento.setOrcEtap(OrcEtapEnum.TRANSPORTE);
            }
            if (orcEtap==5) {//MONTAGEM
                if (existingOrcamento.getOrcEtap() == OrcEtapEnum.MONTAGEM ) {
                    throw new RuntimeException("Processo já foi para Montagem anteriormente" );
                }
                existingOrcamento.setOrcEtap(OrcEtapEnum.MONTAGEM);
            }
            // Salva o objeto atualizado no banco de dados e retorna apenas o ID
            OrcamentoModel updatedOrcamento = repository.save(existingOrcamento);

            return updatedOrcamento.getOrcId(); // Retorna o ID do orçamento atualizado
        } else {
            // Caso não encontre o orçamento, lança uma exceção
            throw new RuntimeException("Orçamento não encontrado com ID: " + id);
        }
    }



}
