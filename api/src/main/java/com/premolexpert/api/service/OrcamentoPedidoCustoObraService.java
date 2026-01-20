package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraDTO;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObra;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrcamentoPedidoCustoObraService {

    @Autowired
    private OrcamentoPedidoCustoObraRepository orcamentoPedidoCustoObraRepository;

    public Page<OrcamentoPedidoCustoObraDTO> getAll(int page, int size) {
        return orcamentoPedidoCustoObraRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public OrcamentoPedidoCustoObraDTO getById(Integer id) {
        return orcamentoPedidoCustoObraRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public OrcamentoPedidoCustoObraDTO create(OrcamentoPedidoCustoObraDTO orcamentoPedidoCustoObraDTO) {
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrId(null);
        OrcamentoPedidoCustoObra orcamentoPedidoCustoObra = toEntity(orcamentoPedidoCustoObraDTO);
        
        LocalDateTime now = LocalDateTime.now();
        orcamentoPedidoCustoObra.setOrcPedCustoObrIncEm(now);
        orcamentoPedidoCustoObra.setOrcPedCustoObrIncPor(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrIncPor());
        orcamentoPedidoCustoObra.setOrcPedCustoObrAltEm(null);
        orcamentoPedidoCustoObra.setOrcPedCustoObrAltPor(null);

        OrcamentoPedidoCustoObra saved = orcamentoPedidoCustoObraRepository.save(orcamentoPedidoCustoObra);
        return toDTO(saved);
    }

    public OrcamentoPedidoCustoObraDTO update(OrcamentoPedidoCustoObraDTO orcamentoPedidoCustoObraDTO) {
        if (orcamentoPedidoCustoObraDTO.getOrcPedCustoObrId() == null || !orcamentoPedidoCustoObraRepository.existsById(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrId())) {
            return null;
        }
        OrcamentoPedidoCustoObra orcamentoPedidoCustoObra = toEntity(orcamentoPedidoCustoObraDTO);
        
        OrcamentoPedidoCustoObra existing = orcamentoPedidoCustoObraRepository.findById(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrId()).orElse(null);
        if (existing != null) {
            orcamentoPedidoCustoObra.setOrcPedCustoObrIncEm(existing.getOrcPedCustoObrIncEm());
            orcamentoPedidoCustoObra.setOrcPedCustoObrIncPor(existing.getOrcPedCustoObrIncPor());
        }

        LocalDateTime now = LocalDateTime.now();
        orcamentoPedidoCustoObra.setOrcPedCustoObrAltEm(now);
        orcamentoPedidoCustoObra.setOrcPedCustoObrAltPor(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrAltPor());

        OrcamentoPedidoCustoObra saved = orcamentoPedidoCustoObraRepository.save(orcamentoPedidoCustoObra);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        orcamentoPedidoCustoObraRepository.deleteById(id);
    }

    private OrcamentoPedidoCustoObraDTO toDTO(OrcamentoPedidoCustoObra orcamentoPedidoCustoObra) {
        OrcamentoPedidoCustoObraDTO orcamentoPedidoCustoObraDTO = new OrcamentoPedidoCustoObraDTO();
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrId(orcamentoPedidoCustoObra.getOrcPedCustoObrId());
        orcamentoPedidoCustoObraDTO.setOrcPedId(orcamentoPedidoCustoObra.getOrcPedId());
        orcamentoPedidoCustoObraDTO.setSerCustoId(orcamentoPedidoCustoObra.getSerCustoId());
        orcamentoPedidoCustoObraDTO.setUniId(orcamentoPedidoCustoObra.getUniId());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrQtd(orcamentoPedidoCustoObra.getOrcPedCustoObrQtd());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrVlrUnit(orcamentoPedidoCustoObra.getOrcPedCustoObrVlrUnit());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrPron(orcamentoPedidoCustoObra.getOrcPedCustoObrPron());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrFaze(orcamentoPedidoCustoObra.getOrcPedCustoObrFaze());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrSitua(orcamentoPedidoCustoObra.getOrcPedCustoObrSitua());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrTipo(orcamentoPedidoCustoObra.getOrcPedCustoObrTipo());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrIncPor(orcamentoPedidoCustoObra.getOrcPedCustoObrIncPor());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrIncEm(orcamentoPedidoCustoObra.getOrcPedCustoObrIncEm());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrAltPor(orcamentoPedidoCustoObra.getOrcPedCustoObrAltPor());
        orcamentoPedidoCustoObraDTO.setOrcPedCustoObrAltEm(orcamentoPedidoCustoObra.getOrcPedCustoObrAltEm());
        return orcamentoPedidoCustoObraDTO;
    }

    private OrcamentoPedidoCustoObra toEntity(OrcamentoPedidoCustoObraDTO orcamentoPedidoCustoObraDTO) {
        OrcamentoPedidoCustoObra orcamentoPedidoCustoObra = new OrcamentoPedidoCustoObra();
        orcamentoPedidoCustoObra.setOrcPedCustoObrId(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrId());
        orcamentoPedidoCustoObra.setOrcPedId(orcamentoPedidoCustoObraDTO.getOrcPedId());
        orcamentoPedidoCustoObra.setSerCustoId(orcamentoPedidoCustoObraDTO.getSerCustoId());
        orcamentoPedidoCustoObra.setUniId(orcamentoPedidoCustoObraDTO.getUniId());
        orcamentoPedidoCustoObra.setOrcPedCustoObrQtd(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrQtd());
        orcamentoPedidoCustoObra.setOrcPedCustoObrVlrUnit(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrVlrUnit());
        orcamentoPedidoCustoObra.setOrcPedCustoObrPron(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrPron());
        orcamentoPedidoCustoObra.setOrcPedCustoObrFaze(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrFaze());
        orcamentoPedidoCustoObra.setOrcPedCustoObrSitua(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrSitua());
        orcamentoPedidoCustoObra.setOrcPedCustoObrTipo(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrTipo());
        orcamentoPedidoCustoObra.setOrcPedCustoObrIncPor(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrIncPor());
        orcamentoPedidoCustoObra.setOrcPedCustoObrIncEm(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrIncEm());
        orcamentoPedidoCustoObra.setOrcPedCustoObrAltPor(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrAltPor());
        orcamentoPedidoCustoObra.setOrcPedCustoObrAltEm(orcamentoPedidoCustoObraDTO.getOrcPedCustoObrAltEm());
        return orcamentoPedidoCustoObra;
    }
}
