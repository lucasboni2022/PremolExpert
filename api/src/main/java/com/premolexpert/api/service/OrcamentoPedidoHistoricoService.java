package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoHistoricoDTO;
import com.premolexpert.api.entity.OrcamentoPedidoHistorico;
import com.premolexpert.api.repository.OrcamentoPedidoHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrcamentoPedidoHistoricoService {

    @Autowired
    private OrcamentoPedidoHistoricoRepository orcamentoPedidoHistoricoRepository;

    public Page<OrcamentoPedidoHistoricoDTO> getAll(int page, int size) {
        return orcamentoPedidoHistoricoRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public OrcamentoPedidoHistoricoDTO getById(Integer id) {
        return orcamentoPedidoHistoricoRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public OrcamentoPedidoHistoricoDTO create(OrcamentoPedidoHistoricoDTO orcamentoPedidoHistoricoDTO) {
        orcamentoPedidoHistoricoDTO.setOrcPedHistId(null);
        OrcamentoPedidoHistorico orcamentoPedidoHistorico = toEntity(orcamentoPedidoHistoricoDTO);
        
        LocalDateTime now = LocalDateTime.now();
        orcamentoPedidoHistorico.setOrcPedHistIncEm(now);
        orcamentoPedidoHistorico.setOrcPedHistIncPor(orcamentoPedidoHistoricoDTO.getOrcPedHistIncPor());
        
        // No update auditing fields in this table per SQL definition
        
        OrcamentoPedidoHistorico saved = orcamentoPedidoHistoricoRepository.save(orcamentoPedidoHistorico);
        return toDTO(saved);
    }

    public OrcamentoPedidoHistoricoDTO update(OrcamentoPedidoHistoricoDTO orcamentoPedidoHistoricoDTO) {
        if (orcamentoPedidoHistoricoDTO.getOrcPedHistId() == null || !orcamentoPedidoHistoricoRepository.existsById(orcamentoPedidoHistoricoDTO.getOrcPedHistId())) {
            return null;
        }
        OrcamentoPedidoHistorico orcamentoPedidoHistorico = toEntity(orcamentoPedidoHistoricoDTO);
        
        // This table seems to be a history log, so updates might be rare or just corrections.
        // Preserving creation info.
        OrcamentoPedidoHistorico existing = orcamentoPedidoHistoricoRepository.findById(orcamentoPedidoHistoricoDTO.getOrcPedHistId()).orElse(null);
        if (existing != null) {
            orcamentoPedidoHistorico.setOrcPedHistIncEm(existing.getOrcPedHistIncEm());
            orcamentoPedidoHistorico.setOrcPedHistIncPor(existing.getOrcPedHistIncPor());
        }

        OrcamentoPedidoHistorico saved = orcamentoPedidoHistoricoRepository.save(orcamentoPedidoHistorico);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        orcamentoPedidoHistoricoRepository.deleteById(id);
    }

    private OrcamentoPedidoHistoricoDTO toDTO(OrcamentoPedidoHistorico orcamentoPedidoHistorico) {
        OrcamentoPedidoHistoricoDTO orcamentoPedidoHistoricoDTO = new OrcamentoPedidoHistoricoDTO();
        orcamentoPedidoHistoricoDTO.setOrcPedHistId(orcamentoPedidoHistorico.getOrcPedHistId());
        orcamentoPedidoHistoricoDTO.setOrcPedId(orcamentoPedidoHistorico.getOrcPedId());
        orcamentoPedidoHistoricoDTO.setOrcPedEtapa(orcamentoPedidoHistorico.getOrcPedEtapa());
        orcamentoPedidoHistoricoDTO.setOrcPedHistIncPor(orcamentoPedidoHistorico.getOrcPedHistIncPor());
        orcamentoPedidoHistoricoDTO.setOrcPedHistIncEm(orcamentoPedidoHistorico.getOrcPedHistIncEm());
        orcamentoPedidoHistoricoDTO.setOrcPedHistObs(orcamentoPedidoHistorico.getOrcPedHistObs());
        return orcamentoPedidoHistoricoDTO;
    }

    private OrcamentoPedidoHistorico toEntity(OrcamentoPedidoHistoricoDTO orcamentoPedidoHistoricoDTO) {
        OrcamentoPedidoHistorico orcamentoPedidoHistorico = new OrcamentoPedidoHistorico();
        orcamentoPedidoHistorico.setOrcPedHistId(orcamentoPedidoHistoricoDTO.getOrcPedHistId());
        orcamentoPedidoHistorico.setOrcPedId(orcamentoPedidoHistoricoDTO.getOrcPedId());
        orcamentoPedidoHistorico.setOrcPedEtapa(orcamentoPedidoHistoricoDTO.getOrcPedEtapa());
        orcamentoPedidoHistorico.setOrcPedHistIncPor(orcamentoPedidoHistoricoDTO.getOrcPedHistIncPor());
        orcamentoPedidoHistorico.setOrcPedHistIncEm(orcamentoPedidoHistoricoDTO.getOrcPedHistIncEm());
        orcamentoPedidoHistorico.setOrcPedHistObs(orcamentoPedidoHistoricoDTO.getOrcPedHistObs());
        return orcamentoPedidoHistorico;
    }
}
