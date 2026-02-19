package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbacao")
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acao_seq")
    @SequenceGenerator(name = "acao_seq", sequenceName = "tbacao_acaid_seq", allocationSize = 1)
    @Column(name = "acaid", nullable = false)
    private Integer acaId;

    @Column(name = "acanom", length = 100, nullable = false)
    private String acaNom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "acaincpor")
    private Integer acaIncPor;

    @Column(name = "acaincem")
    private LocalDateTime acaIncEm;

    @Column(name = "acaaltpor")
    private Integer acaAltPor;

    @Column(name = "acaaltem")
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getEmpId() {
        return empresa != null ? empresa.getEmpId() : null;
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
