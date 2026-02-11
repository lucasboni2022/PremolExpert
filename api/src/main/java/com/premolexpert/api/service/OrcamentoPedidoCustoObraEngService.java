package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraEngDTO;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObra;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObraEng;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraEngRepository;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrcamentoPedidoCustoObraEngService {

    @Autowired
    private OrcamentoPedidoCustoObraEngRepository orcamentoPedidoCustoObraEngRepository;

    @Autowired
    private OrcamentoPedidoCustoObraRepository orcamentoPedidoCustoObraRepository;

    @Transactional(readOnly = true)
    public Page<OrcamentoPedidoCustoObraEngDTO> getAll(int page, int size) {
        return orcamentoPedidoCustoObraEngRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    @Transactional(readOnly = true)
    public OrcamentoPedidoCustoObraEngDTO getById(Integer id) {
        return orcamentoPedidoCustoObraEngRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Transactional
    public OrcamentoPedidoCustoObraEngDTO create(OrcamentoPedidoCustoObraEngDTO dto) {
        dto.setOrcPedCustoObrEngId(null);
        OrcamentoPedidoCustoObraEng entity = toEntity(dto);
        
        LocalDateTime now = LocalDateTime.now();
        entity.setOrcPedCustoObrEngIncEm(now);
        entity.setOrcPedCustoObrEngIncPor(dto.getOrcPedCustoObrEngIncPor());
        entity.setOrcPedCustoObrEngAltEm(null);
        entity.setOrcPedCustoObrEngAltPor(null);

        OrcamentoPedidoCustoObraEng saved = orcamentoPedidoCustoObraEngRepository.save(entity);
        return toDTO(saved);
    }

    @Transactional
    public OrcamentoPedidoCustoObraEngDTO update(OrcamentoPedidoCustoObraEngDTO dto) {
        if (dto.getOrcPedCustoObrEngId() == null || !orcamentoPedidoCustoObraEngRepository.existsById(dto.getOrcPedCustoObrEngId())) {
            return null;
        }
        
        OrcamentoPedidoCustoObraEng entity = toEntity(dto);
        
        orcamentoPedidoCustoObraEngRepository.findById(dto.getOrcPedCustoObrEngId()).ifPresent(existing -> {
            entity.setOrcPedCustoObrEngIncEm(existing.getOrcPedCustoObrEngIncEm());
            entity.setOrcPedCustoObrEngIncPor(existing.getOrcPedCustoObrEngIncPor());
        });

        LocalDateTime now = LocalDateTime.now();
        entity.setOrcPedCustoObrEngAltEm(now);
        entity.setOrcPedCustoObrEngAltPor(dto.getOrcPedCustoObrEngAltPor());

        OrcamentoPedidoCustoObraEng saved = orcamentoPedidoCustoObraEngRepository.save(entity);
        return toDTO(saved);
    }

    @Transactional
    public void delete(Integer id) {
        orcamentoPedidoCustoObraEngRepository.deleteById(id);
    }

    private OrcamentoPedidoCustoObraEng toEntity(OrcamentoPedidoCustoObraEngDTO dto) {
        OrcamentoPedidoCustoObraEng entity = new OrcamentoPedidoCustoObraEng();
        entity.setOrcPedCustoObrEngId(dto.getOrcPedCustoObrEngId());
        entity.setOrcPedCustoObrEngQtdAFazer(dto.getOrcPedCustoObrEngQtdAFazer());
        entity.setOrcPedCustoObrEngQtdLibParFabr(dto.getOrcPedCustoObrEngQtdLibParFabr());
        entity.setOrcPedCustoObrEngLote(dto.getOrcPedCustoObrEngLote());
        
        if (dto.getOrcPedCustoObrId() != null) {
            orcamentoPedidoCustoObraRepository.findById(dto.getOrcPedCustoObrId())
                .ifPresent(entity::setOrcPedCustoObr);
        }

        entity.setOrcPedCustoObrEngIncPor(dto.getOrcPedCustoObrEngIncPor());
        entity.setOrcPedCustoObrEngIncEm(dto.getOrcPedCustoObrEngIncEm());
        entity.setOrcPedCustoObrEngAltPor(dto.getOrcPedCustoObrEngAltPor());
        entity.setOrcPedCustoObrEngAltEm(dto.getOrcPedCustoObrEngAltEm());
        
        return entity;
    }

    private OrcamentoPedidoCustoObraEngDTO toDTO(OrcamentoPedidoCustoObraEng entity) {
        OrcamentoPedidoCustoObraEngDTO dto = new OrcamentoPedidoCustoObraEngDTO();
        dto.setOrcPedCustoObrEngId(entity.getOrcPedCustoObrEngId());
        dto.setOrcPedCustoObrEngQtdAFazer(entity.getOrcPedCustoObrEngQtdAFazer());
        dto.setOrcPedCustoObrEngQtdLibParFabr(entity.getOrcPedCustoObrEngQtdLibParFabr());
        dto.setOrcPedCustoObrEngLote(entity.getOrcPedCustoObrEngLote());
        
        if (entity.getOrcPedCustoObr() != null) {
            // Fix: OrcamentoPedidoCustoObra uses getId(), not getOrcPedCustoObrId()
            dto.setOrcPedCustoObrId(entity.getOrcPedCustoObr().getId());
        }

        dto.setOrcPedCustoObrEngIncPor(entity.getOrcPedCustoObrEngIncPor());
        dto.setOrcPedCustoObrEngIncEm(entity.getOrcPedCustoObrEngIncEm());
        dto.setOrcPedCustoObrEngAltPor(entity.getOrcPedCustoObrEngAltPor());
        dto.setOrcPedCustoObrEngAltEm(entity.getOrcPedCustoObrEngAltEm());
        
        return dto;
    }
}
