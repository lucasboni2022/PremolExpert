package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedidocustoobra")
public class OrcamentoPedidoCustoObra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedidocustoobra_seq")
    @SequenceGenerator(name = "orcamentopedidocustoobra_seq", sequenceName = "tborcamentopedidocustoobra_orcpedcustoobrid_seq", allocationSize = 1)
    @Column(name = "orcpedcustoobrid", nullable = false)
    private Integer orcPedCustoObrId;

    @Column(name = "orcpedid")
    private Integer orcPedId;

    @Column(name = "sercustoid")
    private Integer serCustoId;

    @Column(name = "uniid")
    private Integer uniId;

    @Column(name = "orcpedcustoobrqtd")
    private Integer orcPedCustoObrQtd;

    @Column(name = "orcpedcustoobrvlrunit", precision = 18, scale = 2)
    private BigDecimal orcPedCustoObrVlrUnit;

    @Column(name = "orcpedcustoobrpron")
    private Integer orcPedCustoObrPron;

    @Column(name = "orcpedcustoobrfaze")
    private Integer orcPedCustoObrFaze;

    @Column(name = "orcpedcustoobrsitua")
    private Integer orcPedCustoObrSitua;

    @Column(name = "orcpedcustoobrtipo", length = 50)
    private String orcPedCustoObrTipo;

    @Column(name = "orcpedcustoobrincpor")
    private Integer orcPedCustoObrIncPor;

    @Column(name = "orcpedcustoobrincem")
    private LocalDateTime orcPedCustoObrIncEm;

    @Column(name = "orcpedcustoobraltpor")
    private Integer orcPedCustoObrAltPor;

    @Column(name = "orcpedcustoobraltem")
    private LocalDateTime orcPedCustoObrAltEm;

    public Integer getOrcPedCustoObrId() {
        return orcPedCustoObrId;
    }

    public void setOrcPedCustoObrId(Integer orcPedCustoObrId) {
        this.orcPedCustoObrId = orcPedCustoObrId;
    }

    public Integer getOrcPedId() {
        return orcPedId;
    }

    public void setOrcPedId(Integer orcPedId) {
        this.orcPedId = orcPedId;
    }

    public Integer getSerCustoId() {
        return serCustoId;
    }

    public void setSerCustoId(Integer serCustoId) {
        this.serCustoId = serCustoId;
    }

    public Integer getUniId() {
        return uniId;
    }

    public void setUniId(Integer uniId) {
        this.uniId = uniId;
    }

    public Integer getOrcPedCustoObrQtd() {
        return orcPedCustoObrQtd;
    }

    public void setOrcPedCustoObrQtd(Integer orcPedCustoObrQtd) {
        this.orcPedCustoObrQtd = orcPedCustoObrQtd;
    }

    public BigDecimal getOrcPedCustoObrVlrUnit() {
        return orcPedCustoObrVlrUnit;
    }

    public void setOrcPedCustoObrVlrUnit(BigDecimal orcPedCustoObrVlrUnit) {
        this.orcPedCustoObrVlrUnit = orcPedCustoObrVlrUnit;
    }

    public Integer getOrcPedCustoObrPron() {
        return orcPedCustoObrPron;
    }

    public void setOrcPedCustoObrPron(Integer orcPedCustoObrPron) {
        this.orcPedCustoObrPron = orcPedCustoObrPron;
    }

    public Integer getOrcPedCustoObrFaze() {
        return orcPedCustoObrFaze;
    }

    public void setOrcPedCustoObrFaze(Integer orcPedCustoObrFaze) {
        this.orcPedCustoObrFaze = orcPedCustoObrFaze;
    }

    public Integer getOrcPedCustoObrSitua() {
        return orcPedCustoObrSitua;
    }

    public void setOrcPedCustoObrSitua(Integer orcPedCustoObrSitua) {
        this.orcPedCustoObrSitua = orcPedCustoObrSitua;
    }

    public String getOrcPedCustoObrTipo() {
        return orcPedCustoObrTipo;
    }

    public void setOrcPedCustoObrTipo(String orcPedCustoObrTipo) {
        this.orcPedCustoObrTipo = orcPedCustoObrTipo;
    }

    public Integer getOrcPedCustoObrIncPor() {
        return orcPedCustoObrIncPor;
    }

    public void setOrcPedCustoObrIncPor(Integer orcPedCustoObrIncPor) {
        this.orcPedCustoObrIncPor = orcPedCustoObrIncPor;
    }

    public LocalDateTime getOrcPedCustoObrIncEm() {
        return orcPedCustoObrIncEm;
    }

    public void setOrcPedCustoObrIncEm(LocalDateTime orcPedCustoObrIncEm) {
        this.orcPedCustoObrIncEm = orcPedCustoObrIncEm;
    }

    public Integer getOrcPedCustoObrAltPor() {
        return orcPedCustoObrAltPor;
    }

    public void setOrcPedCustoObrAltPor(Integer orcPedCustoObrAltPor) {
        this.orcPedCustoObrAltPor = orcPedCustoObrAltPor;
    }

    public LocalDateTime getOrcPedCustoObrAltEm() {
        return orcPedCustoObrAltEm;
    }

    public void setOrcPedCustoObrAltEm(LocalDateTime orcPedCustoObrAltEm) {
        this.orcPedCustoObrAltEm = orcPedCustoObrAltEm;
    }
}
