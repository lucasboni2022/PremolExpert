package com.premolexpert.api.service;

import com.premolexpert.api.dto.TelaDTO;
import com.premolexpert.api.entity.Tela;
import com.premolexpert.api.repository.TelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TelaService {

    @Autowired
    private TelaRepository telaRepository;

    public Page<TelaDTO> getAll(int page, int size) {
        return telaRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public TelaDTO getById(Integer id) {
        return telaRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public TelaDTO create(TelaDTO telaDTO) {
        telaDTO.setTelId(null);
        Tela tela = toEntity(telaDTO);
        
        LocalDateTime now = LocalDateTime.now();
        tela.setTelIncEm(now);
        tela.setTelIncPor(telaDTO.getTelIncPor());
        tela.setTelAltEm(null);
        tela.setTelAltPor(null);

        Tela saved = telaRepository.save(tela);
        return toDTO(saved);
    }

    public TelaDTO update(TelaDTO telaDTO) {
        if (telaDTO.getTelId() == null || !telaRepository.existsById(telaDTO.getTelId())) {
            return null;
        }
        Tela tela = toEntity(telaDTO);
        
        Tela existing = telaRepository.findById(telaDTO.getTelId()).orElse(null);
        if (existing != null) {
            tela.setTelIncEm(existing.getTelIncEm());
            tela.setTelIncPor(existing.getTelIncPor());
        }

        LocalDateTime now = LocalDateTime.now();
        tela.setTelAltEm(now);
        tela.setTelAltPor(telaDTO.getTelAltPor());

        Tela saved = telaRepository.save(tela);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        telaRepository.deleteById(id);
    }

    private TelaDTO toDTO(Tela tela) {
        TelaDTO telaDTO = new TelaDTO();
        telaDTO.setTelId(tela.getTelId());
        telaDTO.setTelNom(tela.getTelNom());
        telaDTO.setTelIncPor(tela.getTelIncPor());
        telaDTO.setTelIncEm(tela.getTelIncEm());
        telaDTO.setTelAltPor(tela.getTelAltPor());
        telaDTO.setTelAltEm(tela.getTelAltEm());
        return telaDTO;
    }

    private Tela toEntity(TelaDTO telaDTO) {
        Tela tela = new Tela();
        tela.setTelId(telaDTO.getTelId());
        tela.setTelNom(telaDTO.getTelNom());
        tela.setTelIncPor(telaDTO.getTelIncPor());
        tela.setTelIncEm(telaDTO.getTelIncEm());
        tela.setTelAltPor(telaDTO.getTelAltPor());
        tela.setTelAltEm(telaDTO.getTelAltEm());
        return tela;
    }
}
