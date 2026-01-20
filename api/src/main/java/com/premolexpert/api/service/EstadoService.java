package com.premolexpert.api.service;

import com.premolexpert.api.dto.EstadoDTO;
import com.premolexpert.api.entity.Estado;
import com.premolexpert.api.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    private EstadoDTO toDTO(Estado estado) {
        return new EstadoDTO(
                estado.getEstId(),
                estado.getEstNom(),
                estado.getEstSigla(),
                estado.getPaisId(),
                estado.getEstIncPor(),
                estado.getEstIncEm(),
                estado.getEstAltPor(),
                estado.getEstAltEm()
        );
    }

    private Estado toEntity(EstadoDTO estadoDTO) {
        Estado estado = new Estado();
        estado.setEstId(estadoDTO.getEstId());
        estado.setEstNom(estadoDTO.getEstNom());
        estado.setEstSigla(estadoDTO.getEstSigla());
        estado.setPaisId(estadoDTO.getPaisId());
        estado.setEstIncPor(estadoDTO.getEstIncPor());
        estado.setEstIncEm(estadoDTO.getEstIncEm());
        estado.setEstAltPor(estadoDTO.getEstAltPor());
        estado.setEstAltEm(estadoDTO.getEstAltEm());
        return estado;
    }

    public Page<EstadoDTO> getAll(int page, int size) {
        Page<Estado> estados = estadoRepository.findAll(PageRequest.of(page, size));
        return estados.map(this::toDTO);
    }

    public EstadoDTO getById(Integer id) {
        return estadoRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public EstadoDTO create(EstadoDTO estadoDTO) {
        estadoDTO.setEstId(null); // Garante que é uma criação
        Estado estado = toEntity(estadoDTO);


        estado.setEstIncEm(LocalDateTime.now());

        Estado saved = estadoRepository.save(estado);
        return toDTO(saved);
    }

    public EstadoDTO update(EstadoDTO estadoDTO) {
        if (estadoDTO.getEstId() != null && estadoRepository.existsById(estadoDTO.getEstId())) {
            Estado estado = toEntity(estadoDTO);

            estado.setEstAltEm(LocalDateTime.now());

            Estado saved = estadoRepository.save(estado);
            return toDTO(saved);
        }
        return null;
    }

    public void delete(Integer id) {
        estadoRepository.deleteById(id);
    }
}
