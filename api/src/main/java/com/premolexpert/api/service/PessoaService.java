package com.premolexpert.api.service;

import com.premolexpert.api.dto.PessoaDTO;
import com.premolexpert.api.entity.Pessoa;
import com.premolexpert.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public Page<PessoaDTO> getAll(int page, int size) {
        return pessoaRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    @Transactional(readOnly = true)
    public Page<PessoaDTO> searchByNome(String nome, int page, int size) {
        return pessoaRepository.findByPesNomContainingIgnoreCase(nome, PageRequest.of(page, size)).map(this::toDTO);
    }

    private PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setPesId(pessoa.getPesId());
        dto.setPesNom(pessoa.getPesNom());
        dto.setPesCpf(pessoa.getPesCpf());
        dto.setPesCnpj(pessoa.getPesCnpj());
        dto.setPesEmail(pessoa.getPesEmail());
        dto.setPesEnd(pessoa.getPesEnd());
        
        if (pessoa.getMunicipio() != null) {
            dto.setMunId(pessoa.getMunicipio().getMunId());
        }
        
        if (pessoa.getEmpresa() != null) {
            dto.setEmpId(pessoa.getEmpresa().getEmpId());
        }

        dto.setPesFisJur(pessoa.getPesFisJur());
        dto.setPesTelPesDDD(pessoa.getPesTelPesDDD());
        dto.setPesTelPes(pessoa.getPesTelPes());
        dto.setPesTelComDDD(pessoa.getPesTelComDDD());
        dto.setPesTelCom(pessoa.getPesTelCom());
        dto.setPesCelPesDDD(pessoa.getPesCelPesDDD());
        dto.setPesCelPes(pessoa.getPesCelPes());
        dto.setPesCelComDDD(pessoa.getPesCelComDDD());
        dto.setPesCelComPes(pessoa.getPesCelComPes());
        dto.setPesIncPor(pessoa.getPesIncPor());
        dto.setPesIncEm(pessoa.getPesIncEm());
        dto.setPesAltPor(pessoa.getPesAltPor());
        dto.setPesAltEm(pessoa.getPesAltEm());
        
        return dto;
    }
}
