package com.premolexpert.api.service.impl;

import com.premolexpert.api.dto.FuncionarioDTO;
import com.premolexpert.api.entity.Funcionario;
import com.premolexpert.api.repository.FuncionarioRepository;
import com.premolexpert.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FuncionarioServiceImpl implements PessoaService<FuncionarioDTO> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        // Pessoa fields
        funcionarioDTO.setPesId(funcionario.getPesId());
        funcionarioDTO.setPesNom(funcionario.getPesNom());
        funcionarioDTO.setPesCpf(funcionario.getPesCpf());
        funcionarioDTO.setPesCnpj(funcionario.getPesCnpj());
        funcionarioDTO.setPesEmail(funcionario.getPesEmail());
        funcionarioDTO.setPesEnd(funcionario.getPesEnd());
        funcionarioDTO.setMunId(funcionario.getMunId());
        funcionarioDTO.setEmpId(funcionario.getEmpId());
        funcionarioDTO.setPesFisJur(funcionario.getPesFisJur());
        funcionarioDTO.setPesTelPesDDD(funcionario.getPesTelPesDDD());
        funcionarioDTO.setPesTelPes(funcionario.getPesTelPes());
        funcionarioDTO.setPesTelComDDD(funcionario.getPesTelComDDD());
        funcionarioDTO.setPesTelCom(funcionario.getPesTelCom());
        funcionarioDTO.setPesCelPesDDD(funcionario.getPesCelPesDDD());
        funcionarioDTO.setPesCelPes(funcionario.getPesCelPes());
        funcionarioDTO.setPesCelComDDD(funcionario.getPesCelComDDD());
        funcionarioDTO.setPesCelComPes(funcionario.getPesCelComPes());
        funcionarioDTO.setPesIncPor(funcionario.getPesIncPor());
        funcionarioDTO.setPesIncEm(funcionario.getPesIncEm());
        funcionarioDTO.setPesAltPor(funcionario.getPesAltPor());
        funcionarioDTO.setPesAltEm(funcionario.getPesAltEm());

        // Funcionario fields
        funcionarioDTO.setFuncioObs(funcionario.getFuncioObs());
        funcionarioDTO.setFuncioIncPor(funcionario.getFuncioIncPor());
        funcionarioDTO.setFuncioIncEm(funcionario.getFuncioIncEm());
        funcionarioDTO.setFuncioAltPor(funcionario.getFuncioAltPor());
        funcionarioDTO.setFuncioAltEm(funcionario.getFuncioAltEm());

        return funcionarioDTO;
    }

    private Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        // Pessoa fields
        funcionario.setPesId(funcionarioDTO.getPesId());
        funcionario.setPesNom(funcionarioDTO.getPesNom());
        funcionario.setPesCpf(funcionarioDTO.getPesCpf());
        funcionario.setPesCnpj(funcionarioDTO.getPesCnpj());
        funcionario.setPesEmail(funcionarioDTO.getPesEmail());
        funcionario.setPesEnd(funcionarioDTO.getPesEnd());
        funcionario.setMunId(funcionarioDTO.getMunId());
        funcionario.setEmpId(funcionarioDTO.getEmpId());
        funcionario.setPesFisJur(funcionarioDTO.getPesFisJur());
        funcionario.setPesTelPesDDD(funcionarioDTO.getPesTelPesDDD());
        funcionario.setPesTelPes(funcionarioDTO.getPesTelPes());
        funcionario.setPesTelComDDD(funcionarioDTO.getPesTelComDDD());
        funcionario.setPesTelCom(funcionarioDTO.getPesTelCom());
        funcionario.setPesCelPesDDD(funcionarioDTO.getPesCelPesDDD());
        funcionario.setPesCelPes(funcionarioDTO.getPesCelPes());
        funcionario.setPesCelComDDD(funcionarioDTO.getPesCelComDDD());
        funcionario.setPesCelComPes(funcionarioDTO.getPesCelComPes());
        funcionario.setPesIncPor(funcionarioDTO.getPesIncPor());
        funcionario.setPesIncEm(funcionarioDTO.getPesIncEm());
        funcionario.setPesAltPor(funcionarioDTO.getPesAltPor());
        funcionario.setPesAltEm(funcionarioDTO.getPesAltEm());

        // Funcionario fields
        funcionario.setFuncioObs(funcionarioDTO.getFuncioObs());
        funcionario.setFuncioIncPor(funcionarioDTO.getFuncioIncPor());
        funcionario.setFuncioIncEm(funcionarioDTO.getFuncioIncEm());
        funcionario.setFuncioAltPor(funcionarioDTO.getFuncioAltPor());
        funcionario.setFuncioAltEm(funcionarioDTO.getFuncioAltEm());

        return funcionario;
    }

    public Page<FuncionarioDTO> getAll(int page, int size) {
        Page<Funcionario> funcionarios = funcionarioRepository.findAll(PageRequest.of(page, size));
        return funcionarios.map(this::toDTO);
    }

    @Override
    public FuncionarioDTO getById(Integer id) {
        return funcionarioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public FuncionarioDTO create(FuncionarioDTO funcionarioDTO) {
        funcionarioDTO.setPesId(null);
        Funcionario funcionario = toEntity(funcionarioDTO);

        LocalDateTime now = LocalDateTime.now();

        if (funcionario.getPesIncEm() == null) funcionario.setPesIncEm(now);
        funcionario.setPesAltEm(now);

        if (funcionario.getFuncioIncEm() == null) funcionario.setFuncioIncEm(now);
        funcionario.setFuncioAltEm(now);

        Funcionario saved = funcionarioRepository.save(funcionario);
        return toDTO(saved);
    }

    @Override
    public FuncionarioDTO update(FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.getPesId() != null && funcionarioRepository.existsById(funcionarioDTO.getPesId())) {
            Funcionario funcionario = toEntity(funcionarioDTO);
            LocalDateTime now = LocalDateTime.now();

            funcionarioRepository.findById(funcionarioDTO.getPesId()).ifPresent(existing -> {
                if (funcionario.getPesIncEm() == null) funcionario.setPesIncEm(existing.getPesIncEm());
                if (funcionario.getFuncioIncEm() == null) funcionario.setFuncioIncEm(existing.getFuncioIncEm());
            });

            funcionario.setPesAltEm(now);
            funcionario.setFuncioAltEm(now);

            Funcionario saved = funcionarioRepository.save(funcionario);
            return toDTO(saved);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
