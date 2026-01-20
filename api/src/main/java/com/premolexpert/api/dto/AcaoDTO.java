package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class AcaoDTO {

    private Integer acaId;
    private String acaNom;
    private Integer acaIncPor;
    private LocalDateTime acaIncEm;
    private Integer acaAltPor;
    private LocalDateTime acaAltEm;

    public Integer getAcaId() {
        return acaId;
    }

    public void setAcaId(Integer acaId) {
        this.acaId = acaId;
    }

    public String getAcaNom() {
        return acaNom;
    }

    public void setAcaNom(String acaNom) {
        this.acaNom = acaNom;
    }

    public Integer getAcaIncPor() {
        return acaIncPor;
    }

    public void setAcaIncPor(Integer acaIncPor) {
        this.acaIncPor = acaIncPor;
    }

    public LocalDateTime getAcaIncEm() {
        return acaIncEm;
    }

    public void setAcaIncEm(LocalDateTime acaIncEm) {
        this.acaIncEm = acaIncEm;
    }

    public Integer getAcaAltPor() {
        return acaAltPor;
    }

    public void setAcaAltPor(Integer acaAltPor) {
        this.acaAltPor = acaAltPor;
    }

    public LocalDateTime getAcaAltEm() {
        return acaAltEm;
    }

    public void setAcaAltEm(LocalDateTime acaAltEm) {
        this.acaAltEm = acaAltEm;
    }
}
