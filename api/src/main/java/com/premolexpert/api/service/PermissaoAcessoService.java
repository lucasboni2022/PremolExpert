package com.premolexpert.api.service;

import com.premolexpert.api.dto.PermissaoAcessoDTO;
import com.premolexpert.api.entity.PermissaoAcesso;
import com.premolexpert.api.repository.PermissaoAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissaoAcessoService {

    @Autowired
    private PermissaoAcessoRepository permissaoAcessoRepository;

    @Autowired
    private com.premolexpert.api.repository.PerfilRepository perfilRepository;

    @Autowired
    private com.premolexpert.api.repository.TelaRepository telaRepository;

    @Autowired
    private com.premolexpert.api.repository.AcaoRepository acaoRepository;

    @Autowired
    private com.premolexpert.api.repository.UsuarioRepository usuarioRepository;

    public Page<PermissaoAcessoDTO> getAll(int page, int size) {
        return permissaoAcessoRepository.findAll(PageRequest.of(page, size)).map(this::toDTO);
    }

    public PermissaoAcessoDTO getById(Integer id) {
        return permissaoAcessoRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public List<PermissaoAcessoDTO> createAll(List<PermissaoAcessoDTO> dtos) {
        LocalDateTime now = LocalDateTime.now();
        List<PermissaoAcesso> entities = dtos.stream().map(dto -> {
            dto.setPermAceId(null);
            PermissaoAcesso entity = toEntity(dto);
            entity.setPermAceIncEm(now);
            entity.setPermAceIncPor(dto.getPermAceIncPor());
            entity.setPermAceAltEm(null);
            entity.setPermAceAltPor(null);
            return entity;
        }).collect(Collectors.toList());
        
        return permissaoAcessoRepository.saveAll(entities).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PermissaoAcessoDTO create(PermissaoAcessoDTO permissaoAcessoDTO) {
        permissaoAcessoDTO.setPermAceId(null);
        PermissaoAcesso permissaoAcesso = toEntity(permissaoAcessoDTO);
        
        LocalDateTime now = LocalDateTime.now();
        permissaoAcesso.setPermAceIncEm(now);
        permissaoAcesso.setPermAceIncPor(permissaoAcessoDTO.getPermAceIncPor());
        permissaoAcesso.setPermAceAltEm(null);
        permissaoAcesso.setPermAceAltPor(null);

        PermissaoAcesso saved = permissaoAcessoRepository.save(permissaoAcesso);
        return toDTO(saved);
    }

    public PermissaoAcessoDTO update(PermissaoAcessoDTO permissaoAcessoDTO) {
        if (permissaoAcessoDTO.getPermAceId() == null || !permissaoAcessoRepository.existsById(permissaoAcessoDTO.getPermAceId())) {
            return null;
        }
        PermissaoAcesso permissaoAcesso = toEntity(permissaoAcessoDTO);
        
        PermissaoAcesso existing = permissaoAcessoRepository.findById(permissaoAcessoDTO.getPermAceId()).orElse(null);
        if (existing != null) {
            permissaoAcesso.setPermAceIncEm(existing.getPermAceIncEm());
            permissaoAcesso.setPermAceIncPor(existing.getPermAceIncPor());
        }

        LocalDateTime now = LocalDateTime.now();
        permissaoAcesso.setPermAceAltEm(now);
        permissaoAcesso.setPermAceAltPor(permissaoAcessoDTO.getPermAceAltPor());

        PermissaoAcesso saved = permissaoAcessoRepository.save(permissaoAcesso);
        return toDTO(saved);
    }

    public void delete(Integer id) {
        permissaoAcessoRepository.deleteById(id);
    }

    private PermissaoAcessoDTO toDTO(PermissaoAcesso permissaoAcesso) {
        PermissaoAcessoDTO permissaoAcessoDTO = new PermissaoAcessoDTO();
        permissaoAcessoDTO.setPermAceId(permissaoAcesso.getPermAceId());
        
        if (permissaoAcesso.getPerfil() != null) {
            permissaoAcessoDTO.setPerId(permissaoAcesso.getPerfil().getPerId());
            permissaoAcessoDTO.setPerNom(permissaoAcesso.getPerfil().getPerNom());
        }
        
        if (permissaoAcesso.getTela() != null) {
            permissaoAcessoDTO.setTelId(permissaoAcesso.getTela().getTelId());
            permissaoAcessoDTO.setTelNom(permissaoAcesso.getTela().getTelNom());
        }
        
        if (permissaoAcesso.getAcao() != null) {
            permissaoAcessoDTO.setAcaId(permissaoAcesso.getAcao().getAcaId());
            permissaoAcessoDTO.setAcaNom(permissaoAcesso.getAcao().getAcaNom());
        }
        
        if (permissaoAcesso.getUsuario() != null) {
            permissaoAcessoDTO.setUsuId(permissaoAcesso.getUsuario().getUsuId());
            permissaoAcessoDTO.setUsuLogin(permissaoAcesso.getUsuario().getUsuLogin());
        }

        permissaoAcessoDTO.setPermAceSta(permissaoAcesso.getPermAceSta());
        permissaoAcessoDTO.setPermAceIncPor(permissaoAcesso.getPermAceIncPor());
        permissaoAcessoDTO.setPermAceIncEm(permissaoAcesso.getPermAceIncEm());
        permissaoAcessoDTO.setPermAceAltPor(permissaoAcesso.getPermAceAltPor());
        permissaoAcessoDTO.setPermAceAltEm(permissaoAcesso.getPermAceAltEm());
        return permissaoAcessoDTO;
    }

    private PermissaoAcesso toEntity(PermissaoAcessoDTO permissaoAcessoDTO) {
        PermissaoAcesso permissaoAcesso = new PermissaoAcesso();
        permissaoAcesso.setPermAceId(permissaoAcessoDTO.getPermAceId());
        
        if (permissaoAcessoDTO.getPerId() != null) {
            perfilRepository.findById(permissaoAcessoDTO.getPerId())
                .ifPresent(permissaoAcesso::setPerfil);
        }
        
        if (permissaoAcessoDTO.getTelId() != null) {
            telaRepository.findById(permissaoAcessoDTO.getTelId())
                .ifPresent(permissaoAcesso::setTela);
        }
        
        if (permissaoAcessoDTO.getAcaId() != null) {
            acaoRepository.findById(permissaoAcessoDTO.getAcaId())
                .ifPresent(permissaoAcesso::setAcao);
        }
        
        if (permissaoAcessoDTO.getUsuId() != null) {
            usuarioRepository.findById(permissaoAcessoDTO.getUsuId())
                .ifPresent(permissaoAcesso::setUsuario);
        }

        permissaoAcesso.setPermAceSta(permissaoAcessoDTO.getPermAceSta());
        permissaoAcesso.setPermAceIncPor(permissaoAcessoDTO.getPermAceIncPor());
        permissaoAcesso.setPermAceIncEm(permissaoAcessoDTO.getPermAceIncEm());
        permissaoAcesso.setPermAceAltPor(permissaoAcessoDTO.getPermAceAltPor());
        permissaoAcesso.setPermAceAltEm(permissaoAcessoDTO.getPermAceAltEm());
        return permissaoAcesso;
    }
}