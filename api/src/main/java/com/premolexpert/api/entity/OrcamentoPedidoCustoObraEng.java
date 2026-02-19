package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedidocustoobraeng")
public class OrcamentoPedidoCustoObraEng {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedidocustoobraeng_seq")
    @SequenceGenerator(name = "orcamentopedidocustoobraeng_seq", sequenceName = "tborcamentopedidocustoobraeng_orcpedcustoobrengid_seq", allocationSize = 1)
    @Column(name = "orcpedcustoobrengid", nullable = false)
    private Integer orcPedCustoObrEngId;

    @ManyToOne
    @JoinColumn(name = "orcpedcustoobrid")
    private OrcamentoPedidoCustoObra orcPedCustoObr;

    @Column(name = "orcpedcustoobrengqtdafazer")
    private Integer orcPedCustoObrEngQtdAFazer;

    @Column(name = "orcpedcustoobrengqtdlibparfabr")
    private Integer orcPedCustoObrEngQtdLibParFabr;

    @Column(name = "orcpedcustoobrengencLote")
    private Integer orcPedCustoObrEngLote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;


    @Column(name = "orcpedcustoobrengincpor")
    private Integer orcPedCustoObrEngIncPor;

    @Column(name = "orcpedcustoobrengincem")
    private LocalDateTime orcPedCustoObrEngIncEm;

    @Column(name = "orcpedcustoobrengaltpor")
    private Integer orcPedCustoObrEngAltPor;

    @Column(name = "orcpedcustoobrengaltem")
    private LocalDateTime orcPedCustoObrEngAltEm;

    public Integer getOrcPedCustoObrEngId() {
        return orcPedCustoObrEngId;
    }

    public void setOrcPedCustoObrEngId(Integer orcPedCustoObrEngId) {
        this.orcPedCustoObrEngId = orcPedCustoObrEngId;
    }

    public OrcamentoPedidoCustoObra getOrcPedCustoObr() {
        return orcPedCustoObr;
    }

    public void setOrcPedCustoObr(OrcamentoPedidoCustoObra orcPedCustoObr) {
        this.orcPedCustoObr = orcPedCustoObr;
    }

    public Integer getOrcPedCustoObrEngQtdAFazer() {
        return orcPedCustoObrEngQtdAFazer;
    }

    public void setOrcPedCustoObrEngQtdAFazer(Integer orcPedCustoObrEngQtdAFazer) {
        this.orcPedCustoObrEngQtdAFazer = orcPedCustoObrEngQtdAFazer;
    }

    public Integer getOrcPedCustoObrEngQtdLibParFabr() {
        return orcPedCustoObrEngQtdLibParFabr;
    }

    public void setOrcPedCustoObrEngQtdLibParFabr(Integer orcPedCustoObrEngQtdLibParFabr) {
        this.orcPedCustoObrEngQtdLibParFabr = orcPedCustoObrEngQtdLibParFabr;
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

    public Integer getOrcPedCustoObrEngLote() {
        return orcPedCustoObrEngLote;
    }

    public void setOrcPedCustoObrEngLote(Integer orcPedCustoObrEngLote) {
        this.orcPedCustoObrEngLote = orcPedCustoObrEngLote;
    }

    public Integer getOrcPedCustoObrEngIncPor() {
        return orcPedCustoObrEngIncPor;
    }

    public void setOrcPedCustoObrEngIncPor(Integer orcPedCustoObrEngIncPor) {
        this.orcPedCustoObrEngIncPor = orcPedCustoObrEngIncPor;
    }

    public LocalDateTime getOrcPedCustoObrEngIncEm() {
        return orcPedCustoObrEngIncEm;
    }

    public void setOrcPedCustoObrEngIncEm(LocalDateTime orcPedCustoObrEngIncEm) {
        this.orcPedCustoObrEngIncEm = orcPedCustoObrEngIncEm;
    }

    public Integer getOrcPedCustoObrEngAltPor() {
        return orcPedCustoObrEngAltPor;
    }

    public void setOrcPedCustoObrEngAltPor(Integer orcPedCustoObrEngAltPor) {
        this.orcPedCustoObrEngAltPor = orcPedCustoObrEngAltPor;
    }

    public LocalDateTime getOrcPedCustoObrEngAltEm() {
        return orcPedCustoObrEngAltEm;
    }

    public void setOrcPedCustoObrEngAltEm(LocalDateTime orcPedCustoObrEngAltEm) {
        this.orcPedCustoObrEngAltEm = orcPedCustoObrEngAltEm;
    }
}
