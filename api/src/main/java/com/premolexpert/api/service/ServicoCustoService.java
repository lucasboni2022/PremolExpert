package com.premolexpert.api.service;

import com.premolexpert.api.dto.ServicoCustoDTO;
import com.premolexpert.api.entity.ServicoCusto;
import com.premolexpert.api.repository.ServicoCustoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicoCustoService {

    @Autowired
    private ServicoCustoRepository servicoCustoRepository;

    private ServicoCustoDTO toDTO(ServicoCusto servicoCusto) {
        ServicoCustoDTO servicoCustoDTO = new ServicoCustoDTO();
        servicoCustoDTO.setSerCustoId(servicoCusto.getSerCustoId());
        servicoCustoDTO.setSerId(servicoCusto.getSerId());
        servicoCustoDTO.setSerCustoNom(servicoCusto.getSerCustoNom());
        servicoCustoDTO.setSerCustoCod(servicoCusto.getSerCustoCod());
        servicoCustoDTO.setSerCustoUni(servicoCusto.getSerCustoUni());
        servicoCustoDTO.setSerCustoVlrUnit(servicoCusto.getSerCustoVlrUnit());
        servicoCustoDTO.setSerCustoSta(servicoCusto.getSerCustoSta());
        servicoCustoDTO.setSerCustoIncEm(servicoCusto.getSerCustoIncEm());
        servicoCustoDTO.setSerCustoIncPor(servicoCusto.getSerCustoIncPor());
        servicoCustoDTO.setSerCustoAltEm(servicoCusto.getSerCustoAltEm());
        servicoCustoDTO.setSerCustoAltPor(servicoCusto.getSerCustoAltPor());
        return servicoCustoDTO;
    }

    private ServicoCusto toEntity(ServicoCustoDTO servicoCustoDTO) {
        ServicoCusto servicoCusto = new ServicoCusto();
        servicoCusto.setSerCustoId(servicoCustoDTO.getSerCustoId());
        servicoCusto.setSerId(servicoCustoDTO.getSerId());
        servicoCusto.setSerCustoNom(servicoCustoDTO.getSerCustoNom());
        servicoCusto.setSerCustoCod(servicoCustoDTO.getSerCustoCod());
        servicoCusto.setSerCustoUni(servicoCustoDTO.getSerCustoUni());
        servicoCusto.setSerCustoVlrUnit(servicoCustoDTO.getSerCustoVlrUnit());
        servicoCusto.setSerCustoSta(servicoCustoDTO.getSerCustoSta());
        servicoCusto.setSerCustoIncEm(servicoCustoDTO.getSerCustoIncEm());
        servicoCusto.setSerCustoIncPor(servicoCustoDTO.getSerCustoIncPor());
        servicoCusto.setSerCustoAltEm(servicoCustoDTO.getSerCustoAltEm());
        servicoCusto.setSerCustoAltPor(servicoCustoDTO.getSerCustoAltPor());
        return servicoCusto;
    }

    public Page<ServicoCustoDTO> getAll(int page, int size) {
        Page<ServicoCusto> list = servicoCustoRepository.findAll(PageRequest.of(page, size));
        return list.map(this::toDTO);
    }

    public ServicoCustoDTO getById(Integer id) {
        return servicoCustoRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ServicoCustoDTO create(ServicoCustoDTO servicoCustoDTO) {
        servicoCustoDTO.setSerCustoId(null);
        ServicoCusto servicoCusto = toEntity(servicoCustoDTO);

        //Valor Padrão auditoria
        servicoCusto.setSerCustoIncPor(null);
        servicoCusto.setSerCustoIncEm(LocalDateTime.now());
        servicoCusto.setSerCustoAltPor(null);
        servicoCusto.setSerCustoAltEm(null);

        ServicoCusto saved = servicoCustoRepository.save(servicoCusto);
        return toDTO(saved);
    }

    public ServicoCustoDTO update(ServicoCustoDTO servicoCustoDTO) {
        // Verifica se existe antes de atualizar (opcional, mas recomendado)
        if (servicoCustoDTO.getSerCustoId() != null && servicoCustoRepository.existsById(servicoCustoDTO.getSerCustoId())) {
            ServicoCusto servicoCusto = toEntity(servicoCustoDTO);
            servicoCusto.setSerCustoAltPor(null);
            servicoCusto.setSerCustoAltEm(LocalDateTime.now());
            ServicoCusto saved = servicoCustoRepository.save(servicoCusto);
            return toDTO(saved);
        }
        return null; // Ou lançar exceção
    }

    public void delete(Integer id) {
        servicoCustoRepository.deleteById(id);
    }
}
