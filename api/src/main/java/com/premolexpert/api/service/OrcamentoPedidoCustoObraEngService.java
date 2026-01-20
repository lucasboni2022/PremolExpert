package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraEngDTO;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObra;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObraEng;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraRepository;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraEngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public Optional<OrcamentoPedidoCustoObraEngDTO> getById(Integer id) {
        return orcamentoPedidoCustoObraEngRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    public OrcamentoPedidoCustoObraEngDTO create(OrcamentoPedidoCustoObraEngDTO orcamentoPedidoCustoObraEngDTO) {
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngId(null);
        OrcamentoPedidoCustoObraEng orcamentoPedidoCustoObraEng = toEntity(orcamentoPedidoCustoObraEngDTO);
        
        LocalDateTime now = LocalDateTime.now();
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngIncEm(now);
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngIncPor(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngIncPor());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngAltEm(null);
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngAltPor(null);

        OrcamentoPedidoCustoObraEng saved = orcamentoPedidoCustoObraEngRepository.save(orcamentoPedidoCustoObraEng);
        return toDTO(saved);
    }

    @Transactional
    public Optional<OrcamentoPedidoCustoObraEngDTO> update(Integer id, OrcamentoPedidoCustoObraEngDTO orcamentoPedidoCustoObraEngDTO) {
        return orcamentoPedidoCustoObraEngRepository.findById(id).map(existing -> {
            OrcamentoPedidoCustoObraEng orcamentoPedidoCustoObraEng = toEntity(orcamentoPedidoCustoObraEngDTO);
            orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngId(existing.getOrcPedCustoObrEngId());
            orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngIncEm(existing.getOrcPedCustoObrEngIncEm());
            orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngIncPor(existing.getOrcPedCustoObrEngIncPor());
            
            LocalDateTime now = LocalDateTime.now();
            orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngAltEm(now);
            orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngAltPor(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngAltPor());

            OrcamentoPedidoCustoObraEng saved = orcamentoPedidoCustoObraEngRepository.save(orcamentoPedidoCustoObraEng);
            return toDTO(saved);
        });
    }

    @Transactional
    public boolean delete(Integer id) {
        if (orcamentoPedidoCustoObraEngRepository.existsById(id)) {
            orcamentoPedidoCustoObraEngRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private OrcamentoPedidoCustoObraEng toEntity(OrcamentoPedidoCustoObraEngDTO orcamentoPedidoCustoObraEngDTO) {
        OrcamentoPedidoCustoObraEng orcamentoPedidoCustoObraEng = new OrcamentoPedidoCustoObraEng();
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngId(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngId());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngQtdAFazer(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngQtdAFazer());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngQtdLibParFabr(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngQtdLibParFabr());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngLote(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngLote());
        
        if (orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrId() != null) {
            OrcamentoPedidoCustoObra orcPedCustoObr = orcamentoPedidoCustoObraRepository.findById(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrId()).orElse(null);
            orcamentoPedidoCustoObraEng.setOrcPedCustoObr(orcPedCustoObr);
        }

        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngIncPor(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngIncPor());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngIncEm(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngIncEm());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngAltPor(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngAltPor());
        orcamentoPedidoCustoObraEng.setOrcPedCustoObrEngAltEm(orcamentoPedidoCustoObraEngDTO.getOrcPedCustoObrEngAltEm());
        
        return orcamentoPedidoCustoObraEng;
    }

    private OrcamentoPedidoCustoObraEngDTO toDTO(OrcamentoPedidoCustoObraEng orcamentoPedidoCustoObraEng) {
        OrcamentoPedidoCustoObraEngDTO orcamentoPedidoCustoObraEngDTO = new OrcamentoPedidoCustoObraEngDTO();
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngId(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngId());
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngQtdAFazer(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngQtdAFazer());
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngQtdLibParFabr(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngQtdLibParFabr());
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngLote(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngLote());
        
        if (orcamentoPedidoCustoObraEng.getOrcPedCustoObr() != null) {
            orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrId(orcamentoPedidoCustoObraEng.getOrcPedCustoObr().getOrcPedCustoObrId());
        }

        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngIncPor(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngIncPor());
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngIncEm(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngIncEm());
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngAltPor(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngAltPor());
        orcamentoPedidoCustoObraEngDTO.setOrcPedCustoObrEngAltEm(orcamentoPedidoCustoObraEng.getOrcPedCustoObrEngAltEm());
        
        return orcamentoPedidoCustoObraEngDTO;
    }
}
