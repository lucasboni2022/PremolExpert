package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoCustoObraEngProDTO;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObraEng;
import com.premolexpert.api.entity.OrcamentoPedidoCustoObraEngPro;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraEngProRepository;
import com.premolexpert.api.repository.OrcamentoPedidoCustoObraEngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrcamentoPedidoCustoObraEngProService {

    @Autowired
    private OrcamentoPedidoCustoObraEngProRepository orcamentoPedidoCustoObraEngProRepository;

    @Autowired
    private OrcamentoPedidoCustoObraEngRepository orcamentoPedidoCustoObraEngRepository;

    @Transactional(readOnly = true)
    public Page<OrcamentoPedidoCustoObraEngProDTO> getAll(int page, int size) {
        return orcamentoPedidoCustoObraEngProRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    @Transactional(readOnly = true)
    public Optional<OrcamentoPedidoCustoObraEngProDTO> getById(Integer id) {
        return orcamentoPedidoCustoObraEngProRepository.findById(id).map(this::toDTO);
    }

    @Transactional
    public OrcamentoPedidoCustoObraEngProDTO create(OrcamentoPedidoCustoObraEngProDTO orcamentoPedidoCustoObraEngProDTO) {
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProId(null);
        OrcamentoPedidoCustoObraEngPro orcamentoPedidoCustoObraEngPro = toEntity(orcamentoPedidoCustoObraEngProDTO);
        
        LocalDateTime now = LocalDateTime.now();
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProIncEm(now);
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProIncPor(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProIncPor());
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProAltEm(null);
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProAltPor(null);

        OrcamentoPedidoCustoObraEngPro saved = orcamentoPedidoCustoObraEngProRepository.save(orcamentoPedidoCustoObraEngPro);
        return toDTO(saved);
    }

    @Transactional
    public Optional<OrcamentoPedidoCustoObraEngProDTO> update(Integer id, OrcamentoPedidoCustoObraEngProDTO orcamentoPedidoCustoObraEngProDTO) {
        return orcamentoPedidoCustoObraEngProRepository.findById(id).map(existing -> {
            OrcamentoPedidoCustoObraEngPro orcamentoPedidoCustoObraEngPro = toEntity(orcamentoPedidoCustoObraEngProDTO);
            orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProId(existing.getOrcPedCustoObrEngProId());
            orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProIncEm(existing.getOrcPedCustoObrEngProIncEm());
            orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProIncPor(existing.getOrcPedCustoObrEngProIncPor());
            
            LocalDateTime now = LocalDateTime.now();
            orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProAltEm(now);
            orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProAltPor(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProAltPor());

            OrcamentoPedidoCustoObraEngPro saved = orcamentoPedidoCustoObraEngProRepository.save(orcamentoPedidoCustoObraEngPro);
            return toDTO(saved);
        });
    }

    @Transactional
    public boolean delete(Integer id) {
        if (orcamentoPedidoCustoObraEngProRepository.existsById(id)) {
            orcamentoPedidoCustoObraEngProRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private OrcamentoPedidoCustoObraEngPro toEntity(OrcamentoPedidoCustoObraEngProDTO orcamentoPedidoCustoObraEngProDTO) {
        OrcamentoPedidoCustoObraEngPro orcamentoPedidoCustoObraEngPro = new OrcamentoPedidoCustoObraEngPro();
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProId(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProId());
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProProduto(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProProduto());
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProQtd(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProQtd());
        
        if (orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngId() != null) {
            OrcamentoPedidoCustoObraEng orcPedCustoObrEng = orcamentoPedidoCustoObraEngRepository.findById(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngId()).orElse(null);
            orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEng(orcPedCustoObrEng);
        }

        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProIncPor(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProIncPor());
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProIncEm(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProIncEm());
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProAltPor(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProAltPor());
        orcamentoPedidoCustoObraEngPro.setOrcPedCustoObrEngProAltEm(orcamentoPedidoCustoObraEngProDTO.getOrcPedCustoObrEngProAltEm());
        
        return orcamentoPedidoCustoObraEngPro;
    }

    private OrcamentoPedidoCustoObraEngProDTO toDTO(OrcamentoPedidoCustoObraEngPro orcamentoPedidoCustoObraEngPro) {
        OrcamentoPedidoCustoObraEngProDTO orcamentoPedidoCustoObraEngProDTO = new OrcamentoPedidoCustoObraEngProDTO();
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProId(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProId());
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProProduto(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProProduto());
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProQtd(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProQtd());
        
        if (orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEng() != null) {
            orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngId(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEng().getOrcPedCustoObrEngId());
        }

        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProIncPor(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProIncPor());
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProIncEm(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProIncEm());
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProAltPor(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProAltPor());
        orcamentoPedidoCustoObraEngProDTO.setOrcPedCustoObrEngProAltEm(orcamentoPedidoCustoObraEngPro.getOrcPedCustoObrEngProAltEm());
        
        return orcamentoPedidoCustoObraEngProDTO;
    }
}
