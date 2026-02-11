package com.premolexpert.api.service;

import com.premolexpert.api.dto.FuncionarioDTO;
import com.premolexpert.api.entity.Funcionario;
import com.premolexpert.api.repository.EmpresaRepository;
import com.premolexpert.api.repository.FuncionarioRepository;
import com.premolexpert.api.repository.MunicipioRepository;
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
    private MunicipioRepository municipioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();

        // Pessoa fields
        dto.setPesId(funcionario.getFuncioId());
        dto.setPesNom(funcionario.getPesNom());
        dto.setPesCpf(funcionario.getPesCpf());
        dto.setPesCnpj(funcionario.getPesCnpj());
        dto.setPesEmail(funcionario.getPesEmail());
        dto.setPesEnd(funcionario.getPesEnd());
        
        if (funcionario.getMunicipio() != null) {
            dto.setMunId(funcionario.getMunicipio().getMunId());
        }
        
        if (funcionario.getEmpresa() != null) {
            dto.setEmpId(funcionario.getEmpresa().getEmpId());
        }

        dto.setPesFisJur(funcionario.getPesFisJur());
        dto.setPesTelPesDDD(funcionario.getPesTelPesDDD());
        dto.setPesTelPes(funcionario.getPesTelPes());
        dto.setPesTelComDDD(funcionario.getPesTelComDDD());
        dto.setPesTelCom(funcionario.getPesTelCom());
        dto.setPesCelPesDDD(funcionario.getPesCelPesDDD());
        dto.setPesCelPes(funcionario.getPesCelPes());
        dto.setPesCelComDDD(funcionario.getPesCelComDDD());
        dto.setPesCelComPes(funcionario.getPesCelComPes());
        dto.setPesIncPor(funcionario.getPesIncPor());
        dto.setPesIncEm(funcionario.getPesIncEm());
        dto.setPesAltPor(funcionario.getPesAltPor());
        dto.setPesAltEm(funcionario.getPesAltEm());

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

        // Pessoa fields
        funcionario.setFuncioId(dto.getPesId());
        funcionario.setPesNom(dto.getPesNom());
        funcionario.setPesCpf(dto.getPesCpf());
        funcionario.setPesCnpj(dto.getPesCnpj());
        funcionario.setPesEmail(dto.getPesEmail());
        funcionario.setPesEnd(dto.getPesEnd());
        
        if (dto.getMunId() != null) {
            municipioRepository.findById(dto.getMunId())
                .ifPresent(funcionario::setMunicipio);
        }
        
        if (dto.getEmpId() != null) {
            empresaRepository.findById(dto.getEmpId())
                .ifPresent(funcionario::setEmpresa);
        }

        funcionario.setPesFisJur(dto.getPesFisJur());
        funcionario.setPesTelPesDDD(dto.getPesTelPesDDD());
        funcionario.setPesTelPes(dto.getPesTelPes());
        funcionario.setPesTelComDDD(dto.getPesTelComDDD());
        funcionario.setPesTelCom(dto.getPesTelCom());
        funcionario.setPesCelPesDDD(dto.getPesCelPesDDD());
        funcionario.setPesCelPes(dto.getPesCelPes());
        funcionario.setPesCelComDDD(dto.getPesCelComDDD());
        funcionario.setPesCelComPes(dto.getPesCelComPes());
        funcionario.setPesIncPor(dto.getPesIncPor());
        funcionario.setPesIncEm(dto.getPesIncEm());
        funcionario.setPesAltPor(dto.getPesAltPor());
        funcionario.setPesAltEm(dto.getPesAltEm());

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
        
        LocalDateTime now = LocalDateTime.now();
        if (funcionario.getPesIncEm() == null) funcionario.setPesIncEm(now);
        if (funcionario.getFuncioIncEm() == null) funcionario.setFuncioIncEm(now);
        
        Funcionario saved = funcionarioRepository.save(funcionario);
        return toDTO(saved);
    }

    public FuncionarioDTO update(FuncionarioDTO dto) {
        if (dto.getPesId() != null && funcionarioRepository.existsById(dto.getPesId())) {
            Funcionario funcionario = toEntity(dto);
            
            funcionarioRepository.findById(dto.getPesId()).ifPresent(existing -> {
                if (funcionario.getPesIncEm() == null) funcionario.setPesIncEm(existing.getPesIncEm());
                if (funcionario.getFuncioIncEm() == null) funcionario.setFuncioIncEm(existing.getFuncioIncEm());
            });

            LocalDateTime now = LocalDateTime.now();
            funcionario.setPesAltEm(now);
            funcionario.setFuncioAltEm(now);
            
            Funcionario saved = funcionarioRepository.save(funcionario);
            return toDTO(saved);
        }
        return null;
    }

    public void delete(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
