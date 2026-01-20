package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class ClienteDTO extends PessoaDTO {
    private String cliObs;
    private Integer cliIncPor;
    private LocalDateTime cliIncEm;
    private Integer cliAltPor;
    private LocalDateTime cliAltEm;

    public ClienteDTO() {
    }

    public String getCliObs() { return cliObs; }
    public void setCliObs(String cliObs) { this.cliObs = cliObs; }

    public Integer getCliIncPor() { return cliIncPor; }
    public void setCliIncPor(Integer cliIncPor) { this.cliIncPor = cliIncPor; }

    public LocalDateTime getCliIncEm() { return cliIncEm; }
    public void setCliIncEm(LocalDateTime cliIncEm) { this.cliIncEm = cliIncEm; }

    public Integer getCliAltPor() { return cliAltPor; }
    public void setCliAltPor(Integer cliAltPor) { this.cliAltPor = cliAltPor; }

    public LocalDateTime getCliAltEm() { return cliAltEm; }
    public void setCliAltEm(LocalDateTime cliAltEm) { this.cliAltEm = cliAltEm; }
}
