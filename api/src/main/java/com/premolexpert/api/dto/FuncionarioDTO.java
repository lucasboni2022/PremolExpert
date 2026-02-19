package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class FuncionarioDTO extends PessoaDTO {

    private String funcioObs;
    private Integer funcioIncPor;
    private LocalDateTime funcioIncEm;
    private Integer funcioAltPor;
    private LocalDateTime funcioAltEm;

    public String getFuncioObs() {
        return funcioObs;
    }

    public void setFuncioObs(String funcioObs) {
        this.funcioObs = funcioObs;
    }

    public Integer getFuncioIncPor() {
        return funcioIncPor;
    }

    public void setFuncioIncPor(Integer funcioIncPor) {
        this.funcioIncPor = funcioIncPor;
    }

    public LocalDateTime getFuncioIncEm() {
        return funcioIncEm;
    }

    public void setFuncioIncEm(LocalDateTime funcioIncEm) {
        this.funcioIncEm = funcioIncEm;
    }

    public Integer getFuncioAltPor() {
        return funcioAltPor;
    }

    public void setFuncioAltPor(Integer funcioAltPor) {
        this.funcioAltPor = funcioAltPor;
    }

    public LocalDateTime getFuncioAltEm() {
        return funcioAltEm;
    }

    public void setFuncioAltEm(LocalDateTime funcioAltEm) {
        this.funcioAltEm = funcioAltEm;
    }
}
