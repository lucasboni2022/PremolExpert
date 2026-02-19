package com.premolexpert.api.service;

import com.premolexpert.api.dto.ClienteDTO;
import com.premolexpert.api.entity.Cliente;
import com.premolexpert.api.entity.Pessoa;
import com.premolexpert.api.repository.ClienteRepository;
import com.premolexpert.api.repository.EmpresaRepository;
import com.premolexpert.api.repository.MunicipioRepository;
import com.premolexpert.api.repository.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        Pessoa pessoa = cliente.getPessoa();

        // Pessoa fields
        if (pessoa != null) {
            dto.setPesId(pessoa.getPesId());
            dto.setPesNom(pessoa.getPesNom());
            dto.setPesCpf(pessoa.getPesCpf());
            dto.setPesCnpj(pessoa.getPesCnpj());
            dto.setPesEmail(pessoa.getPesEmail());
            dto.setPesEnd(pessoa.getPesEnd());
            
            if (pessoa.getMunicipio() != null) {
                dto.setMunId(pessoa.getMunicipio().getMunId());
            }
            
            if (pessoa.getEmpresa() != null) {
                dto.setEmpId(pessoa.getEmpresa().getEmpId());
            }

            dto.setPesFisJur(pessoa.getPesFisJur());
            dto.setPesTelPesDDD(pessoa.getPesTelPesDDD());
            dto.setPesTelPes(pessoa.getPesTelPes());
            dto.setPesTelComDDD(pessoa.getPesTelComDDD());
            dto.setPesTelCom(pessoa.getPesTelCom());
            dto.setPesCelPesDDD(pessoa.getPesCelPesDDD());
            dto.setPesCelPes(pessoa.getPesCelPes());
            dto.setPesCelComDDD(pessoa.getPesCelComDDD());
            dto.setPesCelComPes(pessoa.getPesCelComPes());
            dto.setPesIncPor(pessoa.getPesIncPor());
            dto.setPesIncEm(pessoa.getPesIncEm());
            dto.setPesAltPor(pessoa.getPesAltPor());
            dto.setPesAltEm(pessoa.getPesAltEm());
        } else {
            // Fallback if pessoa is null - access via pessoa relationship
            Pessoa fallbackPessoa = cliente.getPessoa();
            if (fallbackPessoa != null) {
                dto.setPesId(fallbackPessoa.getPesId());
            }
        }

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
        Pessoa pessoa = new Pessoa();
        cliente.setPessoa(pessoa);

        // Set IDs
        if (dto.getPesId() != null) {
            pessoa.setPesId(dto.getPesId());
        }

        // Pessoa fields
        pessoa.setPesNom(dto.getPesNom());
        pessoa.setPesCpf(dto.getPesCpf());
        pessoa.setPesCnpj(dto.getPesCnpj());
        pessoa.setPesEmail(dto.getPesEmail());
        pessoa.setPesEnd(dto.getPesEnd());
        
        if (dto.getMunId() != null) {
            municipioRepository.findById(dto.getMunId())
                .ifPresent(pessoa::setMunicipio);
        }
        
        if (dto.getEmpId() != null) {
            empresaRepository.findById(dto.getEmpId())
                .ifPresent(pessoa::setEmpresa);
        }

        pessoa.setPesFisJur(dto.getPesFisJur());
        pessoa.setPesTelPesDDD(dto.getPesTelPesDDD());
        pessoa.setPesTelPes(dto.getPesTelPes());
        pessoa.setPesTelComDDD(dto.getPesTelComDDD());
        pessoa.setPesTelCom(dto.getPesTelCom());
        pessoa.setPesCelPesDDD(dto.getPesCelPesDDD());
        pessoa.setPesCelPes(dto.getPesCelPes());
        pessoa.setPesCelComDDD(dto.getPesCelComDDD());
        pessoa.setPesCelComPes(dto.getPesCelComPes());
        pessoa.setPesIncPor(dto.getPesIncPor());
        pessoa.setPesIncEm(dto.getPesIncEm());
        pessoa.setPesAltPor(dto.getPesAltPor());
        pessoa.setPesAltEm(dto.getPesAltEm());

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
        // If ID passed is CLIID, we use findById
        // But users likely query by PESID? Or CLIID?
        // Assuming CLIID for getById as it's the PK.
        return clienteRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ClienteDTO create(ClienteDTO dto) {
        dto.setPesId(null);
        Cliente cliente = toEntity(dto);
        Pessoa pessoa = cliente.getPessoa();
        
        LocalDateTime now = LocalDateTime.now();
        if (pessoa.getPesIncEm() == null) pessoa.setPesIncEm(now);
        if (cliente.getCliIncEm() == null) cliente.setCliIncEm(now);

        // Save Pessoa first to get ID
        pessoa = pessoaRepository.save(pessoa);
        
        // Link ID
        // Note: we don't need to set pessoa object on cliente for save, as pesId column is what matters.
        // But keeping it consistent in object graph is fine.
        
        Cliente saved = clienteRepository.save(cliente);
        saved.setPessoa(pessoa); // Ensure it's available for toDTO
        
        return toDTO(saved);
    }

    public ClienteDTO update(ClienteDTO dto) {
        if (dto.getPesId() != null) {
            return clienteRepository.findByPessoaPesId(dto.getPesId()).map(existing -> {
                Cliente incoming = toEntity(dto);
                Pessoa existingPessoa = existing.getPessoa();
                Pessoa incomingPessoa = incoming.getPessoa();

                // Update Pessoa fields
                existingPessoa.setPesNom(incomingPessoa.getPesNom());
                existingPessoa.setPesCpf(incomingPessoa.getPesCpf());
                existingPessoa.setPesCnpj(incomingPessoa.getPesCnpj());
                existingPessoa.setPesEmail(incomingPessoa.getPesEmail());
                existingPessoa.setPesEnd(incomingPessoa.getPesEnd());
                existingPessoa.setMunicipio(incomingPessoa.getMunicipio());
                existingPessoa.setEmpresa(incomingPessoa.getEmpresa());
                existingPessoa.setPesFisJur(incomingPessoa.getPesFisJur());
                // ... update other phones ...
                existingPessoa.setPesTelPesDDD(incomingPessoa.getPesTelPesDDD());
                existingPessoa.setPesTelPes(incomingPessoa.getPesTelPes());
                existingPessoa.setPesTelComDDD(incomingPessoa.getPesTelComDDD());
                existingPessoa.setPesTelCom(incomingPessoa.getPesTelCom());
                existingPessoa.setPesCelPesDDD(incomingPessoa.getPesCelPesDDD());
                existingPessoa.setPesCelPes(incomingPessoa.getPesCelPes());
                existingPessoa.setPesCelComDDD(incomingPessoa.getPesCelComDDD());
                existingPessoa.setPesCelComPes(incomingPessoa.getPesCelComPes());
                
                existingPessoa.setPesAltPor(incomingPessoa.getPesAltPor());
                
                LocalDateTime now = LocalDateTime.now();
                existingPessoa.setPesAltEm(now);
                
                // Save Pessoa
                pessoaRepository.save(existingPessoa);
                
                // Update Cliente fields
                existing.setCliObs(incoming.getCliObs());
                existing.setCliAltPor(incoming.getCliAltPor());
                existing.setCliAltEm(now);
                
                // Save Cliente
                Cliente saved = clienteRepository.save(existing);
                return toDTO(saved);
            }).orElse(null);
        }
        return null;
    }

    public void delete(Integer id) {
        // ID is CliId
        clienteRepository.findById(id).ifPresent(cliente -> {
             // Cascade delete of Pessoa?
             // Since relationship is insertable=false, CascadeType.ALL on Cliente might try to delete Pessoa.
             // But if we delete Cliente, we might want to delete Pessoa too if they are strictly 1:1.
             // If we rely on CascadeType.ALL in entity, deleting cliente should delete pessoa.
             // But let's verify if 'insertable=false' affects cascade remove. It shouldn't.
             clienteRepository.deleteById(id);
        });
    }
}
