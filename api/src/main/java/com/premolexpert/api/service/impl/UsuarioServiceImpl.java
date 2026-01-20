package com.premolexpert.api.service.impl;

import com.premolexpert.api.dto.UsuarioDTO;
import com.premolexpert.api.entity.Usuario;
import com.premolexpert.api.repository.UsuarioRepository;
import com.premolexpert.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioServiceImpl implements PessoaService<UsuarioDTO> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        // Pessoa fields
        usuarioDTO.setPesId(usuario.getPesId());
        usuarioDTO.setPesNom(usuario.getPesNom());
        usuarioDTO.setPesCpf(usuario.getPesCpf());
        usuarioDTO.setPesCnpj(usuario.getPesCnpj());
        usuarioDTO.setPesEmail(usuario.getPesEmail());
        usuarioDTO.setPesEnd(usuario.getPesEnd());
        usuarioDTO.setMunId(usuario.getMunId());
        usuarioDTO.setEmpId(usuario.getEmpId());
        usuarioDTO.setPesFisJur(usuario.getPesFisJur());
        usuarioDTO.setPesTelPesDDD(usuario.getPesTelPesDDD());
        usuarioDTO.setPesTelPes(usuario.getPesTelPes());
        usuarioDTO.setPesTelComDDD(usuario.getPesTelComDDD());
        usuarioDTO.setPesTelCom(usuario.getPesTelCom());
        usuarioDTO.setPesCelPesDDD(usuario.getPesCelPesDDD());
        usuarioDTO.setPesCelPes(usuario.getPesCelPes());
        usuarioDTO.setPesCelComDDD(usuario.getPesCelComDDD());
        usuarioDTO.setPesCelComPes(usuario.getPesCelComPes());
        usuarioDTO.setPesIncPor(usuario.getPesIncPor());
        usuarioDTO.setPesIncEm(usuario.getPesIncEm());
        usuarioDTO.setPesAltPor(usuario.getPesAltPor());
        usuarioDTO.setPesAltEm(usuario.getPesAltEm());

        // Usuario fields
        usuarioDTO.setUsuLogin(usuario.getUsuLogin());
        usuarioDTO.setUsuSenha(usuario.getUsuSenha());
        usuarioDTO.setUsuAtivo(usuario.getUsuAtivo());
        usuarioDTO.setUsuIncPor(usuario.getUsuIncPor());
        usuarioDTO.setUsuIncEm(usuario.getUsuIncEm());
        usuarioDTO.setUsuAltPor(usuario.getUsuAltPor());
        usuarioDTO.setUsuAltEm(usuario.getUsuAltEm());
        usuarioDTO.setPerId(usuario.getPerId());
        return usuarioDTO;
    }

    private Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        // Pessoa fields
        usuario.setPesId(usuarioDTO.getPesId());
        usuario.setPesNom(usuarioDTO.getPesNom());
        usuario.setPesCpf(usuarioDTO.getPesCpf());
        usuario.setPesCnpj(usuarioDTO.getPesCnpj());
        usuario.setPesEmail(usuarioDTO.getPesEmail());
        usuario.setPesEnd(usuarioDTO.getPesEnd());
        usuario.setMunId(usuarioDTO.getMunId());
        usuario.setEmpId(usuarioDTO.getEmpId());
        usuario.setPesFisJur(usuarioDTO.getPesFisJur());
        usuario.setPesTelPesDDD(usuarioDTO.getPesTelPesDDD());
        usuario.setPesTelPes(usuarioDTO.getPesTelPes());
        usuario.setPesTelComDDD(usuarioDTO.getPesTelComDDD());
        usuario.setPesTelCom(usuarioDTO.getPesTelCom());
        usuario.setPesCelPesDDD(usuarioDTO.getPesCelPesDDD());
        usuario.setPesCelPes(usuarioDTO.getPesCelPes());
        usuario.setPesCelComDDD(usuarioDTO.getPesCelComDDD());
        usuario.setPesCelComPes(usuarioDTO.getPesCelComPes());
        usuario.setPesIncPor(usuarioDTO.getPesIncPor());
        usuario.setPesIncEm(usuarioDTO.getPesIncEm());
        usuario.setPesAltPor(usuarioDTO.getPesAltPor());
        usuario.setPesAltEm(usuarioDTO.getPesAltEm());

        // Usuario fields
        usuario.setUsuLogin(usuarioDTO.getUsuLogin());
        usuario.setUsuSenha(usuarioDTO.getUsuSenha());
        usuario.setUsuAtivo(usuarioDTO.getUsuAtivo());
        usuario.setUsuIncPor(usuarioDTO.getUsuIncPor());
        usuario.setUsuIncEm(usuarioDTO.getUsuIncEm());
        usuario.setUsuAltPor(usuarioDTO.getUsuAltPor());
        usuario.setUsuAltEm(usuarioDTO.getUsuAltEm());
        usuario.setPerId(usuarioDTO.getPerId());
        return usuario;
    }

    @Override
    public Page<UsuarioDTO> getAll(int page, int size) {
        Page<Usuario> usuarios = usuarioRepository.findAll(PageRequest.of(page, size));
        return usuarios.map(this::toDTO);
    }

    @Override
    public UsuarioDTO getById(Integer id) {
        return usuarioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        usuarioDTO.setPesId(null);
        Usuario usuario = toEntity(usuarioDTO);
        
        if (usuario.getUsuSenha() != null && !usuario.getUsuSenha().isEmpty()) {
            usuario.setUsuSenha(passwordEncoder.encode(usuario.getUsuSenha()));
        }

        if (usuario.getUsuAtivo() == null) {
            usuario.setUsuAtivo(true);
        }

        LocalDateTime now = LocalDateTime.now();
        
        if (usuario.getPesIncEm() == null) usuario.setPesIncEm(now);
        usuario.setPesAltEm(now);

        if (usuario.getUsuIncEm() == null) usuario.setUsuIncEm(now);
        usuario.setUsuAltEm(now);

        Usuario saved = usuarioRepository.save(usuario);
        return toDTO(saved);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getPesId() != null && usuarioRepository.existsById(usuarioDTO.getPesId())) {
            Usuario usuario = toEntity(usuarioDTO);
            
            Usuario existing = usuarioRepository.findById(usuarioDTO.getPesId()).orElse(null);
            if (existing != null) {
                if (usuario.getPesIncEm() == null) usuario.setPesIncEm(existing.getPesIncEm());
                if (usuario.getUsuIncEm() == null) usuario.setUsuIncEm(existing.getUsuIncEm());
                
                if (usuario.getUsuAtivo() == null) {
                    usuario.setUsuAtivo(existing.getUsuAtivo());
                }

                // If password is not provided in DTO (or empty), keep existing
                // If provided, encode it
                if (usuarioDTO.getUsuSenha() == null || usuarioDTO.getUsuSenha().isEmpty()) {
                    usuario.setUsuSenha(existing.getUsuSenha());
                } else {
                    usuario.setUsuSenha(passwordEncoder.encode(usuarioDTO.getUsuSenha()));
                }
            }

            LocalDateTime now = LocalDateTime.now();
            usuario.setPesAltEm(now);
            usuario.setUsuAltEm(now);

            Usuario saved = usuarioRepository.save(usuario);
            return toDTO(saved);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
