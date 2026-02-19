package com.premolexpert.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tborcamentopedidohistorico")
public class OrcamentoPedidoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamentopedidohistorico_seq")
    @SequenceGenerator(name = "orcamentopedidohistorico_seq", sequenceName = "tborcamentopedidohistorico_orcpedhistid_seq", allocationSize = 1)
    @Column(name = "orcpedhistid", nullable = false)
    private Integer orcPedHistId;

    @ManyToOne
    @JoinColumn(name = "orcpedid")
    private OrcamentoPedido orcamentoPedido;

    @Column(name = "orcpedetapa")
    private Integer orcPedEtapa;

    @Column(name = "orcpedhistincpor")
    private Integer orcPedHistIncPor;

    @Column(name = "orcpedhistincem")
    private LocalDateTime orcPedHistIncEm;

    @Column(name = "orcpedhistobs", length = 100)
    private String orcPedHistObs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid", nullable = false)
    private Empresa empresa;

    public Integer getOrcPedHistId() {
        return orcPedHistId;
    }

    public void setOrcPedHistId(Integer orcPedHistId) {
        this.orcPedHistId = orcPedHistId;
    }

    public OrcamentoPedido getOrcamentoPedido() {
        return orcamentoPedido;
    }

    public void setOrcamentoPedido(OrcamentoPedido orcamentoPedido) {
        this.orcamentoPedido = orcamentoPedido;
    }

    public Integer getOrcPedId() {
        return orcamentoPedido != null ? orcamentoPedido.getOrcPedId() : null;
    }

    public Integer getOrcPedEtapa() {
        return orcPedEtapa;
    }

    public void setOrcPedEtapa(Integer orcPedEtapa) {
        this.orcPedEtapa = orcPedEtapa;
    }

    public Integer getOrcPedHistIncPor() {
        return orcPedHistIncPor;
    }

    public void setOrcPedHistIncPor(Integer orcPedHistIncPor) {
        this.orcPedHistIncPor = orcPedHistIncPor;
    }

    public LocalDateTime getOrcPedHistIncEm() {
        return orcPedHistIncEm;
    }

    public void setOrcPedHistIncEm(LocalDateTime orcPedHistIncEm) {
        this.orcPedHistIncEm = orcPedHistIncEm;
    }

    public String getOrcPedHistObs() {
        return orcPedHistObs;
    }

    public void setOrcPedHistObs(String orcPedHistObs) {
        this.orcPedHistObs = orcPedHistObs;
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
}
