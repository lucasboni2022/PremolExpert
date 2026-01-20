package com.premolexpert.api.service;

import com.premolexpert.api.dto.PaisDTO;
import com.premolexpert.api.entity.Pais;
import com.premolexpert.api.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    // converter Model -> DTO
    private PaisDTO toDTO(Pais pais) {
        return new PaisDTO(pais.getPaisId(), pais.getPaisNom(), pais.getPaisSigla());
    }

    // converter DTO -> Model
    private Pais toEntity(PaisDTO paisDTO) {
        Pais pais = new Pais();
        pais.setPaisId(paisDTO.getPaisId());
        pais.setPaisNom(paisDTO.getPaisNom());
        pais.setPaisSigla(paisDTO.getPaisSigla());
        return pais;
    }

    public Page<PaisDTO> getAll(int page, int size) {
        Page<Pais> pais = paisRepository.findAll(PageRequest.of(page, size));
        return pais.map(this::toDTO);
    }

    public PaisDTO getById(Integer id) {
        return paisRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public PaisDTO create(PaisDTO paisDTO) {
        paisDTO.setPaisId(null); // Garante que é uma criação
        Pais pais = toEntity(paisDTO);

        //Valor Padrão auditoria
        pais.setPaisIncPor(null);
        pais.setPaisIncEm(LocalDateTime.now());
        pais.setPaisAltPor(null);
        pais.setPaisAltEm(null);

        Pais saved = paisRepository.save(pais);
        return toDTO(saved);
    }

    public PaisDTO update(PaisDTO paisDTO) {
        // Verifica se existe antes de atualizar (opcional, mas recomendado)
        if (paisDTO.getPaisId() != null && paisRepository.existsById(paisDTO.getPaisId())) {
            Pais pais = toEntity(paisDTO);
            pais.setPaisAltPor(null);
            pais.setPaisAltEm(LocalDateTime.now());
            Pais saved = paisRepository.save(pais);
            return toDTO(saved);
        }
        return null; // Ou lançar exceção
    }

    public void delete(Integer id) {
        paisRepository.deleteById(id);
    }

}
