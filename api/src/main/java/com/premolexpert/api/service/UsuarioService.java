package com.premolexpert.api.service;

import com.premolexpert.api.dto.UsuarioDTO;
import com.premolexpert.api.entity.Usuario;
import com.premolexpert.api.repository.EmpresaRepository;
import com.premolexpert.api.repository.MunicipioRepository;
import com.premolexpert.api.repository.PerfilRepository;
import com.premolexpert.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();

        // Pessoa fields
        dto.setPesId(usuario.getUsuId());
        dto.setPesNom(usuario.getPesNom());
        dto.setPesCpf(usuario.getPesCpf());
        dto.setPesCnpj(usuario.getPesCnpj());
        dto.setPesEmail(usuario.getPesEmail());
        dto.setPesEnd(usuario.getPesEnd());
        
        if (usuario.getMunicipio() != null) {
            dto.setMunId(usuario.getMunicipio().getMunId());
        }
        
        if (usuario.getEmpresa() != null) {
            dto.setEmpId(usuario.getEmpresa().getEmpId());
        }

        dto.setPesFisJur(usuario.getPesFisJur());
        dto.setPesTelPesDDD(usuario.getPesTelPesDDD());
        dto.setPesTelPes(usuario.getPesTelPes());
        dto.setPesTelComDDD(usuario.getPesTelComDDD());
        dto.setPesTelCom(usuario.getPesTelCom());
        dto.setPesCelPesDDD(usuario.getPesCelPesDDD());
        dto.setPesCelPes(usuario.getPesCelPes());
        dto.setPesCelComDDD(usuario.getPesCelComDDD());
        dto.setPesCelComPes(usuario.getPesCelComPes());
        dto.setPesIncPor(usuario.getPesIncPor());
        dto.setPesIncEm(usuario.getPesIncEm());
        dto.setPesAltPor(usuario.getPesAltPor());
        dto.setPesAltEm(usuario.getPesAltEm());

        // Usuario fields
        dto.setUsuLogin(usuario.getUsuLogin());
        // Do not return password in DTO
        dto.setUsuAtivo(usuario.getUsuAtivo());
        dto.setUsuIncPor(usuario.getUsuIncPor());
        dto.setUsuIncEm(usuario.getUsuIncEm());
        dto.setUsuAltPor(usuario.getUsuAltPor());
        dto.setUsuAltEm(usuario.getUsuAltEm());
        
        if (usuario.getPerfil() != null) {
            dto.setPerId(usuario.getPerfil().getPerId());
        }

        return dto;
    }

    private Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();

        // Pessoa fields
        usuario.setUsuId(dto.getUsuId());
        usuario.setPesNom(dto.getPesNom());
        usuario.setPesCpf(dto.getPesCpf());
        usuario.setPesCnpj(dto.getPesCnpj());
        usuario.setPesEmail(dto.getPesEmail());
        usuario.setPesEnd(dto.getPesEnd());
        
        if (dto.getMunId() != null) {
            municipioRepository.findById(dto.getMunId())
                .ifPresent(usuario::setMunicipio);
        }
        
        if (dto.getEmpId() != null) {
            empresaRepository.findById(dto.getEmpId())
                .ifPresent(usuario::setEmpresa);
        }

        usuario.setPesFisJur(dto.getPesFisJur());
        usuario.setPesTelPesDDD(dto.getPesTelPesDDD());
        usuario.setPesTelPes(dto.getPesTelPes());
        usuario.setPesTelComDDD(dto.getPesTelComDDD());
        usuario.setPesTelCom(dto.getPesTelCom());
        usuario.setPesCelPesDDD(dto.getPesCelPesDDD());
        usuario.setPesCelPes(dto.getPesCelPes());
        usuario.setPesCelComDDD(dto.getPesCelComDDD());
        usuario.setPesCelComPes(dto.getPesCelComPes());
        usuario.setPesIncPor(dto.getPesIncPor());
        usuario.setPesIncEm(dto.getPesIncEm());
        usuario.setPesAltPor(dto.getPesAltPor());
        usuario.setPesAltEm(dto.getPesAltEm());

        // Usuario fields
        usuario.setUsuLogin(dto.getUsuLogin());
        if (dto.getUsuSenha() != null && !dto.getUsuSenha().isEmpty()) {
            usuario.setUsuSenha(passwordEncoder.encode(dto.getUsuSenha()));
        }
        usuario.setUsuAtivo(dto.getUsuAtivo());
        usuario.setUsuIncPor(dto.getUsuIncPor());
        usuario.setUsuIncEm(dto.getUsuIncEm());
        usuario.setUsuAltPor(dto.getUsuAltPor());
        usuario.setUsuAltEm(dto.getUsuAltEm());
        
        if (dto.getPerId() != null) {
            perfilRepository.findById(dto.getPerId())
                .ifPresent(usuario::setPerfil);
        }

        return usuario;
    }

    public Page<UsuarioDTO> getAll(int page, int size) {
        return usuarioRepository.findAll(PageRequest.of(page, size))
                .map(this::toDTO);
    }

    public UsuarioDTO getById(Integer id) {
        return usuarioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public UsuarioDTO create(UsuarioDTO dto) {
        dto.setUsuId(null);
        Usuario usuario = toEntity(dto);
        
        LocalDateTime now = LocalDateTime.now();
        if (usuario.getPesIncEm() == null) usuario.setPesIncEm(now);
        if (usuario.getUsuIncEm() == null) usuario.setUsuIncEm(now);
        
        Usuario saved = usuarioRepository.save(usuario);
        return toDTO(saved);
    }

    public UsuarioDTO update(UsuarioDTO dto) {
        if (dto.getPesId() != null && usuarioRepository.existsById(dto.getPesId())) {
            // Need to preserve password if not provided
            final String newPassword = dto.getUsuSenha();
            final boolean isPasswordUpdate = newPassword != null && !newPassword.isEmpty();
            
            Usuario usuario = toEntity(dto);
            
            usuarioRepository.findById(dto.getPesId()).ifPresent(existing -> {
                if (usuario.getPesIncEm() == null) usuario.setPesIncEm(existing.getPesIncEm());
                if (usuario.getUsuIncEm() == null) usuario.setUsuIncEm(existing.getUsuIncEm());
                
                if (!isPasswordUpdate) {
                    usuario.setUsuSenha(existing.getUsuSenha());
                }
            });

            LocalDateTime now = LocalDateTime.now();
            usuario.setPesAltEm(now);
            usuario.setUsuAltEm(now);
            
            Usuario saved = usuarioRepository.save(usuario);
            return toDTO(saved);
        }
        return null;
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
