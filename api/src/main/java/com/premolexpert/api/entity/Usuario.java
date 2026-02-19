package com.premolexpert.api.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbusuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "tbusuario_usuid_seq", allocationSize = 1)
    @Column(name = "usuid")
    private Integer usuId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pesid")
    private Pessoa pessoa;

    @Column(name = "usulogin", length = 50, nullable = false, unique = true)
    private String usuLogin;

    @Column(name = "ususenha", length = 255)
    private String usuSenha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "usuativo")
    private Boolean usuAtivo;

    @Column(name = "usuincpor")
    private Integer usuIncPor;

    @Column(name = "usuincem")
    private LocalDateTime usuIncEm;

    @Column(name = "usualtpor")
    private Integer usuAltPor;

    @Column(name = "usualtem")
    private LocalDateTime usuAltEm;

    @ManyToOne
    @JoinColumn(name = "perid")
    private Perfil perfil;

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getPesId() {
        return pessoa != null ? pessoa.getPesId() : null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getEmpId() {
        return empresa != null ? empresa.getEmpId() : null;
    }

    public Boolean getUsuAtivo() {
        return usuAtivo;
    }

    public void setUsuAtivo(Boolean usuAtivo) {
        this.usuAtivo = usuAtivo;
    }

    public Integer getUsuIncPor() {
        return usuIncPor;
    }

    public void setUsuIncPor(Integer usuIncPor) {
        this.usuIncPor = usuIncPor;
    }

    public LocalDateTime getUsuIncEm() {
        return usuIncEm;
    }

    public void setUsuIncEm(LocalDateTime usuIncEm) {
        this.usuIncEm = usuIncEm;
    }

    public Integer getUsuAltPor() {
        return usuAltPor;
    }

    public void setUsuAltPor(Integer usuAltPor) {
        this.usuAltPor = usuAltPor;
    }

    public LocalDateTime getUsuAltEm() {
        return usuAltEm;
    }

    public void setUsuAltEm(LocalDateTime usuAltEm) {
        this.usuAltEm = usuAltEm;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Se o usuário tem um perfil, retorna as autoridades baseadas no perfil
        if (this.perfil != null) {
            return List.of(new SimpleGrantedAuthority("ROLE_" + this.perfil.getPerNom().toUpperCase().replace(" ", "_")));
        }
        // Caso contrário, retorna ROLE_USER como padrão
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return usuSenha;
    }

    @Override
    public String getUsername() {
        return usuLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE.equals(usuAtivo);
    }
}
