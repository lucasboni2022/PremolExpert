package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class OrcamentoPedidoHistoricoDTO {

    private Integer orcPedHistId;
    private Integer orcPedId;
    private Integer orcPedEtapa;
    private Integer orcPedHistIncPor;
    private LocalDateTime orcPedHistIncEm;
    private String orcPedHistObs;

    public Integer getOrcPedHistId() {
        return orcPedHistId;
    }

    public void setOrcPedHistId(Integer orcPedHistId) {
        this.orcPedHistId = orcPedHistId;
    }

    public Integer getOrcPedId() {
        return orcPedId;
    }

    public void setOrcPedId(Integer orcPedId) {
        this.orcPedId = orcPedId;
    }

    public Integer getOrcPedEtapa() {
        return orcPedEtapa;
    }

    public void setOrcPedEtapa(Integer orcPedEtapa) {
        this.orcPedEtapa = orcPedEtapa;
    }

    public Integer getOrcPedHistIncPor() {
        return orcPedHistIncPor;
    }

    public void setOrcPedHistIncPor(Integer orcPedHistIncPor) {
        this.orcPedHistIncPor = orcPedHistIncPor;
    }

    public LocalDateTime getOrcPedHistIncEm() {
        return orcPedHistIncEm;
    }

    public void setOrcPedHistIncEm(LocalDateTime orcPedHistIncEm) {
        this.orcPedHistIncEm = orcPedHistIncEm;
    }

    public String getOrcPedHistObs() {
        return orcPedHistObs;
    }

    public void setOrcPedHistObs(String orcPedHistObs) {
        this.orcPedHistObs = orcPedHistObs;
    }
}
