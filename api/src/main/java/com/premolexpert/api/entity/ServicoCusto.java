package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbservicocusto")
public class ServicoCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicocusto_seq")
    @SequenceGenerator(name = "servicocusto_seq", sequenceName = "tbservicocusto_sercustoid_seq", allocationSize = 1)
    @Column(name = "sercustoid", nullable = false)
    private Integer serCustoId;

    @Column(name = "serid")
    private Integer serId;

    @Column(name = "sercustonom", length = 200, nullable = false)
    private String serCustoNom;

    @Column(name = "sercustocod", length = 50)
    private String serCustoCod;

    @Column(name = "sercustouni", length = 10)
    private String serCustoUni;

    @Column(name = "sercustovlrunit", precision = 18, scale = 2)
    private BigDecimal serCustoVlrUnit;

    @Column(name = "sercustosta", length = 50)
    private String serCustoSta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "sercustoincem")
    private LocalDateTime serCustoIncEm;

    @Column(name = "sercustoincpor")
    private Integer serCustoIncPor;

    @Column(name = "sercustoaltem")
    private LocalDateTime serCustoAltEm;

    @Column(name = "sercustoaltpor")
    private UUID serCustoAltPor;

    public Integer getSerCustoId() {
        return serCustoId;
    }

    public void setSerCustoId(Integer serCustoId) {
        this.serCustoId = serCustoId;
    }

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerCustoNom() {
        return serCustoNom;
    }

    public void setSerCustoNom(String serCustoNom) {
        this.serCustoNom = serCustoNom;
    }

    public String getSerCustoCod() {
        return serCustoCod;
    }

    public void setSerCustoCod(String serCustoCod) {
        this.serCustoCod = serCustoCod;
    }

    public String getSerCustoUni() {
        return serCustoUni;
    }

    public void setSerCustoUni(String serCustoUni) {
        this.serCustoUni = serCustoUni;
    }

    public BigDecimal getSerCustoVlrUnit() {
        return serCustoVlrUnit;
    }

    public void setSerCustoVlrUnit(BigDecimal serCustoVlrUnit) {
        this.serCustoVlrUnit = serCustoVlrUnit;
    }

    public String getSerCustoSta() {
        return serCustoSta;
    }

    public void setSerCustoSta(String serCustoSta) {
        this.serCustoSta = serCustoSta;
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

    public LocalDateTime getSerCustoIncEm() {
        return serCustoIncEm;
    }

    public void setSerCustoIncEm(LocalDateTime serCustoIncEm) {
        this.serCustoIncEm = serCustoIncEm;
    }

    public Integer getSerCustoIncPor() {
        return serCustoIncPor;
    }

    public void setSerCustoIncPor(Integer serCustoIncPor) {
        this.serCustoIncPor = serCustoIncPor;
    }

    public LocalDateTime getSerCustoAltEm() {
        return serCustoAltEm;
    }

    public void setSerCustoAltEm(LocalDateTime serCustoAltEm) {
        this.serCustoAltEm = serCustoAltEm;
    }

    public UUID getSerCustoAltPor() {
        return serCustoAltPor;
    }

    public void setSerCustoAltPor(UUID serCustoAltPor) {
        this.serCustoAltPor = serCustoAltPor;
    }
}
