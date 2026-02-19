package com.premolexpert.api.service;

import com.premolexpert.api.dto.FuncionarioDTO;
import com.premolexpert.api.entity.Funcionario;
import com.premolexpert.api.entity.Pessoa;
import com.premolexpert.api.repository.EmpresaRepository;
import com.premolexpert.api.repository.FuncionarioRepository;
import com.premolexpert.api.repository.MunicipioRepository;
import com.premolexpert.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        Pessoa pessoa = funcionario.getPessoa();

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
             dto.setPesId(funcionario.getPesId());
        }

        // Funcionario fields
        dto.setFuncioObs(funcionario.getFuncioObs());
        dto.setFuncioIncPor(funcionario.getFuncioIncPor());
        dto.setFuncioIncEm(funcionario.getFuncioIncEm());
        dto.setFuncioAltPor(funcionario.getFuncioAltPor());
        dto.setFuncioAltEm(funcionario.getFuncioAltEm());

        return dto;
    }

    private Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        Pessoa pessoa = new Pessoa();
        funcionario.setPessoa(pessoa);

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

        // Funcionario fields
        funcionario.setFuncioObs(dto.getFuncioObs());
        funcionario.setFuncioIncPor(dto.getFuncioIncPor());
        funcionario.setFuncioIncEm(dto.getFuncioIncEm());
        funcionario.setFuncioAltPor(dto.getFuncioAltPor());
        funcionario.setFuncioAltEm(dto.getFuncioAltEm());

        return funcionario;
    }

    public Page<FuncionarioDTO> getAll(int page, int size) {
        return funcionarioRepository.findAll(PageRequest.of(page, size))
                .map(this::toDTO);
    }

    public FuncionarioDTO getById(Integer id) {
        return funcionarioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public FuncionarioDTO create(FuncionarioDTO dto) {
        dto.setPesId(null);
        Funcionario funcionario = toEntity(dto);
        Pessoa pessoa = funcionario.getPessoa();
        
        LocalDateTime now = LocalDateTime.now();
        if (pessoa.getPesIncEm() == null) pessoa.setPesIncEm(now);
        if (funcionario.getFuncioIncEm() == null) funcionario.setFuncioIncEm(now);
        
        pessoa = pessoaRepository.save(pessoa);
        
        Funcionario saved = funcionarioRepository.save(funcionario);
        saved.setPessoa(pessoa);
        
        return toDTO(saved);
    }

    public FuncionarioDTO update(FuncionarioDTO dto) {
        if (dto.getPesId() != null) {
            return funcionarioRepository.findByPessoaPesId(dto.getPesId()).map(existing -> {
                Funcionario incoming = toEntity(dto);
                Pessoa existingPessoa = existing.getPessoa();
                Pessoa incomingPessoa = incoming.getPessoa();

                existingPessoa.setPesNom(incomingPessoa.getPesNom());
                existingPessoa.setPesCpf(incomingPessoa.getPesCpf());
                existingPessoa.setPesCnpj(incomingPessoa.getPesCnpj());
                existingPessoa.setPesEmail(incomingPessoa.getPesEmail());
                existingPessoa.setPesEnd(incomingPessoa.getPesEnd());
                existingPessoa.setMunicipio(incomingPessoa.getMunicipio());
                existingPessoa.setEmpresa(incomingPessoa.getEmpresa());
                existingPessoa.setPesFisJur(incomingPessoa.getPesFisJur());
                existingPessoa.setPesTelPesDDD(incomingPessoa.getPesTelPesDDD());
                existingPessoa.setPesTelPes(incomingPessoa.getPesTelPes());
                existingPessoa.setPesTelComDDD(incomingPessoa.getPesTelComDDD());
                existingPessoa.setPesTelCom(incomingPessoa.getPesTelCom());
                existingPessoa.setPesCelPesDDD(incomingPessoa.getPesCelPesDDD());
                existingPessoa.setPesCelPes(incomingPessoa.getPesCelPes());
                existingPessoa.setPesCelComDDD(incomingPessoa.getPesCelComDDD());
                existingPessoa.setPesCelComPes(incomingPessoa.getPesCelComPes());
                
                LocalDateTime now = LocalDateTime.now();
                existingPessoa.setPesAltPor(incomingPessoa.getPesAltPor());
                existingPessoa.setPesAltEm(now);
                
                pessoaRepository.save(existingPessoa);

                existing.setFuncioObs(incoming.getFuncioObs());
                existing.setFuncioAltPor(incoming.getFuncioAltPor());
                existing.setFuncioAltEm(now);
                
                Funcionario saved = funcionarioRepository.save(existing);
                return toDTO(saved);
            }).orElse(null);
        }
        return null;
    }

    public void delete(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
