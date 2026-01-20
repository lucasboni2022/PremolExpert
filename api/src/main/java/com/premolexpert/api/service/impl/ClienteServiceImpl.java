package com.premolexpert.api.service.impl;

import com.premolexpert.api.dto.ClienteDTO;
import com.premolexpert.api.entity.Cliente;
import com.premolexpert.api.repository.ClienteRepository;
import com.premolexpert.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteServiceImpl implements PessoaService<ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        // Pessoa fields
        clienteDTO.setPesId(cliente.getPesId());
        clienteDTO.setPesNom(cliente.getPesNom());
        clienteDTO.setPesCpf(cliente.getPesCpf());
        clienteDTO.setPesCnpj(cliente.getPesCnpj());
        clienteDTO.setPesEmail(cliente.getPesEmail());
        clienteDTO.setPesEnd(cliente.getPesEnd());
        clienteDTO.setMunId(cliente.getMunId());
        clienteDTO.setEmpId(cliente.getEmpId());
        clienteDTO.setPesFisJur(cliente.getPesFisJur());
        clienteDTO.setPesTelPesDDD(cliente.getPesTelPesDDD());
        clienteDTO.setPesTelPes(cliente.getPesTelPes());
        clienteDTO.setPesTelComDDD(cliente.getPesTelComDDD());
        clienteDTO.setPesTelCom(cliente.getPesTelCom());
        clienteDTO.setPesCelPesDDD(cliente.getPesCelPesDDD());
        clienteDTO.setPesCelPes(cliente.getPesCelPes());
        clienteDTO.setPesCelComDDD(cliente.getPesCelComDDD());
        clienteDTO.setPesCelComPes(cliente.getPesCelComPes());
        clienteDTO.setPesIncPor(cliente.getPesIncPor());
        clienteDTO.setPesIncEm(cliente.getPesIncEm());
        clienteDTO.setPesAltPor(cliente.getPesAltPor());
        clienteDTO.setPesAltEm(cliente.getPesAltEm());

        // Cliente fields
        clienteDTO.setCliObs(cliente.getCliObs());
        clienteDTO.setCliIncPor(cliente.getCliIncPor());
        clienteDTO.setCliIncEm(cliente.getCliIncEm());
        clienteDTO.setCliAltPor(cliente.getCliAltPor());
        clienteDTO.setCliAltEm(cliente.getCliAltEm());

        return clienteDTO;
    }

    private Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        // Pessoa fields
        cliente.setPesId(dto.getPesId());
        cliente.setPesNom(dto.getPesNom());
        cliente.setPesCpf(dto.getPesCpf());
        cliente.setPesCnpj(dto.getPesCnpj());
        cliente.setPesEmail(dto.getPesEmail());
        cliente.setPesEnd(dto.getPesEnd());
        cliente.setMunId(dto.getMunId());
        cliente.setEmpId(dto.getEmpId());
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

    @Override
    public Page<ClienteDTO> getAll(int page, int size) {
        Page<Cliente> clientes = clienteRepository.findAll(PageRequest.of(page, size));
        return clientes.map(this::toDTO);
    }

    @Override
    public ClienteDTO getById(Integer id) {
        return clienteRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public ClienteDTO create(ClienteDTO dto) {
        dto.setPesId(null);
        Cliente cliente = toEntity(dto);

        LocalDateTime now = LocalDateTime.now();

        if (cliente.getPesIncEm() == null) cliente.setPesIncEm(now);
        cliente.setPesAltEm(now);

        if (cliente.getCliIncEm() == null) cliente.setCliIncEm(now);
        cliente.setCliAltEm(now);

        Cliente saved = clienteRepository.save(cliente);
        return toDTO(saved);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        if (clienteDTO.getPesId() != null && clienteRepository.existsById(clienteDTO.getPesId())) {
            Cliente cliente = toEntity(clienteDTO);
            LocalDateTime now = LocalDateTime.now();

            clienteRepository.findById(clienteDTO.getPesId()).ifPresent(existing -> {
                if (cliente.getPesIncEm() == null) cliente.setPesIncEm(existing.getPesIncEm());
                if (cliente.getCliIncEm() == null) cliente.setCliIncEm(existing.getCliIncEm());
            });

            cliente.setPesAltEm(now);
            cliente.setCliAltEm(now);

            Cliente saved = clienteRepository.save(cliente);
            return toDTO(saved);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
