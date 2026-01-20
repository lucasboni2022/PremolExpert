package com.premolexpert.api.dto;

import java.time.LocalDateTime;

public class PermissaoAcessoDTO {

    private Integer permAceId;
    private Integer perId;
    private String perNom;
    private Integer telId;
    private String telNom;
    private Integer acaId;
    private String acaNom;
    private Integer usuId;
    private String usuLogin;
    private Integer permAceSta;
    private Integer permAceIncPor;
    private LocalDateTime permAceIncEm;
    private Integer permAceAltPor;
    private LocalDateTime permAceAltEm;

    public Integer getPermAceId() {
        return permAceId;
    }

    public void setPermAceId(Integer permAceId) {
        this.permAceId = permAceId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNom() {
        return perNom;
    }

    public void setPerNom(String perNom) {
        this.perNom = perNom;
    }

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

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public Integer getPermAceSta() {
        return permAceSta;
    }

    public void setPermAceSta(Integer permAceSta) {
        this.permAceSta = permAceSta;
    }

    public Integer getPermAceIncPor() {
        return permAceIncPor;
    }

    public void setPermAceIncPor(Integer permAceIncPor) {
        this.permAceIncPor = permAceIncPor;
    }

    public LocalDateTime getPermAceIncEm() {
        return permAceIncEm;
    }

    public void setPermAceIncEm(LocalDateTime permAceIncEm) {
        this.permAceIncEm = permAceIncEm;
    }

    public Integer getPermAceAltPor() {
        return permAceAltPor;
    }

    public void setPermAceAltPor(Integer permAceAltPor) {
        this.permAceAltPor = permAceAltPor;
    }

    public LocalDateTime getPermAceAltEm() {
        return permAceAltEm;
    }

    public void setPermAceAltEm(LocalDateTime permAceAltEm) {
        this.permAceAltEm = permAceAltEm;
    }
}
