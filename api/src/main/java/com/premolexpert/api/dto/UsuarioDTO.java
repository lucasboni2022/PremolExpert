package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class UsuarioDTO extends PessoaDTO {

    private String usuLogin;
    private String usuSenha;
    private Boolean usuAtivo;
    private Integer usuIncPor;
    private LocalDateTime usuIncEm;
    private Integer usuAltPor;
    private LocalDateTime usuAltEm;
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

    public Integer getUsuId() {
        return getPesId();
    }

    public void setUsuId(Integer usuId) {
        setPesId(usuId);
    }
}
