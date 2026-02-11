package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraDTO;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObra;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraRepository;
import com.premolexpert.api.repository.OrcamentoPedidoRepository;
import com.premolexpert.api.repository.ServicoCustoRepository;
import com.premolexpert.api.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrcamentoPedidoCustoObraService {

    @Autowired
    private OrcamentoPedidoCustoObraRepository orcamentoPedidoCustoObraRepository;

    @Autowired
    private OrcamentoPedidoRepository orcamentoPedidoRepository;

    @Autowired
    private ServicoCustoRepository servicoCustoRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Page<OrcamentoPedidoCustoObraDTO> getAll(int page, int size) {
        return orcamentoPedidoCustoObraRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public OrcamentoPedidoCustoObraDTO getById(Integer id) {
        return orcamentoPedidoCustoObraRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public OrcamentoPedidoCustoObraDTO create(OrcamentoPedidoCustoObraDTO dto) {
        dto.setOrcPedCustoObrId(null);
        OrcamentoPedidoCustoObra entity = toEntity(dto);
        
        LocalDateTime now = LocalDateTime.now();
        entity.setIncluidoEm(now);
        entity.setIncluidoPor(dto.getOrcPedCustoObrIncPor());
        entity.setAlteradoEm(null);
        entity.setAlteradoPor(null);

        OrcamentoPedidoCustoObra saved = orcamentoPedidoCustoObraRepository.save(entity);
        return toDTO(saved);
    }

    public OrcamentoPedidoCustoObraDTO update(OrcamentoPedidoCustoObraDTO dto) {
        if (dto.getOrcPedCustoObrId() == null || !orcamentoPedidoCustoObraRepository.existsById(dto.getOrcPedCustoObrId())) {
            return null;
        }
        OrcamentoPedidoCustoObra entity = toEntity(dto);
        
        OrcamentoPedidoCustoObra existing = orcamentoPedidoCustoObraRepository.findById(dto.getOrcPedCustoObrId()).orElse(null);
        if (existing != null) {
            entity.setIncluidoEm(existing.getIncluidoEm());
            entity.setIncluidoPor(existing.getIncluidoPor());
        }

        LocalDateTime now = LocalDateTime.now();
        entity.setAlteradoEm(now);
        entity.setAlteradoPor(dto.getOrcPedCustoObrAltPor());

        OrcamentoPedidoCustoObra saved = orcamentoPedidoCustoObraRepository.save(entity);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        orcamentoPedidoCustoObraRepository.deleteById(id);
    }

    private OrcamentoPedidoCustoObraDTO toDTO(OrcamentoPedidoCustoObra entity) {
        OrcamentoPedidoCustoObraDTO dto = new OrcamentoPedidoCustoObraDTO();
        dto.setOrcPedCustoObrId(entity.getId());
        
        if (entity.getOrcamentoPedido() != null) {
            dto.setOrcPedId(entity.getOrcamentoPedido().getOrcPedId());
        }
        
        if (entity.getServicoCusto() != null) {
            dto.setSerCustoId(entity.getServicoCusto().getSerCustoId());
        }
        
        if (entity.getUnidade() != null) {
            dto.setUniId(entity.getUnidade().getUniId());
        }
        
        dto.setOrcPedCustoObrQtd(entity.getQuantidade());
        dto.setOrcPedCustoObrVlrUnit(entity.getValorUnitario());
        dto.setOrcPedCustoObrPron(entity.getPrazo());
        dto.setOrcPedCustoObrFaze(entity.getFase());
        dto.setOrcPedCustoObrSitua(entity.getSituacao());
        dto.setOrcPedCustoObrTipo(entity.getTipo());
        dto.setOrcPedCustoObrIncPor(entity.getIncluidoPor());
        dto.setOrcPedCustoObrIncEm(entity.getIncluidoEm());
        dto.setOrcPedCustoObrAltPor(entity.getAlteradoPor());
        dto.setOrcPedCustoObrAltEm(entity.getAlteradoEm());
        return dto;
    }

    private OrcamentoPedidoCustoObra toEntity(OrcamentoPedidoCustoObraDTO dto) {
        OrcamentoPedidoCustoObra entity = new OrcamentoPedidoCustoObra();
        entity.setId(dto.getOrcPedCustoObrId());
        
        if (dto.getOrcPedId() != null) {
            orcamentoPedidoRepository.findById(dto.getOrcPedId())
                .ifPresent(entity::setOrcamentoPedido);
        }
        
        if (dto.getSerCustoId() != null) {
            servicoCustoRepository.findById(dto.getSerCustoId())
                .ifPresent(entity::setServicoCusto);
        }
        
        if (dto.getUniId() != null) {
            unidadeRepository.findById(dto.getUniId())
                .ifPresent(entity::setUnidade);
        }
        
        entity.setQuantidade(dto.getOrcPedCustoObrQtd());
        entity.setValorUnitario(dto.getOrcPedCustoObrVlrUnit());
        entity.setPrazo(dto.getOrcPedCustoObrPron());
        entity.setFase(dto.getOrcPedCustoObrFaze());
        entity.setSituacao(dto.getOrcPedCustoObrSitua());
        entity.setTipo(dto.getOrcPedCustoObrTipo());
        entity.setIncluidoPor(dto.getOrcPedCustoObrIncPor());
        entity.setIncluidoEm(dto.getOrcPedCustoObrIncEm());
        entity.setAlteradoPor(dto.getOrcPedCustoObrAltPor());
        entity.setAlteradoEm(dto.getOrcPedCustoObrAltEm());
        return entity;
    }
}
