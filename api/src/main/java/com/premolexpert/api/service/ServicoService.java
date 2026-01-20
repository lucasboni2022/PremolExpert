package com.premolexpert.api.service;

import com.premolexpert.api.dto.ServicoDTO;
import com.premolexpert.api.entity.Servico;
import com.premolexpert.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    private ServicoDTO toDTO(Servico servico) {
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setSerId(servico.getSerId());
        servicoDTO.setSerDesc(servico.getSerDesc());
        servicoDTO.setSerFabricacao(servico.getSerFabricacao());
        servicoDTO.setSerSessaoLargura(servico.getSerSessaoLargura());
        servicoDTO.setSerSessaoComprimento(servico.getSerSessaoComprimento());
        servicoDTO.setSerSessaoAltura(servico.getSerSessaoAltura());
        servicoDTO.setEmpId(servico.getEmpId());
        servicoDTO.setSerIncEm(servico.getSerIncEm());
        servicoDTO.setSerIncPor(servico.getSerIncPor());
        servicoDTO.setSerAltEm(servico.getSerAltEm());
        servicoDTO.setSerAltPor(servico.getSerAltPor());
        return servicoDTO;
    }

    private Servico toEntity(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        servico.setSerId(servicoDTO.getSerId());
        servico.setSerDesc(servicoDTO.getSerDesc());
        servico.setSerFabricacao(servicoDTO.getSerFabricacao());
        servico.setSerSessaoLargura(servicoDTO.getSerSessaoLargura());
        servico.setSerSessaoComprimento(servicoDTO.getSerSessaoComprimento());
        servico.setSerSessaoAltura(servicoDTO.getSerSessaoAltura());
        servico.setEmpId(servicoDTO.getEmpId());
        servico.setSerIncEm(servicoDTO.getSerIncEm());
        servico.setSerIncPor(servicoDTO.getSerIncPor());
        servico.setSerAltEm(servicoDTO.getSerAltEm());
        servico.setSerAltPor(servicoDTO.getSerAltPor());
        return servico;
    }

    public Page<ServicoDTO> getAll(int page, int size) {
        Page<Servico> servicos = servicoRepository.findAll(PageRequest.of(page, size));
        return servicos.map(this::toDTO);
    }

    public ServicoDTO getById(Integer id) {
        return servicoRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ServicoDTO create(ServicoDTO servicoDTO) {
        servicoDTO.setSerId(null);
        Servico servico = toEntity(servicoDTO);
        
        //Valor Padrão auditoria
        servico.setSerIncPor(null);
        servico.setSerIncEm(LocalDateTime.now());
        servico.setSerAltPor(null);
        servico.setSerAltEm(null);
        
        Servico saved = servicoRepository.save(servico);
        return toDTO(saved);
    }

    public ServicoDTO update(ServicoDTO servicoDTO) {
        // Verifica se existe antes de atualizar (opcional, mas recomendado)
        if (servicoDTO.getSerId() != null && servicoRepository.existsById(servicoDTO.getSerId())) {
            Servico servico = toEntity(servicoDTO);
            servico.setSerAltPor(null);
            servico.setSerAltEm(LocalDateTime.now());
            Servico saved = servicoRepository.save(servico);
            return toDTO(saved);
        }
        return null; // Ou lançar exceção
    }

    public void delete(Integer id) {
        servicoRepository.deleteById(id);
    }
}
