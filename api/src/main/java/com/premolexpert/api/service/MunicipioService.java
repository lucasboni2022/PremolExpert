package com.premolexpert.api.service;

import com.premolexpert.api.dto.MunicipioDTO;
import com.premolexpert.api.entity.Municipio;
import com.premolexpert.api.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    private MunicipioDTO toDTO(Municipio municipio) {
        return new MunicipioDTO(
                municipio.getMunId(),
                municipio.getMunNom(),
                municipio.getEstId(),
                municipio.getEstado() != null ? municipio.getEstado().getEstNom() : null,
                municipio.getEstado() != null && municipio.getEstado().getPais() != null ? municipio.getEstado().getPais().getPaisNom() : null,
                municipio.getEmpId(),
                municipio.getMunMunOrigId(),
                municipio.getMunAtivo(),
                municipio.getMunIncPor(),
                municipio.getMunIncEm(),
                municipio.getMunAltPor(),
                municipio.getMunAltEm()
        );
    }

    private Municipio toEntity(MunicipioDTO municipioDTO) {
        Municipio municipio = new Municipio();
        municipio.setMunId(municipioDTO.getMunId());
        municipio.setMunNom(municipioDTO.getMunNom());
        municipio.setEstId(municipioDTO.getEstId());
        municipio.setEmpId(municipioDTO.getEmpId());
        municipio.setMunMunOrigId(municipioDTO.getMunMunOrigId());
        municipio.setMunAtivo(municipioDTO.getMunAtivo());
        municipio.setMunIncPor(municipioDTO.getMunIncPor());
        municipio.setMunIncEm(municipioDTO.getMunIncEm());
        municipio.setMunAltPor(municipioDTO.getMunAltPor());
        municipio.setMunAltEm(municipioDTO.getMunAltEm());
        return municipio;
    }

    public Page<MunicipioDTO> getAll(int page, int size) {
        Page<Municipio> municipios = municipioRepository.findAll(PageRequest.of(page, size));
        return municipios.map(this::toDTO);
    }

    public MunicipioDTO getById(Integer id) {
        return municipioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public MunicipioDTO create(MunicipioDTO municipioDTO) {
        municipioDTO.setMunId(null);
        Municipio municipio = toEntity(municipioDTO);

        if (municipio.getMunIncEm() == null) {
            municipio.setMunIncEm(LocalDateTime.now());
        }
        
        if (municipio.getMunAtivo() == null) {
            municipio.setMunAtivo(true);
        }

        municipio.setMunAltEm(LocalDateTime.now());

        Municipio saved = municipioRepository.save(municipio);
        return toDTO(saved);
    }

    public MunicipioDTO update(MunicipioDTO municipioDTO) {
        if (municipioDTO.getMunId() != null && municipioRepository.existsById(municipioDTO.getMunId())) {
            Municipio municipio = toEntity(municipioDTO);

            if (municipio.getMunIncEm() == null) {
                municipioRepository.findById(municipioDTO.getMunId()).ifPresent(existing ->
                        municipio.setMunIncEm(existing.getMunIncEm())
                );
            }

            municipio.setMunAltEm(LocalDateTime.now());

            Municipio saved = municipioRepository.save(municipio);
            return toDTO(saved);
        }
        return null;
    }

    public void delete(Integer id) {
        municipioRepository.deleteById(id);
    }
}
