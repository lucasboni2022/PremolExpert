package com.premolexpert.api.service;

import com.premolexpert.api.dto.UnidadeDTO;
import com.premolexpert.api.entity.Unidade;
import com.premolexpert.api.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Page<UnidadeDTO> getAll(int page, int size) {
        return unidadeRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public UnidadeDTO getById(Integer id) {
        return unidadeRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public UnidadeDTO create(UnidadeDTO unidadeDTO) {
        unidadeDTO.setUniId(null);
        Unidade unidade = toEntity(unidadeDTO);
        Unidade saved = unidadeRepository.save(unidade);
        return toDTO(saved);
    }

    public UnidadeDTO update(UnidadeDTO unidadeDTO) {
        if (unidadeDTO.getUniId() == null || !unidadeRepository.existsById(unidadeDTO.getUniId())) {
            return null;
        }
        Unidade unidade = toEntity(unidadeDTO);
        Unidade saved = unidadeRepository.save(unidade);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        unidadeRepository.deleteById(id);
    }

    private UnidadeDTO toDTO(Unidade unidade) {
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setUniId(unidade.getUniId());
        unidadeDTO.setUniNom(unidade.getUniNom());
        return unidadeDTO;
    }

    private Unidade toEntity(UnidadeDTO unidadeDTO) {
        Unidade unidade = new Unidade();
        unidade.setUniId(unidadeDTO.getUniId());
        unidade.setUniNom(unidadeDTO.getUniNom());
        return unidade;
    }
}
