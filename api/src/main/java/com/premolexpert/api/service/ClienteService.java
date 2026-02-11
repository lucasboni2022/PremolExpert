package com.premolexpert.api.service;

import com.premolexpert.api.dto.ClienteDTO;
import com.premolexpert.api.entity.Cliente;
import com.premolexpert.api.repository.ClienteRepository;
import com.premolexpert.api.repository.EmpresaRepository;
import com.premolexpert.api.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();

        // Pessoa fields
        dto.setPesId(cliente.getCliId());
        dto.setPesNom(cliente.getPesNom());
        dto.setPesCpf(cliente.getPesCpf());
        dto.setPesCnpj(cliente.getPesCnpj());
        dto.setPesEmail(cliente.getPesEmail());
        dto.setPesEnd(cliente.getPesEnd());
        
        if (cliente.getMunicipio() != null) {
            dto.setMunId(cliente.getMunicipio().getMunId());
        }
        
        if (cliente.getEmpresa() != null) {
            dto.setEmpId(cliente.getEmpresa().getEmpId());
        }

        dto.setPesFisJur(cliente.getPesFisJur());
        dto.setPesTelPesDDD(cliente.getPesTelPesDDD());
        dto.setPesTelPes(cliente.getPesTelPes());
        dto.setPesTelComDDD(cliente.getPesTelComDDD());
        dto.setPesTelCom(cliente.getPesTelCom());
        dto.setPesCelPesDDD(cliente.getPesCelPesDDD());
        dto.setPesCelPes(cliente.getPesCelPes());
        dto.setPesCelComDDD(cliente.getPesCelComDDD());
        dto.setPesCelComPes(cliente.getPesCelComPes());
        dto.setPesIncPor(cliente.getPesIncPor());
        dto.setPesIncEm(cliente.getPesIncEm());
        dto.setPesAltPor(cliente.getPesAltPor());
        dto.setPesAltEm(cliente.getPesAltEm());

        // Cliente fields
        dto.setCliObs(cliente.getCliObs());
        dto.setCliIncPor(cliente.getCliIncPor());
        dto.setCliIncEm(cliente.getCliIncEm());
        dto.setCliAltPor(cliente.getCliAltPor());
        dto.setCliAltEm(cliente.getCliAltEm());

        return dto;
    }

    private Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();

        // Pessoa fields
        cliente.setCliId(dto.getPesId());
        cliente.setPesNom(dto.getPesNom());
        cliente.setPesCpf(dto.getPesCpf());
        cliente.setPesCnpj(dto.getPesCnpj());
        cliente.setPesEmail(dto.getPesEmail());
        cliente.setPesEnd(dto.getPesEnd());
        
        if (dto.getMunId() != null) {
            municipioRepository.findById(dto.getMunId())
                .ifPresent(cliente::setMunicipio);
        }
        
        if (dto.getEmpId() != null) {
            empresaRepository.findById(dto.getEmpId())
                .ifPresent(cliente::setEmpresa);
        }

        cliente.setPesFisJur(dto.getPesFisJur());
        cliente.setPesTelPesDDD(dto.getPesTelPesDDD());
        cliente.setPesTelPes(dto.getPesTelPes());
        cliente.setPesTelComDDD(dto.getPesTelComDDD());
        cliente.setPesTelCom(dto.getPesTelCom());
        cliente.setPesCelPesDDD(dto.getPesCelPesDDD());
        cliente.setPesCelPes(dto.getPesCelPes());
        cliente.setPesCelComDDD(dto.getPesCelComDDD());
        cliente.setPesCelComPes(dto.getPesCelComPes());
        cliente.setPesIncPor(dto.getPesIncPor());
        cliente.setPesIncEm(dto.getPesIncEm());
        cliente.setPesAltPor(dto.getPesAltPor());
        cliente.setPesAltEm(dto.getPesAltEm());

        // Cliente fields
        cliente.setCliObs(dto.getCliObs());
        cliente.setCliIncPor(dto.getCliIncPor());
        cliente.setCliIncEm(dto.getCliIncEm());
        cliente.setCliAltPor(dto.getCliAltPor());
        cliente.setCliAltEm(dto.getCliAltEm());

        return cliente;
    }

    public Page<ClienteDTO> getAll(int page, int size) {
        return clienteRepository.findAll(PageRequest.of(page, size))
                .map(this::toDTO);
    }

    public ClienteDTO getById(Integer id) {
        return clienteRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ClienteDTO create(ClienteDTO dto) {
        dto.setPesId(null);
        Cliente cliente = toEntity(dto);
        
        LocalDateTime now = LocalDateTime.now();
        if (cliente.getPesIncEm() == null) cliente.setPesIncEm(now);
        if (cliente.getCliIncEm() == null) cliente.setCliIncEm(now);

        Cliente saved = clienteRepository.save(cliente);
        return toDTO(saved);
    }

    public ClienteDTO update(ClienteDTO dto) {
        if (dto.getPesId() != null && clienteRepository.existsById(dto.getPesId())) {
            Cliente cliente = toEntity(dto);
            
            clienteRepository.findById(dto.getPesId()).ifPresent(existing -> {
                if (cliente.getPesIncEm() == null) cliente.setPesIncEm(existing.getPesIncEm());
                if (cliente.getCliIncEm() == null) cliente.setCliIncEm(existing.getCliIncEm());
            });

            LocalDateTime now = LocalDateTime.now();
            cliente.setPesAltEm(now);
            cliente.setCliAltEm(now);
            
            Cliente saved = clienteRepository.save(cliente);
            return toDTO(saved);
        }
        return null;
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
