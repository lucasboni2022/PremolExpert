package com.premolexpert.api.dto;

public class OrcamentoPedidoEtapaDTO {
    private Integer orcPedId;
    private Integer orcPedEtapa;
    private Integer orcPedAltPor;

    public OrcamentoPedidoEtapaDTO() {
    }

    public OrcamentoPedidoEtapaDTO(Integer orcPedId, Integer orcPedEtapa, Integer orcPedAltPor) {
        this.orcPedId = orcPedId;
        this.orcPedEtapa = orcPedEtapa;
        this.orcPedAltPor = orcPedAltPor;
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

    public Integer getOrcPedAltPor() {
        return orcPedAltPor;
    }

    public void setOrcPedAltPor(Integer orcPedAltPor) {
        this.orcPedAltPor = orcPedAltPor;
    }
}
