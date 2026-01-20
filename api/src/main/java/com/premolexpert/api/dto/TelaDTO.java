package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class TelaDTO {

    private Integer telId;
    private String telNom;
    private Integer telIncPor;
    private LocalDateTime telIncEm;
    private Integer telAltPor;
    private LocalDateTime telAltEm;

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public String getTelNom() {
        return telNom;
    }

    public void setTelNom(String telNom) {
        this.telNom = telNom;
    }

    public Integer getTelIncPor() {
        return telIncPor;
    }

    public void setTelIncPor(Integer telIncPor) {
        this.telIncPor = telIncPor;
    }

    public LocalDateTime getTelIncEm() {
        return telIncEm;
    }

    public void setTelIncEm(LocalDateTime telIncEm) {
        this.telIncEm = telIncEm;
    }

    public Integer getTelAltPor() {
        return telAltPor;
    }

    public void setTelAltPor(Integer telAltPor) {
        this.telAltPor = telAltPor;
    }

    public LocalDateTime getTelAltEm() {
        return telAltEm;
    }

    public void setTelAltEm(LocalDateTime telAltEm) {
        this.telAltEm = telAltEm;
    }
}
