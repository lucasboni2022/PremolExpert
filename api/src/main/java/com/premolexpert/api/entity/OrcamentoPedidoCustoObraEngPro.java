package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedidocustoobraengpro")
public class OrcamentoPedidoCustoObraEngPro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedidocustoobraengpro_seq")
    @SequenceGenerator(name = "orcamentopedidocustoobraengpro_seq", sequenceName = "tborcamentopedidocustoobraengpro_orcpedcustoobrengproid_seq", allocationSize = 1)
    @Column(name = "orcpedcustoobrengproid", nullable = false)
    private Integer orcPedCustoObrEngProId;

    @ManyToOne
    @JoinColumn(name = "orcpedcustoobrengid")
    private OrcamentoPedidoCustoObraEng orcPedCustoObrEng;

    @Column(name = "orcpedcustoobrengproproduto")
    private String orcPedCustoObrEngProProduto;

    @Column(name = "orcpedcustoobrengproqtd")
    private Integer orcPedCustoObrEngProQtd;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    @Column(name = "orcpedcustoobrengproincpor")
    private Integer orcPedCustoObrEngProIncPor;

    @Column(name = "orcpedcustoobrengproincem")
    private LocalDateTime orcPedCustoObrEngProIncEm;

    @Column(name = "orcpedcustoobrengproaltpor")
    private Integer orcPedCustoObrEngProAltPor;

    @Column(name = "orcpedcustoobrengproaltem")
    private LocalDateTime orcPedCustoObrEngProAltEm;

    public Integer getOrcPedCustoObrEngProId() {
        return orcPedCustoObrEngProId;
    }

    public void setOrcPedCustoObrEngProId(Integer orcPedCustoObrEngProId) {
        this.orcPedCustoObrEngProId = orcPedCustoObrEngProId;
    }

    public OrcamentoPedidoCustoObraEng getOrcPedCustoObrEng() {
        return orcPedCustoObrEng;
    }

    public void setOrcPedCustoObrEng(OrcamentoPedidoCustoObraEng orcPedCustoObrEng) {
        this.orcPedCustoObrEng = orcPedCustoObrEng;
    }

    public String getOrcPedCustoObrEngProProduto() {
        return orcPedCustoObrEngProProduto;
    }

    public void setOrcPedCustoObrEngProProduto(String orcPedCustoObrEngProProduto) {
        this.orcPedCustoObrEngProProduto = orcPedCustoObrEngProProduto;
    }

    public Integer getOrcPedCustoObrEngProQtd() {
        return orcPedCustoObrEngProQtd;
    }

    public void setOrcPedCustoObrEngProQtd(Integer orcPedCustoObrEngProQtd) {
        this.orcPedCustoObrEngProQtd = orcPedCustoObrEngProQtd;
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

    public Integer getOrcPedCustoObrEngProIncPor() {
        return orcPedCustoObrEngProIncPor;
    }

    public void setOrcPedCustoObrEngProIncPor(Integer orcPedCustoObrEngProIncPor) {
        this.orcPedCustoObrEngProIncPor = orcPedCustoObrEngProIncPor;
    }

    public LocalDateTime getOrcPedCustoObrEngProIncEm() {
        return orcPedCustoObrEngProIncEm;
    }

    public void setOrcPedCustoObrEngProIncEm(LocalDateTime orcPedCustoObrEngProIncEm) {
        this.orcPedCustoObrEngProIncEm = orcPedCustoObrEngProIncEm;
    }

    public Integer getOrcPedCustoObrEngProAltPor() {
        return orcPedCustoObrEngProAltPor;
    }

    public void setOrcPedCustoObrEngProAltPor(Integer orcPedCustoObrEngProAltPor) {
        this.orcPedCustoObrEngProAltPor = orcPedCustoObrEngProAltPor;
    }

    public LocalDateTime getOrcPedCustoObrEngProAltEm() {
        return orcPedCustoObrEngProAltEm;
    }

    public void setOrcPedCustoObrEngProAltEm(LocalDateTime orcPedCustoObrEngProAltEm) {
        this.orcPedCustoObrEngProAltEm = orcPedCustoObrEngProAltEm;
    }
}
