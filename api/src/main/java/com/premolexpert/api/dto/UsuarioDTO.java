package com.premolexpert.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuarioDTO extends PessoaDTO {

    private String usuLogin;
    private String usuSenha;
    private Boolean usuAtivo;
    private Integer usuIncPor;
    private LocalDateTime usuIncEm;
    private Integer usuAltPor;
    private LocalDateTime usuAltEm;
    private Integer perId;

    public Integer getUsuId() {
        return getPesId();
    }

    public void setUsuId(Integer usuId) {
        setPesId(usuId);
    }
}
