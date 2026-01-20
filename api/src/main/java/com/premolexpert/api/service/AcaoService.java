package com.premolexpert.api.service;

import com.premolexpert.api.dto.AcaoDTO;
import com.premolexpert.api.entity.Acao;
import com.premolexpert.api.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AcaoService {

    @Autowired
    private AcaoRepository acaoRepository;

    public Page<AcaoDTO> getAll(int page, int size) {
        return acaoRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public AcaoDTO getById(Integer id) {
        return acaoRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public AcaoDTO create(AcaoDTO acaoDTO) {
        acaoDTO.setAcaId(null);
        Acao acao = toEntity(acaoDTO);
        
        LocalDateTime now = LocalDateTime.now();
        acao.setAcaIncEm(now);
        acao.setAcaIncPor(acaoDTO.getAcaIncPor());
        acao.setAcaAltEm(null);
        acao.setAcaAltPor(null);

        Acao saved = acaoRepository.save(acao);
        return toDTO(saved);
    }

    public AcaoDTO update(AcaoDTO acaoDTO) {
        if (acaoDTO.getAcaId() == null || !acaoRepository.existsById(acaoDTO.getAcaId())) {
            return null;
        }
        Acao acao = toEntity(acaoDTO);
        
        Acao existing = acaoRepository.findById(acaoDTO.getAcaId()).orElse(null);
        if (existing != null) {
            acao.setAcaIncEm(existing.getAcaIncEm());
            acao.setAcaIncPor(existing.getAcaIncPor());
        }

        LocalDateTime now = LocalDateTime.now();
        acao.setAcaAltEm(now);
        acao.setAcaAltPor(acaoDTO.getAcaAltPor());

        Acao saved = acaoRepository.save(acao);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        acaoRepository.deleteById(id);
    }

    private AcaoDTO toDTO(Acao acao) {
        AcaoDTO acaoDTO = new AcaoDTO();
        acaoDTO.setAcaId(acao.getAcaId());
        acaoDTO.setAcaNom(acao.getAcaNom());
        acaoDTO.setAcaIncPor(acao.getAcaIncPor());
        acaoDTO.setAcaIncEm(acao.getAcaIncEm());
        acaoDTO.setAcaAltPor(acao.getAcaAltPor());
        acaoDTO.setAcaAltEm(acao.getAcaAltEm());
        return acaoDTO;
    }

    private Acao toEntity(AcaoDTO acaoDTO) {
        Acao acao = new Acao();
        acao.setAcaId(acaoDTO.getAcaId());
        acao.setAcaNom(acaoDTO.getAcaNom());
        acao.setAcaIncPor(acaoDTO.getAcaIncPor());
        acao.setAcaIncEm(acaoDTO.getAcaIncEm());
        acao.setAcaAltPor(acaoDTO.getAcaAltPor());
        acao.setAcaAltEm(acaoDTO.getAcaAltEm());
        return acao;
    }
}
