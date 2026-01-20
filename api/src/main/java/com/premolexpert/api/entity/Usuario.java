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
@PrimaryKeyJoinColumn(name = "usuid")
public class Usuario extends Pessoa implements UserDetails {

    @Column(name = "usulogin", length = 50, nullable = false, unique = true)
    private String usuLogin;

    @Column(name = "ususenha", length = 255)
    private String usuSenha;


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

    @Column(name = "perid")
    private Integer perId;

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

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
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
