package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbpermissaoacesso")
public class PermissaoAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissaoacesso_seq")
    @SequenceGenerator(name = "permissaoacesso_seq", sequenceName = "tbpermissaoacesso_permaceid_seq", allocationSize = 1)
    @Column(name = "permaceid", nullable = false)
    private Integer permAceId;

    @Column(name = "perid")
    private Integer perId;

    @Column(name = "telid")
    private Integer telId;

    @Column(name = "acaoid")
    private Integer acaoId;

    @Column(name = "usuid")
    private Integer usuId;

    @Column(name = "peracemsta")
    private Integer permAceSta;

    @Column(name = "permaceincpor")
    private Integer permAceIncPor;

    @Column(name = "permaceincem")
    private LocalDateTime permAceIncEm;

    @Column(name = "permacealtpor")
    private Integer permAceAltPor;

    @Column(name = "permacealtem")
    private LocalDateTime permAceAltEm;


    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public Integer getAcaoId() {
        return acaoId;
    }

    public void setAcaoId(Integer acaoId) {
        this.acaoId = acaoId;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getPermAceId() {
        return permAceId;
    }

    public void setPermAceId(Integer permAceId) {
        this.permAceId = permAceId;
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





