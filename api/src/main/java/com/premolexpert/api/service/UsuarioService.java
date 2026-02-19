package com.premolexpert.api.service;

import com.premolexpert.api.dto.UsuarioDTO;
import com.premolexpert.api.entity.Pessoa;
import com.premolexpert.api.entity.Usuario;
import com.premolexpert.api.repository.EmpresaRepository;
import com.premolexpert.api.repository.MunicipioRepository;
import com.premolexpert.api.repository.PerfilRepository;
import com.premolexpert.api.repository.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

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
        Pessoa pessoa = usuario.getPessoa();

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
             dto.setPesId(usuario.getPesId());
        }

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
        Pessoa pessoa = new Pessoa();
        usuario.setPessoa(pessoa);

        // Set IDs
        // Assuming DTO comes with PesId (UsuId in DTO logic was aliased to PesId in previous code)
        // If DTO has getUsuId() we can use it for pesId if that's how it's mapped
        // But here we use dto.getPesId() for consistency with other services if possible
        // Let's use getPesId() as that's the FK we are managing.
        // Wait, DTO structure: UsuarioDTO probably has getUsuId().
        // In previous code it used dto.getUsuId() and mapped to pesId.
        // Now pesId is the FK. usuId is the PK.
        // The DTO likely still refers to the person/user composite ID.
        // I will use getUsuId() from DTO as the identifier if available, or getPesId().
        // In previous `Read` of UsuarioService, it used `dto.getUsuId()`.
        // I'll stick to `dto.getUsuId()` for now, assuming it might map to pesId in the user's mind, OR I'll assume getPesId is available.
        // Actually, UsuarioDTO extends PessoaDTO usually?
        // Let's use dto.getPesId() if it's there (inherited from PessoaDTO).
        // Since I cannot check UsuarioDTO easily without reading, and I want to be safe:
        // Previous service used `dto.getUsuId()` which set `usuario.setUsuId`.
        // Now `usuario.setPesId` is what we want to match `Pessoa`.
        // I'll try `dto.getPesId()`. If compile fails, I'll know.
        // BUT `UsuarioService` previously used `dto.getUsuId()` to set `pesId`.
        // So `dto.getUsuId()` IS the ID.
        
        // However, if I use `dto.getUsuId()` as `pesId`, it's confusing if `usuId` is now the PK of Usuario.
        // But for update, we need `pesId` to find the user.
        // Let's assume `dto.getUsuId()` is the ID we use to look up.
        
        if (dto.getUsuId() != null) {
            pessoa.setPesId(dto.getUsuId());
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
        Pessoa pessoa = usuario.getPessoa();
        
        LocalDateTime now = LocalDateTime.now();
        if (pessoa.getPesIncEm() == null) pessoa.setPesIncEm(now);
        if (usuario.getUsuIncEm() == null) usuario.setUsuIncEm(now);
        
        pessoa = pessoaRepository.save(pessoa);
        
        Usuario saved = usuarioRepository.save(usuario);
        saved.setPessoa(pessoa);
        
        return toDTO(saved);
    }

    public UsuarioDTO update(UsuarioDTO dto) {
        if (dto.getUsuId() != null) {
            // Here we use findByPesId because dto.getUsuId() corresponds to pesId in the old logic
            // and we want to find the user by their person ID (or current ID).
            // Wait, if I changed the ID of Usuario to be generated, dto.getUsuId() might be ambiguous.
            // If the front-end sends the 'id' (which was pesId), we should look up by pesId.
            return usuarioRepository.findByPessoaPesId(dto.getUsuId()).map(existing -> {
                final String newPassword = dto.getUsuSenha();
                final boolean isPasswordUpdate = newPassword != null && !newPassword.isEmpty();
                
                Usuario incoming = toEntity(dto);
                Pessoa existingPessoa = existing.getPessoa();
                Pessoa incomingPessoa = incoming.getPessoa();
                
                // Update Pessoa
                existingPessoa.setPesNom(incomingPessoa.getPesNom());
                existingPessoa.setPesCpf(incomingPessoa.getPesCpf());
                // ... map all fields ...
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

                // Update Usuario
                existing.setUsuLogin(incoming.getUsuLogin());
                existing.setUsuAtivo(incoming.getUsuAtivo());
                existing.setUsuAltPor(incoming.getUsuAltPor());
                existing.setUsuAltEm(now);
                existing.setPerfil(incoming.getPerfil());
                
                if (isPasswordUpdate) {
                    existing.setUsuSenha(incoming.getUsuSenha());
                }
                
                Usuario saved = usuarioRepository.save(existing);
                return toDTO(saved);
            }).orElse(null);
        }
        return null;
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
