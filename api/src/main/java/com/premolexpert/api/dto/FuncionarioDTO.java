package com.premolexpert.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class FuncionarioDTO extends PessoaDTO {

    private String funcioObs;
    private Integer funcioIncPor;
    private LocalDateTime funcioIncEm;
    private Integer funcioAltPor;
    private LocalDateTime funcioAltEm;
}
