package com.premolexpert.api.service;

import com.premolexpert.api.dto.PerfilDTO;
import com.premolexpert.api.entity.Perfil;
import com.premolexpert.api.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Page<PerfilDTO> getAll(int page, int size) {
        return perfilRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public PerfilDTO getById(Integer id) {
        return perfilRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public PerfilDTO create(PerfilDTO perfilDTO) {
        perfilDTO.setPerId(null);
        Perfil perfil = toEntity(perfilDTO);
        
        LocalDateTime now = LocalDateTime.now();
        perfil.setPerIncEm(now);
        perfil.setPerIncPor(perfilDTO.getPerIncPor()); // Assuming passed or handled by controller context
        perfil.setPerAltEm(null);
        perfil.setPerAltPor(null);

        Perfil saved = perfilRepository.save(perfil);
        return toDTO(saved);
    }

    public PerfilDTO update(PerfilDTO perfilDTO) {
        if (perfilDTO.getPerId() == null || !perfilRepository.existsById(perfilDTO.getPerId())) {
            return null;
        }
        Perfil perfil = toEntity(perfilDTO);
        
        // Preserve creation info if needed, but usually we just set update info
        // For simplicity, we assume the DTO might carry it or we fetch existing.
        // Better pattern: fetch existing, update fields.
        Perfil existing = perfilRepository.findById(perfilDTO.getPerId()).orElse(null);
        if (existing != null) {
            perfil.setPerIncEm(existing.getPerIncEm());
            perfil.setPerIncPor(existing.getPerIncPor());
        }

        LocalDateTime now = LocalDateTime.now();
        perfil.setPerAltEm(now);
        perfil.setPerAltPor(perfilDTO.getPerAltPor()); // Assuming passed

        Perfil saved = perfilRepository.save(perfil);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        perfilRepository.deleteById(id);
    }

    private PerfilDTO toDTO(Perfil perfil) {
        PerfilDTO perfilDTO = new PerfilDTO();
        perfilDTO.setPerId(perfil.getPerId());
        perfilDTO.setPerNom(perfil.getPerNom());
        perfilDTO.setEmpId(perfil.getEmpId());
        perfilDTO.setPerIncPor(perfil.getPerIncPor());
        perfilDTO.setPerIncEm(perfil.getPerIncEm());
        perfilDTO.setPerAltPor(perfil.getPerAltPor());
        perfilDTO.setPerAltEm(perfil.getPerAltEm());
        return perfilDTO;
    }

    private Perfil toEntity(PerfilDTO perfilDTO) {
        Perfil perfil = new Perfil();
        perfil.setPerId(perfilDTO.getPerId());
        perfil.setPerNom(perfilDTO.getPerNom());
        perfil.setEmpId(perfilDTO.getEmpId());
        perfil.setPerIncPor(perfilDTO.getPerIncPor());
        perfil.setPerIncEm(perfilDTO.getPerIncEm());
        perfil.setPerAltPor(perfilDTO.getPerAltPor());
        perfil.setPerAltEm(perfilDTO.getPerAltEm());
        return perfil;
    }
}
