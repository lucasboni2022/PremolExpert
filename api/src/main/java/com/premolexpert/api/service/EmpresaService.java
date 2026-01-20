package com.premolexpert.api.service;

import com.premolexpert.api.dto.EmpresaDTO;
import com.premolexpert.api.entity.Empresa;
import com.premolexpert.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    private EmpresaDTO toDTO(Empresa empresa) {
        return new EmpresaDTO(
                empresa.getEmpId(),
                empresa.getEmpNom(),
                empresa.getEmpIncPor(),
                empresa.getEmpIncEm(),
                empresa.getEmpAltPor(),
                empresa.getEmpAltEm()
        );
    }

    private Empresa toEntity(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setEmpId(empresaDTO.getEmpId());
        empresa.setEmpNom(empresaDTO.getEmpNom());
        empresa.setEmpIncPor(empresaDTO.getEmpIncPor());
        empresa.setEmpIncEm(empresaDTO.getEmpIncEm());
        empresa.setEmpAltPor(empresaDTO.getEmpAltPor());
        empresa.setEmpAltEm(empresaDTO.getEmpAltEm());
        return empresa;
    }

    public Page<EmpresaDTO> getAll(int page, int size) {
        Page<Empresa> empresas = empresaRepository.findAll(PageRequest.of(page, size));
        return empresas.map(this::toDTO);
    }

    public EmpresaDTO getById(Integer id) {
        return empresaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public EmpresaDTO create(EmpresaDTO empresaDTO) {
        empresaDTO.setEmpId(null);
        Empresa empresa = toEntity(empresaDTO);
        
        if (empresa.getEmpIncEm() == null) {
            empresa.setEmpIncEm(LocalDateTime.now());
        }
        
        empresa.setEmpAltEm(LocalDateTime.now());
        
        Empresa saved = empresaRepository.save(empresa);
        return toDTO(saved);
    }

    public EmpresaDTO update(EmpresaDTO empresaDTO) {
        if (empresaDTO.getEmpId() != null && empresaRepository.existsById(empresaDTO.getEmpId())) {
            Empresa empresa = toEntity(empresaDTO);

            if (empresa.getEmpIncEm() == null) {
                 empresaRepository.findById(empresaDTO.getEmpId()).ifPresent(existing -> 
                     empresa.setEmpIncEm(existing.getEmpIncEm())
                 );
            }
            
            empresa.setEmpAltEm(LocalDateTime.now());

            Empresa saved = empresaRepository.save(empresa);
            return toDTO(saved);
        }
        return null;
    }

    public void delete(Integer id) {
        empresaRepository.deleteById(id);
    }
}
