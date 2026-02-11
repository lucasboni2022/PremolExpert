package com.premolexpert.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClienteDTO extends PessoaDTO {

    private String cliObs;
    private Integer cliIncPor;
    private LocalDateTime cliIncEm;
    private Integer cliAltPor;
    private LocalDateTime cliAltEm;
}
