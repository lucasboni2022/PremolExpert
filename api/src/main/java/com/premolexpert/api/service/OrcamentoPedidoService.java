package com.premolexpert.api.service;

import com.premolexpert.api.dto.OrcamentoPedidoDTO;
import com.premolexpert.api.dto.OrcamentoPedidoEtapaDTO;
import com.premolexpert.api.entity.OrcamentoPedido;
import com.premolexpert.api.enumeration.OrcPedEtapEnum;
import com.premolexpert.api.repository.OrcamentoPedidoRepository;
import com.premolexpert.api.repository.ClienteRepository;
import com.premolexpert.api.repository.UsuarioRepository;
import com.premolexpert.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrcamentoPedidoService {

    @Autowired
    private OrcamentoPedidoRepository orcamentoPedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Page<OrcamentoPedidoDTO> getAll(int page, int size) {
        return orcamentoPedidoRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public OrcamentoPedidoDTO getById(Integer id) {
        return orcamentoPedidoRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public OrcamentoPedidoDTO create(OrcamentoPedidoDTO orcamentoPedidoDTO) {
        orcamentoPedidoDTO.setOrcPedId(null);
        OrcamentoPedido orcamentoPedido = toEntity(orcamentoPedidoDTO);
        
        LocalDateTime now = LocalDateTime.now();
        orcamentoPedido.setOrcPedIncEm(now);
        orcamentoPedido.setOrcPedIncPor(orcamentoPedidoDTO.getOrcPedIncPor());
        orcamentoPedido.setOrcPedAltEm(null);
        orcamentoPedido.setOrcPedAltPor(null);

        OrcamentoPedido saved = orcamentoPedidoRepository.save(orcamentoPedido);
        return toDTO(saved);
    }

    public OrcamentoPedidoDTO update(OrcamentoPedidoDTO orcamentoPedidoDTO) {
        if (orcamentoPedidoDTO.getOrcPedId() == null || !orcamentoPedidoRepository.existsById(orcamentoPedidoDTO.getOrcPedId())) {
            return null;
        }
        OrcamentoPedido orcamentoPedido = toEntity(orcamentoPedidoDTO);

        LocalDateTime now = LocalDateTime.now();
        orcamentoPedido.setOrcPedAltEm(now);
        orcamentoPedido.setOrcPedAltPor(orcamentoPedidoDTO.getOrcPedAltPor());

        OrcamentoPedido saved = orcamentoPedidoRepository.save(orcamentoPedido);
        return toDTO(saved);
    }

    public OrcamentoPedidoDTO updateEtapa(OrcamentoPedidoDTO orcamentoPedidoDTO) {
        if (orcamentoPedidoDTO.getOrcPedId() == null || !orcamentoPedidoRepository.existsById(orcamentoPedidoDTO.getOrcPedId())) {
            return null;
        }
        OrcamentoPedido orcamentoPedido = toEntity(orcamentoPedidoDTO);
        orcamentoPedido.setOrcPedEtapa(orcamentoPedidoDTO.getOrcPedEtapa());

        OrcamentoPedido saved = orcamentoPedidoRepository.save(orcamentoPedido);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        orcamentoPedidoRepository.deleteById(id);
    }

    public void updateEtapa(OrcamentoPedidoEtapaDTO dto) {
        if (dto.getOrcPedEtapa() != null && 
            dto.getOrcPedEtapa() >= 0 && 
            dto.getOrcPedEtapa() < OrcPedEtapEnum.values().length) {
            
            OrcPedEtapEnum etapa = OrcPedEtapEnum.values()[dto.getOrcPedEtapa()];
            orcamentoPedidoRepository.updateEtapa(dto.getOrcPedId(), etapa, dto.getOrcPedAltPor(), LocalDateTime.now());
        }
    }

    private OrcamentoPedidoDTO toDTO(OrcamentoPedido orcamentoPedido) {
        OrcamentoPedidoDTO orcamentoPedidoDTO = new OrcamentoPedidoDTO();
        orcamentoPedidoDTO.setOrcPedId(orcamentoPedido.getOrcPedId());
        orcamentoPedidoDTO.setOrcPedNumPro(orcamentoPedido.getOrcPedNumPro());
        orcamentoPedidoDTO.setCliId(orcamentoPedido.getCliId());
        orcamentoPedidoDTO.setOrcPedNomObr(orcamentoPedido.getOrcPedNomObr());
        orcamentoPedidoDTO.setOrcPedDatSol(orcamentoPedido.getOrcPedDatSol());
        orcamentoPedidoDTO.setOrcPedDtaPrevEnt(orcamentoPedido.getOrcPedDtaPrevEnt());
        orcamentoPedidoDTO.setOrcPedDimTam(orcamentoPedido.getOrcPedDimTam());
        orcamentoPedidoDTO.setUsuId(orcamentoPedido.getUsuId());
        orcamentoPedidoDTO.setOrcPedEtapa(orcamentoPedido.getOrcPedEtapa() != null ? orcamentoPedido.getOrcPedEtapa() : null);
        orcamentoPedidoDTO.setOrcPedValOrc(orcamentoPedido.getOrcPedValOrc());
        orcamentoPedidoDTO.setOrcPedDatEntPro(orcamentoPedido.getOrcPedDatEntPro());
        orcamentoPedidoDTO.setOrcPedQtdDiaResEnt(orcamentoPedido.getOrcPedQtdDiaResEnt());
        orcamentoPedidoDTO.setOrcPedValPed(orcamentoPedido.getOrcPedValPed());
        orcamentoPedidoDTO.setOrcPedSalNeg(orcamentoPedido.getOrcPedSalNeg());
        orcamentoPedidoDTO.setOrcPedPesOrc(orcamentoPedido.getOrcPedPesOrc());
        orcamentoPedidoDTO.setOrcPedPesExe(orcamentoPedido.getOrcPedPesExe());
        orcamentoPedidoDTO.setOrcPedSalPes(orcamentoPedido.getOrcPedSalPes());
        orcamentoPedidoDTO.setEmpId(orcamentoPedido.getEmpId());
        orcamentoPedidoDTO.setOrcPedPaiId(orcamentoPedido.getOrcPedPaiId());
        orcamentoPedidoDTO.setOrcPedIncPor(orcamentoPedido.getOrcPedIncPor());
        orcamentoPedidoDTO.setOrcPedIncEm(orcamentoPedido.getOrcPedIncEm());
        orcamentoPedidoDTO.setOrcPedAltPor(orcamentoPedido.getOrcPedAltPor());
        orcamentoPedidoDTO.setOrcPedAltEm(orcamentoPedido.getOrcPedAltEm());
        return orcamentoPedidoDTO;
    }

    private OrcamentoPedido toEntity(OrcamentoPedidoDTO orcamentoPedidoDTO) {
        OrcamentoPedido orcamentoPedido = new OrcamentoPedido();
        orcamentoPedido.setOrcPedId(orcamentoPedidoDTO.getOrcPedId());
        orcamentoPedido.setOrcPedNumPro(orcamentoPedidoDTO.getOrcPedNumPro());
        
        if (orcamentoPedidoDTO.getCliId() != null) {
            clienteRepository.findById(orcamentoPedidoDTO.getCliId())
                .ifPresent(orcamentoPedido::setCliente);
        }
        
        orcamentoPedido.setOrcPedNomObr(orcamentoPedidoDTO.getOrcPedNomObr());
        orcamentoPedido.setOrcPedDatSol(orcamentoPedidoDTO.getOrcPedDatSol());
        orcamentoPedido.setOrcPedDtaPrevEnt(orcamentoPedidoDTO.getOrcPedDtaPrevEnt());
        orcamentoPedido.setOrcPedDimTam(orcamentoPedidoDTO.getOrcPedDimTam());
        
        if (orcamentoPedidoDTO.getUsuId() != null) {
            usuarioRepository.findById(orcamentoPedidoDTO.getUsuId())
                .ifPresent(orcamentoPedido::setUsuario);
        }
        
        orcamentoPedido.setOrcPedEtapa(orcamentoPedidoDTO.getOrcPedEtapa());
        orcamentoPedido.setOrcPedValOrc(orcamentoPedidoDTO.getOrcPedValOrc());
        orcamentoPedido.setOrcPedDatEntPro(orcamentoPedidoDTO.getOrcPedDatEntPro());
        orcamentoPedido.setOrcPedQtdDiaResEnt(orcamentoPedidoDTO.getOrcPedQtdDiaResEnt());
        orcamentoPedido.setOrcPedValPed(orcamentoPedidoDTO.getOrcPedValPed());
        orcamentoPedido.setOrcPedSalNeg(orcamentoPedidoDTO.getOrcPedSalNeg());
        orcamentoPedido.setOrcPedPesOrc(orcamentoPedidoDTO.getOrcPedPesOrc());
        orcamentoPedido.setOrcPedPesExe(orcamentoPedidoDTO.getOrcPedPesExe());
        orcamentoPedido.setOrcPedSalPes(orcamentoPedidoDTO.getOrcPedSalPes());
        
        if (orcamentoPedidoDTO.getEmpId() != null) {
            empresaRepository.findById(orcamentoPedidoDTO.getEmpId())
                .ifPresent(orcamentoPedido::setEmpresa);
        }
        
        if (orcamentoPedidoDTO.getOrcPedPaiId() != null) {
            orcamentoPedidoRepository.findById(orcamentoPedidoDTO.getOrcPedPaiId())
                .ifPresent(orcamentoPedido::setOrcamentoPedidoPai);
        }
        
        orcamentoPedido.setOrcPedIncPor(orcamentoPedidoDTO.getOrcPedIncPor());
        orcamentoPedido.setOrcPedIncEm(orcamentoPedidoDTO.getOrcPedIncEm());
        orcamentoPedido.setOrcPedAltPor(orcamentoPedidoDTO.getOrcPedAltPor());
        orcamentoPedido.setOrcPedAltEm(orcamentoPedidoDTO.getOrcPedAltEm());
        return orcamentoPedido;
    }
}
